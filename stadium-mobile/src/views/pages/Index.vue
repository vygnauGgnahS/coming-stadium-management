<template>
    <div class="list">
        <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
            <van-list v-model:loading="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
                <van-cell v-for="sports in sportsList" :key="sports.id" :title="sports.spName">
                    <template #default="scoped">
                        <div class="list-model">
                            <van-button @click="book({ id: sports.id, name: sports.spName })" size="small" round
                                type="primary">点击预约</van-button>
                        </div>
                    </template>
                </van-cell>
            </van-list>
        </van-pull-refresh>
    </div>

    <van-dialog>

    </van-dialog>


    <van-dialog v-model:show="dialog" @confirm="submitOrder" @closed="closeDialog" title="预约" show-cancel-button>
        <van-cell-group inset>
            {{ rowSports }}
        </van-cell-group>
        <van-form @submit="onSubmit">
            <van-cell-group inset>
                <van-field v-model="date" is-link readonly name="datePicker" label="选择日期" placeholder="点击选择时间"
                    @click="showDatePicker = true" />
                <van-field v-model="timeRange" is-link readonly name="timePicker" label="选择时间" placeholder="点击选择时间"
                    @click="showTimePicker = true" />
                <van-field v-model="areaInfo" is-link readonly name="picker" label="选择场地及陪练" placeholder="点击选择场地及陪练"
                    @click="showPicker = true" />


            </van-cell-group>
            <!-- <div style="margin: 16px;">
                <van-button round block type="primary" native-type="submit">
                    提交
                </van-button>
            </div> -->
        </van-form>
    </van-dialog>

    <van-popup v-model:show="showDatePicker" position="bottom">
        <van-date-picker :min-date="minDate" @confirm="dateConfirm" @cancel="showDatePicker = false" />
    </van-popup>
    <van-popup v-model:show="showTimePicker" position="bottom">
        <van-picker-group title="预约时间" :tabs="['开始时间', '结束时间']" next-step-text="下一步" @confirm="timeConfirm"
            @cancel="Cancel">
            <van-time-picker v-model="start" :max-hour="stHour" :min-hour="8" />
            <van-time-picker v-model="end" :min-hour="enHour" :max-hour="21" />
        </van-picker-group>
    </van-popup>
    <van-popup v-model:show="showPicker" position="bottom">
        <van-picker-group title="选择场地及陪练" :tabs="['选择场地', '选择陪练']" next-step-text="下一步" @confirm="onConfirm"
            @cancel="onCancel">
            <van-time-picker v-model="area" value-key="text" @change="changeArea" :columns="areaCol" />
            <van-time-picker v-model="coach" value-key="text" @change="changeCoach" :columns="coachCol" />
        </van-picker-group>
    </van-popup>


</template>

<script setup>
import { getSportsList as apiGetSports, getUsableArea as apiGetArea, getUsableCoach as apiGetCoach, submit as apiSubmit } from '@/api/indexApi';
import { ref, onMounted, watch } from 'vue';
import { showDialog, showToast } from 'vant'

onMounted(() => {
    initDate()
    getSports()

})

const orderInfo = ref({
    userId: '',
    coId: '',
    spId: '',
    spaId: '',
    subTime: '',
    status: '0',
    startTime: '',
    endTime: '',
    payment: '',
    description: ''
})


const submitOrder = async () => {
    console.log(orderInfo.value);

    let resp = await apiSubmit(orderInfo.value)
    if (resp.success) {
        let res = resp.res
        if (res.success) {

            console.log('提交成功');
        } else {
            showDialog({
                title: '提示',
                message: res.msg,
            }).then(() => {
                // on close
            })
        }

    }
    closeDialog()
    area.value = []
    coach.value = []

}


const rowSports = ref()

const sportsList = ref()

async function getSports() {
    let resp = await apiGetSports()

    if (resp.success) {
        sportsList.value = resp.data
    }

}

//预约弹窗
const dialog = ref(false)

const toLoignDia = ref(false)

const ifLogin = () => {
    let data = sessionStorage.getItem('userData');
    if (data === null) {
        toLoignDia.value = true
        showDialog({
            title: '提示',
            message: '请登录',
        }).then(() => {
            // on close
        });
        return false
    }
    return true
}
function book(sports) {
    if (ifLogin() === false) {
        return;
    }


    dialog.value = true
    orderInfo.value.userId = JSON.parse(sessionStorage.getItem('userData')).id
    orderInfo.value.spId = sports.id

    rowSports.value = sports.name

}

function formatter(type, value) {
    if (type === 'year') {
        return `${value}`;
    }
    if (type === 'month' || type === 'day' || type === 'hour' || type === 'minute') {
        return String(value).padStart(2, '0');
    }
    return value;
}


//选择日期
const date = ref('');

const minDate = ref()
//初始化日期
const initDate = () => {
    let now = new Date()
    let year = now.getFullYear()
    let month = now.getMonth()
    let day = now.getDate()
    minDate.value = new Date(year, month, day + 1)
    //格式化
    year = formatter('year', year)
    month = formatter('month', month + 1)
    day = formatter('day', day + 1)

    date.value = year + '-' + month + '-' + day

}

const showDatePicker = ref(false);
const dateConfirm = ({ selectedValues }) => {
    date.value = selectedValues.join('-');
    showDatePicker.value = false;
};

const closeDialog = () => {
    orderInfo.value = {}
    orderInfo.value.status = '0'
    initDate()
}

//选择时间
const timeRange = ref('')
const start = ref(['09', '00'])
const end = ref(['10', '00'])
const showTimePicker = ref(false)

const stHour = ref()
const enHour = ref()

watch(start, () => {
    let n = Number.parseInt(start.value[0])
    enHour.value = n + 1
})
watch(end, () => {
    let n = Number.parseInt(end.value)
    stHour.value = n - 1
})

//确认时间
const timeConfirm = async () => {
    showTimePicker.value = false


    if (start.value.length < 3) {
        start.value.push('00')
    }
    if (end.value.length < 3) {
        end.value.push('00')
    }

    showToast(`${start.value.join(':')} ${end.value.join(':')}`);

    timeRange.value = start.value.join(':') + ' - ' + end.value.join(':')

    orderInfo.value.startTime = date.value + ' ' + start.value.join(':')
    orderInfo.value.endTime = date.value + ' ' + end.value.join(':')


    await getAreas()

    await getCoaches()



};

const Cancel = () => {
    showToast('取消');
    showTimePicker.value = false
};

//获取可用场地列表
const areaCol = ref([])
async function getAreas() {
    let info = {}
    info.spId = orderInfo.value.spId
    info.timeForm = orderInfo.value.timeForm
    info.timeTo = orderInfo.value.timeTo
    let resp = await apiGetArea(info);
    if (resp.success) {
        areaCol.value = []
        let data = resp.data
        if (data === null || data.length === 0) {
            showDialog({
                title: '提示',
                message: '没有可选场地',
            }).then(() => {
                // on close
            });
        }
        data.map(e => {
            let a = { name: '', text: 0 }
            a.text = e.areaName
            a.value = e.areaId
            areaCol.value.push(a)
        })
        console.log(areaCol.value);


    }
}

const coachCol = ref([])
async function getCoaches() {
    let info = {}
    info.spId = orderInfo.value.spId
    info.timeForm = orderInfo.value.startTime
    info.timeTo = orderInfo.value.endTime
    let resp = await apiGetCoach(info);
    if (resp.success) {
        coachCol.value = []
        let data = resp.data
        coachCol.value.push({
            text: '无',
            value: ''
        })
        data.map(e => {
            let c = { name: '', text: 0 }
            c.text = e.coName
            c.value = e.coId
            coachCol.value.push(c)
        })

    }
}


const showPicker = ref(false)

const area = ref([])
const coach = ref([])

const areaInfo = ref('')

const changeArea = () => {
    orderInfo.value.spaId = Number(area.value)
}
const changeCoach = () => {
    if (Number(coach.value) == 0) {
        orderInfo.value.coId = ''
    }
    orderInfo.value.coId = Number(coach.value)
}

const onConfirm = () => {
    showPicker.value = false


    if (Number(coach.value) == 0) {
        orderInfo.value.coId = ''
    }
    orderInfo.value.spaId = Number(area.value)

    console.log(Number(area.value));

    areaInfo.value = '已选择'

    console.log(coach.value);
    area.value = []
    coach.value = []

}

const onCancel = () => {
    showPicker.value = false
    area.value = []
    coach.value = []
}

//加载列表
const list = ref([]);
const loading = ref(false);
const finished = ref(false);
const refreshing = ref(false);

const onLoad = () => {
    setTimeout(() => {
        if (refreshing.value) {
            list.value = [];
            refreshing.value = false;
        }
        for (let i = 0; i < 10; i++) {
            list.value.push(list.value.length + 1);
        }
        loading.value = false;

        if (list.value.length >= 40) {
            finished.value = true;
        }
    }, 1000);
};

const onRefresh = () => {
    // 清空列表数据s
    finished.value = false;
    // 重新加载数据
    // 将 loading 设置为 true，表示处于加载状态
    loading.value = true;
    onLoad();
};
</script>

<style scoped>
.list-model {
    width: 100%;
    height: 5rem;
    /* background-color: aqua; */
}

.van-cell {
    display: block;
}
</style>
<template>
    <div class="main">
        <div class="header">

        </div>
        <div class="list">
            <van-list v-model:loading="loading" :finished="finished" finished-text="没有更多了" @load="onLoad">
                <van-cell v-for="o in orderList" :key="o.id" :title="o.area.areaName">
                    <template #default>
                        <div class="item">
                            <div class="btn">
                                <div><van-button size="mini" type="warning">取消预约</van-button></div>
                                <div><van-button size="mini" type="primary">完成订单</van-button></div>
                            </div>

                            <div>
                                <div>预约时间：
                                    <span>{{ o.startTime }}</span>
                                    <br/>
                                    -
                                    <span>{{ o.endTime }}</span>
                                </div>
                                <div>教练：
                                    <span v-if="o.coach !== null">{{ o.coach.coName }}</span>
                                    <span v-else>无</span>
                                </div>
                                <div>运动：
                                    <span>{{ o.sports.spName }}</span>
                                </div>
                                <div>总花费：
                                    <span>{{ o.payment }} 元</span>
                                </div>
                                <div>提交时间：
                                    <span>{{ o.subTime }}</span>
                                </div>
                                <div style="color: aqua;" v-if="o.status === '0'">预约中</div>
                                <div style="color: greenyellow;" v-else-if="o.status === '1'">已完成</div>
                                <div style="color: red;" v-else-if="o.status === '2'">已取消</div>
                            </div>
                        </div>

                    </template>
                </van-cell>
            </van-list>
        </div>
    </div>

</template>

<script setup>
import { getOrders as apiGetOrders } from '@/api/orderApi'
import { onMounted, ref } from 'vue'

const orderList = ref([])

onMounted(() => {
    getOrderList()
})

const getOrderList = async () => {
    let data = JSON.parse(sessionStorage.getItem('userData'))
    let id = data.id

    let resp = await apiGetOrders(id)
    if (resp.success) {
        orderList.value = resp.data
        console.log(resp.data);
    }
}


const list = ref([]);
const loading = ref(false);
const finished = ref(false);



const onLoad = () => {
    // 异步更新数据
    // setTimeout 仅做示例，真实场景中一般为 ajax 请求
    setTimeout(() => {
        for (let i = 0; i < 10; i++) {
            list.value.push(list.value.length + 1);
        }

        // 加载状态结束
        loading.value = false;

        // 数据全部加载完成
        if (list.value.length >= 40) {
            finished.value = true;
        }
    }, 500);
};
</script>

<style scoped>
.van-cell {
    display: block;
}

.item {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.btn {
    padding: 25px 10px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}
</style>
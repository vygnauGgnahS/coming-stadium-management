<template>
    <div class="outer">
        <el-row class="header">
            <el-col :span="12" class="left">
                <div class="c1" id="counts">
                    <div class="c1-tit">体育馆数据</div>
                    <div class="items">
                        <div class="item">
                            <h2>会员数</h2>
                            <div>
                                {{ member_count }}
                            </div>
                        </div>
                        <div class="item">
                            <h2>教练数</h2>
                            <div>
                                {{ coach_count }}
                            </div>
                        </div>
                        <div class="item">
                            <h2>预约数</h2>
                            <div>
                                {{ order_count }}
                            </div>
                        </div>
                    </div>
                </div>
            </el-col>
            <el-col :span="12" class="right">
                <div class="c2">
                    <div class="chart1" ref="c1Ref"></div>
                </div>
            </el-col>
        </el-row>
        <el-row class="footer">
            <el-col :span="24">
                <div class="c3">
                    <div class="chart2" ref="c2Ref"></div>
                </div>
            </el-col>
        </el-row>
    </div>
</template>



<script setup>
import { sportsTypeOfOrders as apiSportsType, coachOfOrders as apiCoach } from '@/api/statApi'
import { getList as apiGetUserNum } from '@/api/userApi'
import { getList as apiGetCoachNum } from '@/api/coachApi'
import { getList as apiGetOrderNum } from '@/api/orderApi'
import { ref, onMounted } from 'vue'
import * as echarts from "echarts"

const member_count = ref(0)
const coach_count = ref(0)
const order_count = ref(0)


//柱状图引用
const c1Ref = ref()
const c2Ref = ref()

onMounted(async () => {
    getUserNum()
    getCoachNum()
    getOrderNum()


    //创建echarts实例
    // let chart1 = echarts.init(c1Ref.value)
    let chart1 = echarts.init(c1Ref.value)
    await sportsStats()
    let chart2 = echarts.init(c2Ref.value)
    await coachStats()

    //设置配置项
    chart1.setOption(c1Opt.value)
    chart2.setOption(c2Opt.value)
})

const c1Opt = ref({
    tooltip: {
        trigger: 'item'
    },
    series: [
        {
            name: '不同运动项目预约数占比',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            padAngle: 5,
            itemStyle: {
                borderRadius: 10
            },
            emphasis: {
                label: {
                    show: true,
                    fontSize: 40,
                    fontWeight: 'bold'
                }
            },
            data: [
                { value: 1048, name: 'Search Engine' },
                { value: 735, name: 'Direct' },
                { value: 580, name: 'Email' },
                { value: 484, name: 'Union Ads' },
                { value: 300, name: 'Video Ads' }
            ]
        }
    ]
})

async function sportsStats() {
    let resp = await apiSportsType()
    if (resp.success) {
        let data = resp.data
        for (let t of data) {
            t.name = t.key
        }
        c1Opt.value.series[0].data = data
    }
}


const c2Opt = ref({
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: [
        {
            type: 'category',
            data: [],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
    yAxis: [
        {
            type: 'value'
        }
    ],
    series: [
        {
            name: '不同教练的预约订单',
            type: 'bar',
            barWidth: '60%',
            data: []
        }
    ]
})

async function coachStats() {
    let resp = await apiCoach()
    if (resp.success) {
        let data = resp.data
        let nameArr = []
        let valueArr = []
        for (let item of data) {
            nameArr.push(item.key)
            valueArr.push(item.value)
        }
        
        c2Opt.value.xAxis[0].data = nameArr
        c2Opt.value.series[0].data = valueArr

    }
}

//获取用户总数
async function getUserNum() {
    let resp = await apiGetUserNum()
    if (resp.success) {
        let pi = resp.pi
        member_count.value = pi.total

    } else {
        console.log('出错');

    }
}
//获取用户总数
async function getCoachNum() {
    let resp = await apiGetCoachNum()
    if (resp.success) {
        let pi = resp.pi
        coach_count.value = pi.total

    } else {
        console.log('出错');

    }
}
//获取预约订单总数
async function getOrderNum() {
    let resp = await apiGetOrderNum()
    if (resp.success) {
        let pi = resp.pi
        order_count.value = pi.total

    } else {
        console.log('出错');

    }
}

</script>

<style scoped>
.el-main {
    padding: 5px 10px
}

.el-main,
.main {
    padding: 5px 10px;
}

.outer {
    height: 100%;
    /* background-color: #eee; */
}

.header {
    margin: 0;
    display: flex;
}

.left,
.right {
    padding: 2px 5px;
}


.c1 {
    background-color: #fff;
    width: 100%;
    height: 400px;
    border: 1px solid #eee;
    border-radius: 15px;
    box-shadow: 0 0 10px #e3e3e3;
}

.c1-tit {
    font-size: 30px;
    line-height: 60px;
    font-weight: bolder;
    height: 50px;
    text-align: center;
}

#counts {
    padding-bottom: 50px;
}

#counts>.items {
    display: flex;
    justify-content: space-around;
    margin-top: 30px;
}

#counts>.items>.item {
    width: 180px;
}

#counts>.items>.item>h2 {
    font-size: 30px;
    text-align: center;
    font-weight: normal;
    margin: 0;
}

#counts>.items>.item>div {
    width: 120px;
    height: 120px;
    border: 30px solid #49bcf7;
    border-radius: 120px;
    text-align: center;
    line-height: 120px;
    font-size: 30px;
    font-weight: bold;
    margin-top: 20px;
}

#counts>.items>.item:nth-child(2)>div {
    border-color: #91cc75;
}

#counts>.items>.item:nth-child(3)>div {
    border-color: #fac858;
}

#counts>.items>.item:nth-child(4)>div {
    border-color: #5470c6;
}



.c2 {
    background-color: #fff;
    width: 100%;
    height: 450px;
    border: 1px solid #e3e3e3;
    border-radius: 15px;
    box-shadow: 0 0 10px #e3e3e3;
}

.footer {
    height: 360px;
    margin: 0;
    padding: 5px;
}

.c3 {
    background-color: #fff;
    width: 100%;
    height: 100%;
    border: 1px solid #e3e3e3;
    border-radius: 15px;
    box-shadow: 0 0 10px #e3e3e3;
}

.chart1 {
    width: 100%;
    height: 100%;
}

.chart2 {
    width: 100%;
    height: 100%;
}

.chart3 {
    width: 100%;
    height: 100%;
}
</style>
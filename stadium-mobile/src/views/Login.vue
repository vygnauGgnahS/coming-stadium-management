<template>
    <div class="header">
        <div class="header-text">欢迎使用快来体育馆预约系统</div>
        <div class="header-title">
            请登录
        </div>
    </div>
    <div class="main">
        <div class="form">
            <van-form @submit="onSubmit">
                <van-cell-group inset>
                    <van-field v-model="account.username" name="username" label="用户名" placeholder="用户名"
                        :rules="[{ required: true, message: '请填写用户名' }]" />
                    <van-field v-model="account.password" type="password" name="password" label="密码" placeholder="密码"
                        :rules="[{ required: true, message: '请填写密码' }]" />
                </van-cell-group>
                <div style="margin: 16px;">
                    <van-button round block type="primary" native-type="submit">
                        登录
                    </van-button>
                </div>
            </van-form>
        </div>
    </div>
    <van-dialog v-model:show="show" title="出错了" show-cancel-button>
        <div class="msg">{{ msg }}</div>
    </van-dialog>

</template>

<script setup>
import { login as apiLogin } from '@/api/loginApi'
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

onMounted(() => {
    
})

const router = useRouter()

const show = ref(false)
const msg = ref('')

const account = ref({
    username: '',
    password: ''
})

const onSubmit = async (values) => {
    console.log('submit', values);
    let resp = await apiLogin(values)
    if (resp.success) {
        let res = resp.res
        
        if (res.success) {
            let data = res.data
            sessionStorage.setItem('userData',JSON.stringify(data))
            router.push('/main/index')
        } else {
            console.log(res.msg);
            msg.value = res.msg
            show.value = true
        }

    }

};


</script>

<style scoped>
.header {
    height: 150px;
    padding: 30px;
    padding-top: 50px;
}

.header-text {
    text-align: center;
    line-height: 30px;
    font-size: 15px;
    color: #40a0ffb1;
}

.header-title {
    margin: 0 auto;
    text-align: center;
    line-height: 80px;
    font-size: 40px;
    font-weight: 600;
    color: #409EFF;
}

.main {
    padding: 10px 20px;
}

.msg {
    text-align: center;
}
</style>
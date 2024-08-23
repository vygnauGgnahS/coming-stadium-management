<template>
    <div class="outer">
        <div class="header">
            <div class="header-title">
                欢迎来到，快来体育馆预约管理系统
            </div>
        </div>
        <div class="formMain">
            <div class="on-title"></div>
            <div class="title">
                <div>请&nbsp;登&nbsp;录</div>
            </div>
            <div class="form">
                <el-form :model="lfm" :rules="rules" ref="lfRef">
                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="用户名：" prop="username" :label-width="80">
                                <el-input v-model="lfm.username" id="username" autocomplete="off" style="height: 35px;"
                                    placeholder="请输入用户名"></el-input>
                            </el-form-item>
                        </el-col>

                    </el-row>
                    <el-row>
                        <el-col :span="24">
                            <el-form-item label="密码：" prop="password" :label-width="80">
                                <el-input v-model="lfm.password" id="password" show-password autocomplete="off"
                                    style="height: 35px;" placeholder="请输入密码"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="15">
                            <el-form-item label="验证码：" prop=captcha :lable-width="80">
                                <el-input v-model="lfm.captcha" maxlength="4" minLength="4" autocomplete="off"
                                    style="height: 35px;" placeholder="请输入验证码" />
                            </el-form-item>
                        </el-col>
                        <el-col :span="1">
                        </el-col>
                        <el-col :span="8">
                            <div class="catchaImg">
                                <img :src="captchaUrl" @click="refresh">
                            </div>
                        </el-col>
                    </el-row>
                    <el-row>
                        <el-col :span="24">
                            <el-button type="primary" class="login-btn" @click="submitForm">登&nbsp;&nbsp;录</el-button>
                        </el-col>
                    </el-row>

                </el-form>
            </div>
        </div>
        <div class="footer"></div>
    </div>
</template>

<script setup>
import { ref } from 'vue'
import { login } from '@/api/loginApi'
import { save as saveToken } from '@/util/JwtUtils'
import { ElMessage } from 'element-plus';
import { useRouter } from 'vue-router'

const router = useRouter()

const loginFormModel = ref({
    username: '',
    password: '',
    captcha: ''
})
const lfm = loginFormModel

const lfRef = ref()

async function submitForm() {
    lfRef.value.validate(async success => {
        if (success) {
            let resp = await login(lfm.value)
            if (resp.success) {
                saveToken(resp.jwt)
                let admin = resp.admin
                console.log(admin.name);
                
                sessionStorage.setItem('name', admin.name)

                
                router.push('/')
                console.log(router);
            }
        } else {
            ElMessage({
                message: resp.msg || '登录失败',
                type: 'error'
            })
        }
    })
}


const captchaUrl = ref('/api/login/captcha')

function refresh() {
    captchaUrl.value = '/api/login/captcha?id=' + Math.random()
}


const rules = ref({
    username: [
        { required: true, message: '用户名不可为空' }
    ],
    password: [
        { required: true, message: "密码不可为空" }
    ],
    captcha: [
        { required: true, message: "验证码不可为空" },
        { min: 4, max: 4, message: "验证码只能是4位" }
    ]
})


</script>


<style scoped>
.outer {
    height: 100%;
    min-height: 800px;
    background-image: url('@/assets/pic/basketball.png');
    background-repeat: no-repeat;
    background-position: center;
    background-size: center/cover;
}

.header {
    width: 100%;
    height: 120px;
    background-color: #ffffff52;
}

.header-title {
    padding-top: 10px;
    width: 100%;
    text-align: center;
    line-height: 100px;
    font-size: 55px;
    color: #fff;
    text-shadow: 0 1px 3px #333;
    
}

.formMain {
    background-color: #51a8ff89;
    /* background-color: transparent; */
    width: 400px;
    height: 600px;
    margin: 0 auto;
    border: 5px solid #fff;
    border-radius: 50px;
    padding: 20px;
}

/* .on-title {
    height: 65px;
    background-color: #fff;
} */

.title {
    padding: 60px 10px 0;
}

.title>div {
    height: 150px;
    margin-top: 45px;
    color: rgb(255, 255, 255);
    font-size: 50px;
    font-weight: bolder;
    line-height: 80px;
    text-align: center;
    text-shadow: 0 1px 3px #333;
}


.form {
    width: 350px;
    margin: 0 auto;
    padding: 40px 20px;
    border-radius: 30px;
    border: 3px solid #42aaff;
    background-color: #ffffff75;
}

.captchaImg {
    width: 120px;
    height: 30px;
    margin: 0 5px;
    border: 2px solid black;
}

.login-btn {
    width: 100%;
    height: 50px;
    background-color: #42aaff;
    color: #fff;
    font-size: 18px;
}


.footer {
    width: 100%;
    height: 35px;
    position: fixed;
    bottom: 0;
    background-color: #ffffff7c;
}
</style>
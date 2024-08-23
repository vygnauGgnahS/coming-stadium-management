<template>
    <div class="outer">
        <div class="header">
            你好，{{ user.name }}
        </div>
        <div class="main">
            <van-button disabled @click="edit" round size="small" type="primary">修改信息</van-button>
            <van-button disabled @click="change" round size="small" type="success">更改密码</van-button>
            <van-button @click="logout" size="small" round type="danger">退出登录</van-button>
        </div>
        <div class="userInfo">

        </div>
    </div>

</template>

<script setup>
import { onMounted, ref } from 'vue';

const user = ref({
    name: ''
})

onMounted(() => {
    
    let u = sessionStorage.getItem('userData')
    u = JSON.parse(u)
    if (u !== null) {
        user.value = u
        
    } else {
        user.value.name = '请登录'
    }
})

const edit = () => {
    let user = sessionStorage.getItem('userData')
    user = JSON.parse(user)
    console.log(user);
    

}

const change = () => {

}


const logout = () => {
    sessionStorage.removeItem('userData')
    location.reload()
}



</script>

<style scoped>
.outer {
    height: 100%;
}
.header {
    padding-top: 30px;
    height: 100px;
    font-size: 20px;
    font-weight: 600;
    text-align: center;
}

.main {
    padding: 20px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.edit {
    margin: 0 auto;
}

.change {
    margin: 0 auto;
}

.logout {
    margin: 0 auto;
}
</style>
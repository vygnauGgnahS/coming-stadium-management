<template>
    <van-nav-bar fixed placeholder title="快来体育馆" left-arrow @click-left="onClickLeft" />
    <div class="list">
        <router-view></router-view>
    </div>
    
    <van-tabbar fixed placeholder v-model="active">
            <van-tabbar-item name="/main/index" to="/main/index" icon="home-o">首页</van-tabbar-item>
            <!-- <van-tabbar-item name="/main/info" to="/main/info" icon="search">信息</van-tabbar-item> -->
            <van-tabbar-item name="/main/orders" to="/main/orders" icon="todo-list-o">订单</van-tabbar-item>
            <van-tabbar-item name="/main/home" to="/main/home" icon="manager-o">我的</van-tabbar-item>
        </van-tabbar>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const route = useRoute()
const router = useRouter();

onMounted(() => {
    active.value = route.path
    
})


function onClickLeft() {
  router.back(); // 返回到上一页
}

const active = ref('/main/index');

</script>

<style scoped>
/* .list {
    
} */
</style>
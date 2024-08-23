<template>
    <div class="outer">
        <el-container class="outer-header">
            <div class="header-title">
                快来体育馆管理系统
            </div>
        </el-container>
        <el-container class="outer-main">
            <el-aside class="aside" width="collapse">
                <div class="aside-menu">
                    <el-menu class="menu" :default-active="curRoute" :collapse="isCollapse" router>
                        <div class="aside-header">
                            <div class="pic" @click="showMenu"></div>
                        </div>
                        <template v-for="menu in menus">
                            <el-sub-menu v-if="Array.isArray(menu.children)" :index="menu.url">
                                <template #title>
                                    <el-icon>
                                        <component :is="menu.icon"></component>
                                    </el-icon>
                                    <span>{{ menu.title }}</span>
                                </template>
                                <el-menu-item v-for="mi in menu.children" :index="mi.url">
                                    <el-icon>
                                        <component :is="mi.icon"></component>
                                    </el-icon>
                                    <span>{{ mi.title }}</span>
                                </el-menu-item>
                            </el-sub-menu>
                            <el-menu-item v-else :index="menu.url">
                                <el-icon>
                                    <component :is="menu.icon"></component>
                                </el-icon>
                                <span>{{ menu.title }}</span>
                            </el-menu-item>
                        </template>
                    </el-menu>
                </div>
            </el-aside>
            <el-container class="right">
                <el-header class="header">
                    <el-page-header>
                        <template #breadcrumb>
                            <BreadCrumb @click="goBack" @bread="getBread" :newBread="newBread" />
                        </template>
                        <template #content>
                            <div class="flex items-center">
                                <el-avatar class="mr-3" :size="32"
                                    src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png" />
                                <span class="adminName text-large font-600 mr-3"> {{ name }} </span>
                            </div>
                        </template>
                        <template #extra>
                            <div class="flex items-center">
                                <el-button type="primary" round plain>Print</el-button>
                                <el-button @click="logout" type="danger" round plain>退出</el-button>
                            </div>
                        </template>
                    </el-page-header>
                </el-header>
                <el-main class="main">
                    <router-view></router-view>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script setup>
import { HomeFilled, UserFilled, User, Monitor, Pointer, Flag, Basketball, LocationInformation, List, Tools } from '@element-plus/icons-vue'
import { clear as removeToken } from '@/util/JwtUtils'
import { ref, onMounted } from 'vue'
import BreadCrumb from '@/components/BreadCrumb.vue';
import { useRouter } from 'vue-router';

const router = useRouter()

const curRoute = ref()

const name = ref('')

onMounted(() => {
    curRoute.value = router.currentRoute.value.name
    if (curRoute.value === 'manager') {
        router.currentRoute.value.name = 'home'
    }

    name.value = sessionStorage.getItem('name')
})

const isCollapse = ref(false)
const showMenu = () => {
    isCollapse.value = !isCollapse.value
}

//菜单列表
const menus = ref([
    {
        title: '首页',
        url: 'home',
        icon: HomeFilled
    }, {
        title: '人员管理',
        url: 'user',
        icon: UserFilled,
        children: [
            {
                title: '会员信息',
                url: 'user',
                icon: User
            }, {
                title: '管理员信息',
                url: 'admin',
                icon: Monitor
            }, {
                title: '教练信息',
                url: 'coach',
                icon: Pointer
            }
        ]
    }, {
        title: '体育项目管理',
        url: 'sports',
        icon: Flag,
        children: [
            {
                title: '运动项目',
                url: 'sports',
                icon: Basketball
            }, {
                title: '场地信息',
                url: 'area',
                icon: LocationInformation
            }
        ]
    }, {
        title: '预约订单信息',
        url: 'order',
        icon: List
    }, {
        title: '设置',
        url: 'set',
        icon: Tools
    }
])

//退出登录
function logout() {
    removeToken()
    location.reload()
}
</script>


<style>
.outer {
    height: 100%;
}

.outer-header {
    height: 36px;
    background-color: hsla(210, 100%, 50%, 0.591);

}

.outer-main {
    height: calc(100% - 40px);

}

.header-title {
    margin: 0 auto;
    font-size: 18px;
    line-height: 36px;
    font-weight: 600;
    color: white;
}

.aside {
    height: 100%;
}


.aside-header {
    height: 60px;

}

.aside-header .pic {
    height: 100%;
    background-image: url('../assets/pic/1.jpg');
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
}

.aside-menu {
    height: 100%;
}

.menu {
    height: 100%;
    transition-duration: 0.5s;

}

.adminName {
    margin: 10px;
}

.header {
    margin-top: 8px;
}

.header .el-page-header__breadcrumb {

    margin-bottom: 8px;
}

.el-page-header {
    /* height: 30px; */
    border-bottom: 1px solid #e3e3e3;
}

.el-page-header__back {
    display: none;
}

.el-main,
.main {
    margin: 0;
    padding: 5px;
}
</style>
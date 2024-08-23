const mainView = () => import('@/views/Main.vue')
const indexView = () => import('@/views/pages/Index.vue')
const infoView = () => import('@/views/pages/Info.vue')
const orderView = () => import('@/views/pages/Order.vue')
const homeView = () => import('@/views/pages/Home.vue')

const loginView = () => import('@/views/Login.vue')
const areaView = () => import('@/views/pages/others/Area.vue')


const routes = [
    {
        name: 'login',
        path: '/login',
        component: loginView,
        meta: {
            title: '登录'
        }
    },
    {
        name: 'main',
        path: '/main',
        component: mainView,
        children: [
            {
                name: 'index',
                path: '/main/index',
                component: indexView,
                meta: {
                    title: '首页'
                }
            }, {
                name: 'info',
                path: '/main/info',
                component: infoView,
                meta: {
                    title: '查看信息'
                }
            }, {
                name: 'orders',
                path: '/main/orders',
                component: orderView,
                meta: {
                    title: '订单信息'
                }
            }, {
                name: 'home',
                path: '/main/home',
                component: homeView,
                meta: {
                    title: '我的'
                }
            }
        ]
    }, {
        name: 'area',
        path: '/area',
        component: areaView,
        meta: {
            title: '场地查看'
        }
    }
]

export default routes
const mainView = () => import('@/views/Main.vue')
const indexView = () => import('@/views/pages/Index.vue')
const orderView = () => import('@/views/pages/Order.vue')
const homeView = () => import('@/views/pages/Home.vue')

const loginView = () => import('@/views/Login.vue')


const routes = [
    {
        path: '/',
        redirect: '/main/index'
    },
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
    }
]

export default routes
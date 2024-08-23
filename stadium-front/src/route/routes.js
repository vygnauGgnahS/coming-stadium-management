const loginView = () => import('@/views/Login.vue')
const managerView = () => import('@/views/Manager.vue')
const homeView = () => import('@/views/menus/Home.vue')
const userView = () => import('@/views/menus/User.vue')
const adminView = () => import('@/views/menus/Admin.vue')
const sportsView = () => import('@/views/menus/Sports.vue')
const coachView = () => import('@/views/menus/Coach.vue')
const areaView = () => import('@/views/menus/Area.vue')
const orderView = () => import('@/views/menus/Order.vue')
const setView = () => import('@/views/menus/Set.vue')


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
        name: 'manager',
        path: '/',
        redirect: 'home',
        component: managerView,
        children: [
            {
                name: 'home',
                path: 'home',
                component: homeView,
                meta: {
                    title: '首页'
                }
            }, {
                name: 'user',
                path: 'user',
                component: userView,
                meta: {
                    title: '会员信息'
                }
            }, {
                name: 'admin',
                path: 'admin',
                component: adminView,
                meta: {
                    title: '管理员信息'
                }
            }, {
                name: 'sports',
                path: 'sports',
                component: sportsView,
                meta: {
                    title: '运动项目'
                }
            }, {
                name: 'coach',
                path: 'coach',
                component: coachView,
                meta: {
                    title: '教练信息'
                }
            }, {
                name: 'area',
                path: 'area',
                component: areaView,
                meta: {
                    title: '场地信息'
                }
             }, {
                 name: 'order',
                 path: 'order',
                 component: orderView,
                 meta: {
                     title: '订单信息'
                 }
             }, {
                name: 'set',
                path: 'set',
                component: setView,
                meta: {
                    title: '设置'
                }
            }
        ]
    }
]

export default routes
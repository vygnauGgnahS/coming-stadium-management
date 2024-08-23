import { createRouter, createWebHashHistory } from "vue-router";
import { get as getToken } from '@/util/JwtUtils'
import routes from './routes'

const router = createRouter({
    routes,
    history: createWebHashHistory()
})

router.beforeEach((to, from, next) => {
    let jwt = getToken();
    if (jwt) {
        if (to.name === 'login') {
            next({ name: '/' })
        } else {
            next()
        }
    } else {
        if (to.name !== 'login') {
            next({ name: 'login' })
        } else {
            next()
        }
    }
    next()
})

export default router

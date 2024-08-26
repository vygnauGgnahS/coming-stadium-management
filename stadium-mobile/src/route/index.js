import { createRouter, createWebHashHistory } from 'vue-router'
import routes from './routes'

const router = createRouter({
    routes,
    history: createWebHashHistory()
})


router.beforeEach((to, from, next) => {
    let data = sessionStorage.getItem('userData');
    if (data) {
        if (to.name === 'login') {
            next({ name: 'main/index' })
        } else {
            next()
        }
    } else {
        if (to.name === 'orders') {
            console.log(to.name);
            
            next({name: 'login'})
        } else if (to.name === 'home') {
            next({name: 'login'})
        } else {
            next()
        }
    }
    next()
})



// router.beforeEach((to, from, next) => {
//     let data = sessionStorage.getItem('userData');
//     if (data) {
//         if (to.name === 'login') {
//             next({ name: 'main/index' })
//         } else {
//             next()
//         }
//     } else {
//         if (to.name !== 'login') {
//             next({ name: 'login' })
//         } else {
//             next()
//         }
//     }
//     next()
// })

export default router

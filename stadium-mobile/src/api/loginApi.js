import api from '@/util/axios'

async function login(user) {
    let resp = api({
        url: '/login',
        method: 'post',
        data: user
    })
    return resp
}


export { login }
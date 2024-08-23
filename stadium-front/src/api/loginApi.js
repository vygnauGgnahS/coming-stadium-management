import api from '@/util/axios'

const url = '/login'

async function login(account) {
    let resp = await api({
        url,
        method: 'post',
        data: account
    })
    return resp
}

export { login }
import api from '@/util/axios'

async function getOrders(userId) {
    let resp = api({
        url: '/orders',
        method: 'get',
        params: {
            userId
        }
    })
    return resp
}

export { getOrders }
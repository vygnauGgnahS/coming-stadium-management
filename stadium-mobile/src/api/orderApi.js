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

async function edit(order) {
    let resp = api({
        url: '/orders',
        method: 'put',
        data: order
    })
    return resp
}

export { getOrders, edit }
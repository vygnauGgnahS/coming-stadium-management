import api from '@/util/axios'

async function sportsTypeOfOrders() {
    let resp = await api({
        url: '/stats/sportsTypeOfOrders',
        method: 'get'
    })
    return resp
}

async function coachOfOrders() {
    let resp = await api({
        url: '/stats/coachOfOrders',
        method: 'get'
    })
    return resp
}

export { sportsTypeOfOrders, coachOfOrders }
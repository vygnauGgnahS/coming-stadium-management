import api from '@/util/axios'

async function getSportsList() {
    let resp = await api({
        url: '/sports',
        method: 'get',

    });
    return resp
}

async function getUsableArea(info) {
    let resp = await api({
        url: '/areas',
        method: 'get',
        params: {
            ...info
        }
    })
    return resp
}

async function getUsableCoach(info) {
    let resp = await api({
        url: '/coaches',
        method: 'get',
        params: {
            ...info
        }
    })
    return resp
}

async function submit(order) {
    let resp = await api({
        url: '/orders',
        method: 'post',
        data: order
    })
    return resp
}


export { getSportsList, getUsableArea, getUsableCoach, submit }
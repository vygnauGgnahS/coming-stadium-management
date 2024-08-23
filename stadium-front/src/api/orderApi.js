import api from '@/util/axios'

const url = '/orders'

async function getList(pageNo = 1, pageSize = 10, params = {}) {
    let p = Object.assign({}, params)

    let timeFrom, timeTo
    if (Array.isArray(p.timeRange)) {
        if (p.timeRange.length > 0) {
            timeFrom = p.timeRange[0]
        } 
        if (p.timeRange.length > 1) {
            timeTo = p.timeRange[1]
        }
        delete p.timeRange
    }

    let resp = await api({
        url,
        method: 'get',
        params: {
            pageNo,
            pageSize,
            ...p,
            timeFrom,
            timeTo
        }
    })
    return resp
}

//批量删除
async function deleteByIds(ids) {
    let resp = await api({
        url,
        method: 'delete',
        data: ids//默认使用请求体。后端使用@RequestBody接收
    })
    
    return resp
}

//新增学生
async function add(order) {
    let resp = await api({
        url,
        method: 'post',
        data: order
    })
    return resp
}

//修改信息
async function edit(order) {
    let resp = await api({
        url,
        method: 'put',
        data: order
    })
    return resp
}

export { getList, deleteByIds, add, edit }
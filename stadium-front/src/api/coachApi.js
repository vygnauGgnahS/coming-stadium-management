import api from '@/util/axios'

const url = '/coaches'

async function getList(pageNo = 1, pageSize = 10, params = {}) {
    let resp = await api({
        url,
        method: 'get',
        params: {
            pageNo,
            pageSize,
            ...params
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
async function add(coach) {
    let resp = await api({
        url,
        method: 'post',
        data: coach
    })
    return resp
}

//修改信息
async function edit(coach) {
    let resp = await api({
        url,
        method: 'put',
        data: coach
    })
    return resp
}

export { getList, deleteByIds, add, edit }
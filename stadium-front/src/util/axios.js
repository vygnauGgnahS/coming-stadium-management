import axios from 'axios'
import { get as getToken } from '@/util/JwtUtils'

const api = axios.create({
    baseURL: '/api',
    timeout: 3000
})

api.interceptors.request.use(config => {
    config.headers["jwt"] = getToken()
    return config
}, error => {
    return Promise.reject('token失效')
})


api.interceptors.response.use(resp => {
    let data = resp.data
    if (data.success) {
        return data
    } else {
        Promise.reject('获取数据错误')
    }
}, error => {
    Promise.reject('请求失败')
})

export default api
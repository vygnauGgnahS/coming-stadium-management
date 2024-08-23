import axios from 'axios'

const api = axios.create({
    baseURL: '/api',
    timeout: 3000
})

// api.interceptors.request.use(config => {

// })


api.interceptors.response.use(resp => {
    let data = resp.data
    if (data.success) {
        return data
    } else {
        console.log(data.msg);
        
        Promise.reject('获取数据错误')
    }
}, error => {
    console.log(error);
    
    Promise.reject('请求失败')
})

export default api
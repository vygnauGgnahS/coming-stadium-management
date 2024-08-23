import api from '@/util/axios'

const url = '/files/upload/avatar/users'

function handleChange(rawFile) {
    if (rawFile.type !== 'image/jpeg' && rawFile !== 'image/png') {
        ElMessage.error('只能上传jpg/jpeg/png图片')
        return false
    } else if (rawFile.size / 1024 / 1024 > 1) {
        ElMessage.error('上传图片最大不超过1MB')
        return false
    }
    return true
}

// async function upload(file) {
//     let fd = new FormData()
//     fd.append('file', file.file)
//     console.log(file, fd);

//     let resp = await api({
//         url,
//         method: 'post',
//         data: fd
//     })
//     if (resp.success) {
//         return resp.url
//     } else {
//         ElMessage.error(resp.msg)
//     }
// }

export { handleChange }
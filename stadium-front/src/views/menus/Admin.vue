<template>
    <div class="main">
        <div class="search">
            <el-form :model="searchRef" ref="searchFormRef" :inline="true">

                <el-form-item label="编号：" prop="id">
                    <el-input v-model="searchRef.id" placeholder="请输入编号" clearable style="width: 100px" />
                </el-form-item>
                <el-form-item label="姓名：" prop="name">
                    <el-input v-model="searchRef.name" placeholder="请输入姓名" clearable style="width: 100px" />
                </el-form-item>
                <el-form-item label="用户名：" prop="username">
                    <el-input v-model="searchRef.username" placeholder="请输入用户名" clearable style="width: 100px" />
                </el-form-item>
                <el-form-item label="手机号：" prop="phone">
                    <el-input v-model="searchRef.phone" placeholder="请输入手机号" clearable style="width: 140px" />
                </el-form-item>
                <el-form-item>
                    <el-button @click="search" type="primary" :icon="Search" circle plain />
                </el-form-item>
                <br />
                <el-form-item>
                    <el-button @click="add" type="success" :icon="Plus" plain>新增</el-button>
                    <el-button @click="reset" type="info" :icon=Refresh plain>重置</el-button>
                    <el-button @click="del" type="danger" :icon="Delete" plain>批量删除</el-button>
                    <div class="pagination">
                        <el-pagination v-model:current-page="pi.pageNo" v-model:page-size="pi.pageSize"
                            :page-sizes="[5, 10, 15, 30, 50, 100]" :size="size" :disabled="disabled" background
                            layout="total, sizes, prev, pager, next, jumper" :total="pi.total" @change="paginate" />
                    </div>
                </el-form-item>
            </el-form>
        </div>
        <div class="data-grid">
            <el-table :data="tableData" ref="tableRef" v-loading="loading" element-loading-text="Loading..."
                style="width: 100%">
                <el-table-column fixed type="selection" width="60" />
                <el-table-column prop="id" label="编号" width="100" />
                <!-- <el-table-column prop="avatar" label="头像" width="180"> -->
                <!-- <template #default="scope"> -->
                <!-- <el-image class="row-avatar" :src="scope.row.avatar" @click="showPic(scope.row.avatar)" /> -->
                <!-- </template> -->
                <!-- </el-table-column> -->
                <el-table-column prop="username" label="用户名" width="150" />
                <el-table-column prop="name" label="姓名" width="150" />
                <el-table-column prop="phone" label="手机号" width="200" />
                <el-table-column prop="description" label="备注" width="600" show-overflow-tooltip />
                <el-table-column fixed="right" label="操作" min-width="200">
                    <template #default="scope">
                        <el-button link type="primary" @click="infoData(scope.row)">
                            详情
                        </el-button>
                        <el-button link type="success" @click="edit(scope.row)">
                            编辑
                        </el-button>
                        <el-button link type="danger" @click="delInLine(scope.row)">
                            删除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>
        <!-- 图片查看器 -->
        <!-- <el-image-viewer @close="() => { showViewer = false }" v-if="showViewer" :url-list="picList" :z-index="1000" /> -->

        <!-- 数据展示抽屉 -->
        <el-drawer v-model="showDrawer" show-close title="详情" direction="rtl" size="30%">
            <!-- <div class="drawer-pic">
                <el-image class="drawer-avatar" :src="rowData.avatar" />
            </div> -->
            <el-descriptions :title="rowData.nickname" direction="vertical" border>
                <el-descriptions-item label="姓名">
                    <span>{{ rowData.name }}</span>
                </el-descriptions-item>
                <el-descriptions-item label="用户名">
                    <span>{{ rowData.username }}</span>
                </el-descriptions-item>
                <el-descriptions-item label="手机号">
                    <span>{{ rowData.phone }}</span>
                </el-descriptions-item>
                <el-descriptions-item label="备注">
                    <el-text>
                        {{ rowData.description }}
                    </el-text>
                </el-descriptions-item>
            </el-descriptions>
        </el-drawer>

        <!-- 对话框 -->
        <el-dialog v-model="showDialog" :title="dialogTit" width="800" draggable :close-on-click-modal="false"
            @close="closeDia">
            <el-from :model="formMod" :rule="rules" ref="formRef">
                <el-row>
                    <el-col :span=12>
                        <el-form-item label="用户名：" label-width="100" prop="username">
                            <el-input v-model="formMod.username" placeholder="请输入用户名" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="姓名：" label-width="100" prop="name">
                            <el-input v-model="formMod.name" placeholder="请选输入姓名" />
                        </el-form-item>
                    </el-col>
                    <!-- <el-col :span=12>
                        <el-form-item label="头像:" label-width="100">
                            <el-upload class="avatar" action="/api/files/upload/avatar/users" :show-file-list="false"
                                :on-success="avatarSuccess" :before-upload="handleChange"
                                accept="image/jpeg,image/jpg,image/png">
                                <div class="preview" v-if="formMod.avatar"
                                    :style="'background-image: url(' + formMod.avatar + ')'">
                                    <img />
                                </div>
                                <el-icon class="icon" v-else>
                                    <Plus />
                                </el-icon>
                            </el-upload>
                        </el-form-item>
                    </el-col> -->
                </el-row>
                <el-row>
                    <el-col :span="12" v-show="actionRef">
                        <el-form-item label="密码：" label-width="100" prop="password">
                            <el-input v-model="formMod.password" placeholder="请选输入密码" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="手机号：" label-width="100" prop="phone">
                            <el-input v-model="formMod.phone" placeholder="请输入手机号" />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="备注：" label-width="100" prop="description">
                            <el-input v-model="formMod.description" style="width: 100%" type="textarea" :rows="8"
                                placeholder="请输入备注信息" />
                        </el-form-item>

                    </el-col>
                </el-row>
            </el-from>
            <!-- 对话框按钮，# 代表插槽 -->
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="showDialog = false">取消</el-button>
                    <el-button type="primary" @click="submitForm">确认</el-button>
                </div>
            </template>
        </el-dialog>
    </div>
</template>
<script setup>
import { getList as apiSearch, add as apiAdd, edit as apiEdit, deleteByIds as apiDeleteByIds } from '@/api/adminApi'
import { Search, Plus, Refresh, Delete } from '@element-plus/icons-vue'
import { onMounted, ref, toRaw } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

const tableData = ref()
const loading = ref(false)


onMounted(() => {
    search()
})

//查询表单
const searchRef = ref({
    id: '',
    name: '',
    username: '',
    phone: ''
})
//分页信息
const pi = ref({
    total: 0,
    // pageNo: 1,
    // pageSize: 10
})

let check = true
function paginate() {
    if (check) {
        check = false
        search()
        setTimeout(() => {
            check = true
        }, 300)
    }

}

//查询操作
async function search() {
    loading.value = true//开启loading
    let params = searchRef.value
    let resp = await apiSearch(pi.value.pageNo, pi.value.pageSize, params)
    setTimeout(() => {
        tableData.value = resp.data
        pi.value = resp.pi
        loading.value = false//关闭loading
    }, 200)


}
//重置表单
const searchFormRef = ref()
function reset() {
    searchFormRef.value.resetFields()
}


//查看图片
const showViewer = ref(false)
const picList = ref([])
function showPic(pic) {
    picList.value = []
    showViewer.value = true
    picList.value.push(pic)
}

const formMod = ref({
    name: '',
    // avatar: '',
    username: '',
    password: '',
    phone: '',
    description: ''
})


const dialogTit = ref('')
const actionRef = ref(true)
//新增对话框
const showDialog = ref(false)
function add() {
    showDialog.value = true
    dialogTit.value = '新增用户'
    actionRef.value = true
}

//编辑对话框
function edit(row) {
    row = Object.assign({}, row)//浅克隆

    showDialog.value = true
    dialogTit.value = '修改信息'
    actionRef.value = false

    formMod.value = row
}

const formRef = ref()
//关闭对话框清空
function closeDia() {
    formMod.value = {}
}

//对话框表单
async function submitForm() {
    let admin = toRaw(formMod.value)
    if (actionRef.value) {
        submitAdd(admin)
    } else {
        subimtEdit(admin)
    }
}

//提交编辑
async function submitAdd(admin) {
    let resp = await apiAdd(admin)

    if (resp.success) {
        ElMessage({
            message: '操作成功',
            type: 'success'
        })
        search();
        showDialog.value = false
    } else {
        ElMessage({
            message: '操作失败',
            type: 'warning'
        })
    }
}

//提交编辑
async function subimtEdit(admin) {
    let resp = await apiEdit(admin)
    if (resp.success) {
        ElMessage({
            message: '操作成功',
            type: 'success'
        })
        search();
        showDialog.value = false
    } else {
        ElMessage({
            message: '操作失败',
            type: 'warning'
        })
    }
}


function handleChange(rawFile) {
    if (rawFile.type !== 'image/jpeg' && rawFile !== 'image/png') {
        ElMessage.error('只能上传jpg/jpeg/png图片')
        return false
    } else if (rawFile.size / 1024 / 1024 > 10) {
        ElMessage.error('上传图片最大不超过10MB')
        return false
    }
    return true
}

//头像上传成功后的回调函数
function avatarSuccess(resp) {
    if (resp.success) {
        formMod.value.avatar = resp.url
    } else {
        ElMessage({
            message: resp.msg,
            type: 'error'
        })
    }
}

const tableRef = ref()
const delTitle = ref('')
//批量删除
function del() {
    let rows = tableRef.value.getSelectionRows();
    let ids = []
    for (let row of rows) {
        ids.push(toRaw(row).id)
    }
    delTitle.value = '是否删除选中的行？'
    deleteAll(ids)
}

function delInLine(row) {
    let id = []
    id.push(row.id)
    delTitle.value = '是否删除当前行？'
    deleteAll(id)
}

function deleteAll(ids) {
    if (ids.length === 0) {
        ElMessage({
            message: '请选择要删除的行',
            type: 'warning'
        })
    } else {
        ElMessageBox.confirm(
            delTitle.value,
            '提示',
            { type: 'warning' }
        ).then(async () => {
            // 向后台发出ajax请求
            let resp = await apiDeleteByIds(ids)

            if (resp.success) {
                ElMessage({
                    message: '删除成功',
                    type: 'success'
                })
                search()
            } else {
                ElMessage({
                    message: '删除失败',
                    type: 'error'
                })
            }
        }).catch(() => {

        })
    }
}

const showDrawer = ref(false)
const rowData = ref({})
function infoData(row) {
    rowData.value = row
    showDrawer.value = true

}
</script>

<style scoped>
.data-grid {
    position: relative;
}

.fixed-row-height .el-table__row {
    height: 100px;
}

.pagination {
    margin-left: 250px;
}

.avatar-contain {
    width: 100px;
    height: 60px;
}

.row-avatar {
    height: 60px;
    background-size: contain;
    background-position: center center;
    background-repeat: no-repeat;
    margin: 0 auto;
    cursor: pointer;
}

.avatar {
    width: 140px;
    height: 140px;
    border: 1px solid #eee;
}

.avatar .icon {
    width: 140px;
    height: 140px;
}

.avatar .preview {
    width: 140px;
    height: 140px;
    background-size: cover;
    background-position: center center;
    background-repeat: no-repeat;
    /* background-color: aqua; */
}

.drawer-pic {
    height: 200px;
    margin-bottom: 20px;
}

.drawer-avatar {
    height: 200px;
}
</style>
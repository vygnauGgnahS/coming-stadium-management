<template>
    <div class="main">
        <div class="search">
            <el-form :model="searchRef" ref="searchFormRef" :inline="true">
                <el-form-item label="编号：" prop="id">
                    <el-input v-model="searchRef.id" placeholder="请输入编号" clearable style="width: 100px" />
                </el-form-item>
                <el-form-item label="名称：" prop="areaName">
                    <el-input v-model="searchRef.areaName" placeholder="请输入场地名" clearable style="width: 120px" />
                </el-form-item>
                <el-form-item label="运动项目：" prop="spId">
                    <el-select v-model="searchRef.spId" placeholder="请选择运动项目" clearable style="width: 150px" filterable>
                        <el-option key="0" label="不限" value="" />
                        <el-option v-for="sp in sportsList" :key="sp.id" :label="sp.spName" :value="sp.id" />
                    </el-select>
                </el-form-item>
                <el-form-item label="状态：" prop="status">
                    <el-select v-model="searchRef.status" placeholder="请选择场地状态" clearable style="width: 150px">
                        <el-option key="0" label="不限" value="" />
                        <el-option key="1" label="可用" value="0" />
                        <el-option key="2" label="不可用" value="1" />
                    </el-select>
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
                <el-table-column prop="areaName" label="场地名" width="150" />
                <el-table-column prop="sports.spName" label="运动项目" width="150" />
                <el-table-column prop="status" label="场地状态" width="200">
                    <template #default="scope">
                        <span v-if="scope.row.status === '0'">可用</span>
                        <span v-else>不可用</span>
                    </template>
                </el-table-column>
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

        <!-- 数据展示抽屉 -->
        <el-drawer v-model="showDrawer" show-close title="详情" direction="rtl" size="30%">
            <el-descriptions :title="rowData.nickname" direction="vertical" border>
                <el-descriptions-item label="场地名">
                    <span>{{ rowData.areaName }}</span>
                </el-descriptions-item>
                <el-descriptions-item label="运动项目">
                    <span>{{ rowData.sports.spName }}</span>
                </el-descriptions-item>
                <el-descriptions-item label="场地状态">
                    <span v-if="rowData.status === 0">可用</span>
                    <span v-else>不可用</span>
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
                    <el-col :span="8">
                        <el-form-item label="场地名：" label-width="100" prop="areaName">
                            <el-input v-model="formMod.areaName" placeholder="请输入名称" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="运动项目" label-width="100" prop="spId">
                            <el-select v-model="formMod.spId" placeholder="请选择运动项目" filterable>
                                <el-option v-for="sp in sportsList" :label="sp.spName" :value="sp.id" :key="sp.spId" />
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="场地状态：" label-width="100" prop="status">
                            <el-switch v-model="formMod.status" active-text="可用" inactive-text="不可用" active-value="0"
                                inactive-value="1" style="margin-left: 24px" inline-prompt size="large"
                                :active-icon="Check" :inactive-icon="Close" />
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
import { getList as apiSearch, add as apiAdd, edit as apiEdit, deleteByIds as apiDeleteByIds } from '@/api/areaApi'
import { getList as apiGetSports } from '@/api/sportsApi'
import { Search, Plus, Refresh, Delete } from '@element-plus/icons-vue'
import { onMounted, ref, toRaw } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'

const tableData = ref()
const loading = ref(false)


onMounted(() => {
    search()
    getSports()
})

const sportsList = ref({})
async function getSports() {
    let resp = await apiGetSports()
    sportsList.value = resp.data
}


//查询表单
const searchRef = ref({
    id: '',
    areaName: '',
    spId: '',
    status: ''
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


const formMod = ref({
    areaName: '',
    spId: '',
    status: '0',
    description: ''
})


const dialogTit = ref('')
const actionRef = ref(true)
//新增对话框
const showDialog = ref(false)
function add() {
    showDialog.value = true
    dialogTit.value = '新增场地'
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
    formMod.value.status = '0'
    
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
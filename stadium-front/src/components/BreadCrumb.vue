<template>
    <el-breadcrumb separator="/">
        <el-breadcrumb-item v-for="rt in routers" :key="rt.path" :to="{ path: rt.path }">
            {{ rt.meta.title }}
        </el-breadcrumb-item>
    </el-breadcrumb>
</template>

<script setup>
// import { ElBreadcrumb, ElBreadcrumbItem } from 'element-plus';
import { ref, onMounted, watch } from 'vue'
import { useRoute } from 'vue-router'


const current = ref()
const routers = ref([])
const paths = ref([])

const route = useRoute()
const routes = route.matched[0].children

onMounted(() => {
    
    paths.value.push('home')
    routers.value.push(route.matched[0].children[0])
    addRouter()
    

})


const props = defineProps({
    newBread: {
        type: Number,
        required: true
    }
})

let len
const emit = defineEmits(['bread']);
//监听路由信息
watch(route, () => {
    addRouter()
    len = props.newBread
    emit('bread', routers.value)
})



function addRouter() {
    current.value = route.name
    let index = paths.value.indexOf(current.value)
    if (index === -1) {
        routes.forEach(rs => {
            if (rs.name === current.value) {
                routers.value.push(rs)
                paths.value.push(rs.name)
            }
        });
    } else {
        routers.value = routers.value.slice(0, index + 1)
        paths.value = paths.value.slice(0, index + 1)
    }
}




defineExpose({ routers })

</script>

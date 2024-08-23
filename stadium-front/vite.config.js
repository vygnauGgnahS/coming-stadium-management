import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    open: true,
    port: 5000,
    proxy: {
      // 当请求 URL 以 /api 开头时，代理到目标 API 服务器
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: url => url.replace(/^\/api/, 'api/v1')
      }
    }
  },
  resolve: {
    alias: [
      {
        find: '@',
        replacement: resolve(__dirname, 'src')
      }
    ]
  }
})

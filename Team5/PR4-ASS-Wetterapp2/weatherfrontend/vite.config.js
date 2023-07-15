import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
const config = defineConfig({
  plugins: [vue()],
  server: {
    port: 5173, // Hier den gewünschten Port eintragen
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
});

export default config;

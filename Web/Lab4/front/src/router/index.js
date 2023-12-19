import { createRouter, createWebHistory } from 'vue-router';

import Index from '../Index.vue'
import Start from '../Start.vue'

const routes = [
    {
        path: '/index',
        name: 'index',
        component: Index
    },
    {
        path: '/start',
        name: 'start',
        component: Start
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})
export default router
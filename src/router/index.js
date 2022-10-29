import VueRouter from 'vue-router'
import Vue from 'vue'
import Home from '@/pages/Home'
import Login from "@/pages/Login";
Vue.use(VueRouter)

export default new VueRouter({
    routes: [
        {
            path: '/',
            component: Home,
            meta:{
                title: 'Homey'
            }
        },
        {
            path: '/login',
            component: Login,
            meta:{
                title: 'login'
            }
        }
    ]
})

import VueRouter from 'vue-router'
import Vue from 'vue'
import Home from '@/pages/Home'
import Login from "@/pages/Login";
import Register from "@/pages/Register";
import register from "@/pages/Register";
import ShopCatalog from "@/pages/ShopCatalog";
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
        },
        {
            path: '/register',
            component: Register,
            meta:{
                title: 'register'
            }
        },
        {
            path: '/shopCatalog',
            component: ShopCatalog,
            meta:{
                title: 'shopCatalog'
            }
        }
    ]
})

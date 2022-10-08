import VueRouter from 'vue-router'
import Vue from 'vue'
import Home from '../components/Home'
Vue.use(VueRouter)

export default new VueRouter({
    routes: [{
        path: '/',
        component: Home,
        meta:{
            title: 'Homey'
        }
    },
    ]
})

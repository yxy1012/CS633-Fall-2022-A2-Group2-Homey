import VueRouter from 'vue-router'
import Vue from 'vue'
import Home from '@/pages/Home'
import Login from "@/pages/Login";
import Register from "@/pages/Register";
import ShopCatalog from "@/pages/ShopCatalog";
import NotFound from "@/pages/NotFound";
import MyOrder from "@/pages/MyOrder";
import Wishlist from "@/pages/Wishlist";
import ProductDetails from "@/pages/ProductDetails";
import ShoppingCart from "@/pages/ShoppingCart";
import Checkout from "@/pages/Checkout";
import OrderCompleted from "@/pages/OrderCompleted";
Vue.use(VueRouter)

export default new VueRouter({
    scrollBehavior (to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition
        } else {
            return { x: 0, y: 0 }
        }
    },
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
        },
        {
            path: '/myOrder',
            component: MyOrder,
            meta:{
                title: 'myOrder'
            }
        },
        {
            path: '/wishlist',
            component: Wishlist,
            meta:{
                title: 'wishlist'
            }
        },
        {
            path: '/productDetails',
            component: ProductDetails,
            meta:{
                title: 'productDetails'
            }
        },
        {
            path: '/shoppingCart',
            component: ShoppingCart,
            meta:{
                title: 'shoppingCart'
            }
        },
        {
            path: '/checkout',
            component: Checkout,
            meta:{
                title: 'checkout'
            }
        },
        {
            path: '/orderCompleted',
            component: OrderCompleted,
            meta:{
                title: 'orderCompleted'
            }
        },
        {
            path: '/404',
            component: NotFound,
            meta:{
                title: '404'
            }
        },
        {
            path: '*',
            redirect: '/404'
        }
    ]
})



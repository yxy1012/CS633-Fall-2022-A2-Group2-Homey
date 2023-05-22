import Vue from "vue";
import VueRouter from 'vue-router'
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

const router =  new VueRouter({
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
                title: 'Login'
            }
        },
        {
            path: '/register',
            name: 'register',
            component: Register,
            meta:{
                title: 'Register'
            }
        },
        {
            path: '/shopCatalog',
            component: ShopCatalog,
            meta:{
                title: 'Shop Catalog'
            }
        },
        {
            path: '/myOrder',
            component: MyOrder,
            meta:{
                title: 'My Order'
            }
        },
        {
            path: '/wishlist',
            component: Wishlist,
            meta:{
                title: 'Wishlist'
            }
        },
        {
            path: '/productDetails',
            name:'productDetails',
            component: ProductDetails,
            meta:{
                title: 'Product Details'
            },
            props($route){
                return {productId: $route.query.id}
            }
        },
        {
            path: '/shoppingCart',
            component: ShoppingCart,
            meta:{
                title: 'Shopping Cart'
            }
        },
        {
            path: '/checkout',
            name: 'checkout',
            component: Checkout,
            meta:{
                title: 'Checkout'
            }
        },
        {
            path: '/orderCompleted',
            component: OrderCompleted,
            meta:{
                title: 'Order Completed'
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

router.afterEach((to, from) => {
    document.title = to.meta.title || 'Homey'
})

export default router


import Vue from 'vue'
import App from './App.vue'
import router from './router/index';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/common.css'
import './assets/iconfont/iconfont.css'
import './plugins/axios.js'
import store from './store/index.js'

Vue.config.productionTip = false
Vue.prototype.httpURL= 'http://ec2-18-223-206-255.us-east-2.compute.amazonaws.com:8181'

Vue.use(ElementUI);

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  } else {
    document.title = 'Homey'
  }
  next()
})

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
}).$mount('#app')

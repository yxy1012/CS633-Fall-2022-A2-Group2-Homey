import Vue from 'vue'
import App from './App.vue'
import router from './router';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import './assets/css/common.css'
import './assets/iconfont/iconfont.css'
import './plugins/axios.js'
import * as filters from './filters'



Vue.config.productionTip = false
// Vue.prototype.httpURL= 'http://ec2-18-223-206-255.us-east-2.compute.amazonaws.com:8181'
Vue.prototype.httpURL= 'http://localhost:8181'
Object.keys(filters).forEach(k=>Vue.filter(k, filters[k]))

Vue.use(ElementUI);

new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')

import Vue from 'vue'
import App from './App.vue'
import router from './router/index';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/common.css'

Vue.config.productionTip = false

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
  render: h => h(App),
}).$mount('#app')

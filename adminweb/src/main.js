
import Vue from 'vue'
import App from './App.vue'
import router from './router'

Vue.config.productionTip=false

new Vue({
        router,
        //渲染到app，
        render: h => h(App),
    }).$mount('#app')
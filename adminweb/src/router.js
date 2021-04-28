import  Vue from 'vue'
import VueRouter from "vue-router";
import Login from './views/login'

Vue.use(VueRouter);


export default new Router({
    mode:   'history',
    base:   process.env.BABEL_URL,
    routes: [{
        path: '*',
        redirect: "/login",
    },{
        path: 'login',
        component: Login
    }]
})
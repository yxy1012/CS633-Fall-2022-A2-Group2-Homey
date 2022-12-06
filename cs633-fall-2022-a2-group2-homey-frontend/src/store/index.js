import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        userId:'',
        email:'',
    },
    mutations: {
        setUserId(state,userId){
            state.userId = userId
        },
        setEmail(state,email){
            state.email = email
        }
    },
    getters:{
        getUserId:state => state.userId,
        getEmail:state => state.email,
    },
    actions: {
    },
    modules: {
    },
})
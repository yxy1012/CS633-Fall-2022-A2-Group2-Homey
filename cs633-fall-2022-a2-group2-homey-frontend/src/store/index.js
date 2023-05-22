import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const state = {
    userId:'',
    email:'',
}

const mutations = {
    setUserId(state,userId){
        state.userId = userId
    },
    setEmail(state,email){
        state.email = email
    }
}

const getters = {
    getUserId: state => state.userId,
    getEmail: state => state.email,
}

export default new Vuex.Store({
    state,
    mutations,
    getters
})
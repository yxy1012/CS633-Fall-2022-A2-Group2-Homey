<template>
  <div>
    <div class="pageHeader">
      <el-row>
        <el-col :span="5" class="grid-content"></el-col>
        <el-col :span="4" class="headItem" id="email">
          <div><i class="el-icon-message r-spacing" v-if="getEmail"></i>{{getEmail}}</div>
        </el-col>
        <el-col :span="7" class="grid-content"></el-col>
        <el-col :span="3" class="headItem">
          <router-link to="/login" style="text-decoration: none; color: #FFFFFF">
            <div v-if="getEmail" @click="loginOut">Sign Out<i class="el-icon-user l-spacing"></i></div>
            <div v-else>Login<i class="el-icon-user l-spacing"></i></div>
          </router-link>
        </el-col>
        <el-col :span="2" v-if="getEmail" class="headItem">
          <router-link to="/wishlist" style="text-decoration: none; color: #FFFFFF">
            <div>Wishlist<i class="iconfont icon-aixin l-spacing"></i></div>
          </router-link>
        </el-col>
        <el-col :span="1" v-if="getEmail" class="headItem" id="cart">
          <router-link to="/shoppingCart" style="text-decoration: none; color: #FFFFFF">
            <div class="cartIcon"><i class="el-icon-shopping-cart-2"></i></div>
          </router-link>
        </el-col>
        <el-col :span="2" class="grid-content"></el-col>
      </el-row>
    </div>
    <div class="topMenu">
      <el-menu :default-active="$router.path"  router class="el-menu-demo" mode="horizontal">
        <el-menu-item class="logoArea">
          <router-link to="/"><el-image :src="logoUrl" style="width: 180px; height: 50px"></el-image></router-link>
        </el-menu-item>
        <el-menu-item index="/">Home</el-menu-item>
        <el-menu-item index="/shopCatalog">Shop</el-menu-item>
        <el-menu-item index="/myOrder">My Orders</el-menu-item>
        <el-menu-item class="searchArea">
          <el-input v-model="searchContent" class="searchInput"></el-input>
          <el-button style="background-color: #e628a6;
        position: relative; right: 6px; height: 74%; width: 25%;" @click="goToShop"><i class="el-icon-search searchIcon"></i></el-button>
        </el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: "HomeHead",
  data(){
    return{
      logoUrl: require('../../assets/logo.png'),
      searchContent:''
    }
  },
  computed:{
    ...mapGetters(['getEmail'])
  },
  methods:{
    loginOut(){
      this.$store.commit('setUserId',null)
      this.$store.commit('setEmail',null)
      sessionStorage.removeItem('userId')
      sessionStorage.removeItem('email')
    },
    goToShop(){
      this.searchContent = ''
      this.$router.push('/shopCatalog')
    }
  }
}
</script>

<style scoped>
.pageHeader{
  background-color: #6729e8;
  width: 100vw;
  height: 30px;
}
.headItem{
  color: #FFFFFF;
  font-size: medium;
  font-weight: bold;
}
.cartIcon{
  float: left;
}
.r-spacing{
  margin-right: 3%;
}
.l-spacing{
  margin-left: 2%;
}
.logoArea{
  padding-left: 20%;
}
.logoArea .el-image{
  width: 180px;
  height: 50px;
}
@media screen and (max-width: 480px){
  #email{
    width: 40vw;
  }
  #cart{
    width: 8vw;
  }
  .logoArea + .el-menu-item{
    margin-left: 20vw;
  }
  .headItem{
    color: #FFFFFF;
    font-size: medium;
    font-weight: bold;
    width: 25vw;
  }
  .grid-content{
    display: none;
  }
  .logoArea{
    width: 90vw;
  }
}
</style>
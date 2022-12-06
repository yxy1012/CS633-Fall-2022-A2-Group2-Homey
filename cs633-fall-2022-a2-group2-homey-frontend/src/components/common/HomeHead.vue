<template>
  <div>
    <div class="pageHeader">
      <el-row>
        <el-col :span="5"><div class="grid-content"></div></el-col>
        <el-col :span="3">
          <div class="grid-content">
            <i class="el-icon-message r-spacing" v-if="this.$store.getters.getEmail"></i>{{ this.$store.getters.getEmail }}
          </div>
        </el-col>
<!--        <el-col :span="3"><div class="grid-content"><i class="el-icon-phone-outline r-spacing"></i>{{ phone }}</div></el-col>-->
        <el-col :span="8"><div class="grid-content"></div></el-col>
        <el-col :span="3">
          <router-link to="/login" style="text-decoration: none">
            <div class="grid-content" v-if="this.$store.getters.getEmail" @click="loginOut">
              {{signOut}}<i class="el-icon-user l-spacing"></i>
            </div>
            <div class="grid-content" v-else>{{login}}<i class="el-icon-user l-spacing"></i></div>
          </router-link>
        </el-col>
        <el-col :span="2" v-if="this.$store.getters.getEmail">
          <router-link to="/wishlist" style="text-decoration: none">
            <div class="grid-content">{{ wishlist }}<i class="iconfont icon-aixin l-spacing"></i></div>
          </router-link>
        </el-col>
        <el-col :span="1">
          <router-link to="/shoppingCart" style="text-decoration: none">
            <div class="grid-content chartIcon"><i class="el-icon-shopping-cart-2"></i></div>
          </router-link>
        </el-col>
        <el-col :span="2"><div class="grid-content"></div></el-col>
      </el-row>
    </div>
    <div class="topMenu">
      <el-menu :default-active="this.$router.path"  router class="el-menu-demo" mode="horizontal">
        <el-menu-item class="logoArea">
          <router-link to="/">
            <el-image :src="logoUrl" style="width: 180px; height: 50px"></el-image>
          </router-link>
        </el-menu-item>
        <el-menu-item index="/">Home</el-menu-item>
        <el-menu-item index="/shopCatalog">Shop</el-menu-item>
        <el-menu-item index="/myOrder">My Orders</el-menu-item>
        <el-menu-item index="4">FAQ</el-menu-item>
        <el-menu-item index="5">Contact Us</el-menu-item>
        <el-menu-item class="searchArea">
          <el-input v-model="searchContent" placeholder="" class="searchInput"></el-input>
          <el-button style="background-color: #e628a6;
        position: relative; right: 6px; height: 74%; width: 25%;">
            <i class="el-icon-search searchIcon"></i>
          </el-button>
        </el-menu-item>
      </el-menu>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeHead",
  data(){
    return{
      phone: '(617)717-2771',
      login: 'Login',
      signOut: 'Sign Out',
      wishlist: 'Wishlist',
      activeIndex: '1-1',
      logoUrl: require('../../assets/logo.png'),
      searchContent:''
    }
  },
  methods:{
    loginOut(){
      this.$store.commit('setUserId',null)
      this.$store.commit('setEmail',null)
      sessionStorage.removeItem('userId')
      sessionStorage.removeItem('email')
    }
  }
}
</script>

<style scoped>
.pageHeader{
  background-color: #6729e8;
  width: 100%;
  height: 30px;
}
.chartIcon{
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
.searchArea{
  padding-left: 5%;
  width: 25%;
}
.searchInput{
  width: 80%;
}
.searchIcon{
  color: #FFFFFF;
}
</style>
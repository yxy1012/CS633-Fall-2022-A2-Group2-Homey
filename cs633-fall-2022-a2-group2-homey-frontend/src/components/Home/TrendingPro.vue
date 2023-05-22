<template>
  <div class="trendingProducts">
    <h1>Trending Products</h1>
    <el-row>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="4" v-for="(item, index) in trendingList" :key="index" class="trendingCard">
        <router-link :to = "{path: '/productDetails', query: {id: item.id}}" style="text-decoration: none">
          <el-card :body-style="{ padding: '5px' }">
            <el-image :src="item.image" style="height: 230px; width: 100%"></el-image>
            <div class="featuredDetail">
              <h4>{{ item.name }}</h4>
              <div>
                <span>{{ item.price | priceFilter }}</span>
                <span style="text-decoration: line-through; color: darkgrey; padding-left: 2%">
                  {{ item.original_price | priceFilter }}
                </span>
              </div>
            </div>
          </el-card>
        </router-link>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-card class="trendCard1">
          <h3>23% off in all products</h3>
          <el-link style="color: #e628a6" @click="goToShop">Shop Now</el-link>
          <el-image :src="trendCard1"  class="trendImg1"></el-image>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="trendCard2">
          <h3>23% off in all products</h3>
          <el-link style="color: #e628a6" @click="goToShop">View Collection</el-link>
          <el-image :src="trendCard2" class="trendImg2"></el-image>
        </el-card>
      </el-col>
      <el-col :span="5" class="trendSide">
        <el-row v-for="(item, index) in sideList" :key="index" style="margin-bottom: 6%">
          <router-link :to="{path: '/productDetails', query: {id: item.id}}" style="color: #000000">
            <el-col :span="8">
              <el-image :src="item.image" class="trendImage"></el-image>
            </el-col>
            <el-col :span="12">
              <el-row style="float: left; font-weight: bolder;">
                {{ item.name }}
              </el-row>
              <el-row style="float: left; text-decoration: line-through">
                <el-col :span="12">{{ item.price | priceFilter}}</el-col>
                <el-col :span="12" style="text-decoration: line-through; color: darkgrey">
                  {{ item.original_price | priceFilter}}
                </el-col>
              </el-row>
            </el-col>
          </router-link>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "TrendingPro",
  props:{
    trendingList: {
      type: Array,
      default: []
    },
    trendCard1:{
      type:String,
      default: ""
    },
    trendCard2:{
      type:String,
      default: ""
    },
    sideList:{
      type: Array,
      default: []
    }
  },
  methods: {
    goToShop(){
      this.$router.push('/shopCatalog');
    }
  }
}
</script>

<style scoped>
.featuredDetail{
  padding-bottom: 5%;
}
.trendingCard{
  margin-right: 2%;
}
.trendCard1{
  background-color: #fef6fb;
  height: 200px;
  margin-left: 8%;
  margin-top: 10%;
  text-align: left;
}
.trendCard2{
  background-color: #efeffa;
  height: 200px;
  margin-left: 5%;
  margin-top: 10%;
  text-align: left;
}
.trendImg1{
  width: 45%;
  height: 45%;
  float: right;
}
.trendImg2{
  width: 80%;
  height: 80%;
  float: right;
}
.trendImage{
  width: 85%;
  height:85%;
  float: left;
}
.trendSide{
  margin-top: 2.5%;
  margin-left: 1.3%;
}
</style>
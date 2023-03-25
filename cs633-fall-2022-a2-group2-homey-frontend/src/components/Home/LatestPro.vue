<template>
  <div>
    <div class="latestProducts">
      <div>
        <h1>Latest Products</h1>
      </div>
      <div>
        <el-row>
          <el-col :span="8"><div class="grid-content"></div></el-col>
          <el-col :span="2"><el-link type="danger" @click="showNew">New Arrival</el-link></el-col>
          <el-col :span="2"><el-link type="danger" @click="showBest">Best Seller</el-link></el-col>
          <el-col :span="2"><el-link type="danger" @click="showFeatured">Featured</el-link></el-col>
          <el-col :span="2"><el-link type="danger" @click="showSpecial">Special Offer</el-link></el-col>
        </el-row>
      </div>
    </div>
    <div class="latestList">
      <el-row>
        <el-col :span="6" v-for="(item, index) in list ? list : latestList" :key="index" class="latestItem">
          <router-link :to = "{path: '/productDetails', query: {id: item.id}}" style="color: #000000">
            <el-image :src="item.image" style="height: 220px; width: 100%"></el-image>
            <span style="float: left">{{ item.name }}</span>
            <span style="float: right; color: red; text-decoration: line-through;">
              {{ item.original_price ? "$" + item.original_price.toFixed(2) : item.original_price }}
            </span>
            <span style="float: right;">{{ item.price ? "$" + item.price.toFixed(2) : item.price }}</span>
          </router-link>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "LatestPro",
  props:{
    latestList:{
      type: Array,
      default: () => ([])
    },
    featuredList:{
      type: Array,
      default: () => ([])
    },
    trendingList:{
      type: Array,
      default: () => ([])
    },
    sideList:{
      type: Array,
      default: () => ([])
    }
  },
  data(){
    return{
      list: null
    }
  },
  methods: {
    showNew(){
      this.list = this.latestList;
    },
    showBest(){
      this.list = this.trendingList;
    },
    showFeatured(){
      this.list = this.featuredList;
    },
    showSpecial(){
      this.list = this.sideList;
    },
  }
}
</script>

<style scoped>
.latestList{
  margin-left: 17%;
  margin-bottom: 5%;
}
.latestItem{
  margin-right: 2%;
}
</style>
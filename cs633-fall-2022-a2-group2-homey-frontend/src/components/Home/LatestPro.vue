<template>
  <div>
    <div class="latestProducts">
      <div>
        <h1>Latest Products</h1>
      </div>
      <div>
        <el-row>
          <el-col :span="8"><div class="grid-content"></div></el-col>
          <el-col v-for="(item, index) in titles" :span="2">
            <el-link type="danger" @click="switchList(index)">{{ item }}</el-link>
          </el-col>
        </el-row>
      </div>
    </div>
    <div class="latestList">
      <el-row>
        <el-col :span="6" v-for="(item, index) in list" :key="index" class="latestItem">
          <router-link :to="{path: '/productDetails', query: {id: item.id}}" style="color: #000000">
            <el-image :src="item.image" style="height: 220px; width: 100%"></el-image>
            <span style="float: left">{{ item.name }}</span>
            <span style="float: right; color: red; text-decoration: line-through;">{{ item.original_price | priceFilter }}</span>
            <span style="float: right;">{{ item.price | priceFilter }}</span>
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
      default: []
    },
    featuredList:{
      type: Array,
      default: []
    },
    trendingList:{
      type: Array,
      default: []
    },
    sideList:{
      type: Array,
      default: []
    }
  },
  data(){
    return{
      listType: 0,
      titles: ['New Arrival', 'Best Seller', 'Featured', 'Special Offer']
    }
  },
  computed:{
    list(){
      switch(this.listType){
        case 0: return this.latestList
        case 1: return this.trendingList
        case 2: return this.featuredList
        case 3: return this.sideList
      }
    }
  },
  methods: {
    switchList(index){
      this.listType = index
    }
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
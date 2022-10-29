<template>
  <div>
    <div class="latestProducts">
      <div>
        <h1>Latest Products</h1>
      </div>
      <div>
        <el-row>
          <el-col :span="8"><div class="grid-content"></div></el-col>
          <el-col :span="2"><el-link type="danger">New Arrival</el-link></el-col>
          <el-col :span="2"><el-link type="danger">Best Seller</el-link></el-col>
          <el-col :span="2"><el-link type="danger">Featured</el-link></el-col>
          <el-col :span="2"><el-link type="danger">Special Offer</el-link></el-col>
        </el-row>
      </div>
    </div>
    <div class="latestList">
      <el-row>
        <el-col :span="6" v-for="(item, index) in latestList" :key="index" class="latestItem">
          <el-image :src="item.image"></el-image>
          <span style="float: left">{{ item.name }}</span>
          <span style="float: right; color: red; text-decoration: line-through">{{ item.originalPrice }}</span>
          <span style="float: right">{{ item.price }}</span>
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
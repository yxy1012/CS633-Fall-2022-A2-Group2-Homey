<template>
  <div>
    <el-carousel height="600px">
      <el-carousel-item v-for="(item, index) in advList" :key="index">
        <router-link to="/ShopCatalog">
          <el-image :src="item"></el-image>
        </router-link>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: "AdvCarousel",
  props:{
    advList:{
      type: Array,
      default: () => ([])
    }
  }
}
</script>

<style scoped>

</style>
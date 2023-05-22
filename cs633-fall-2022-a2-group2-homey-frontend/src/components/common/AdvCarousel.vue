<template>
  <div>
    <el-carousel class="carousel">
      <el-carousel-item v-for="(item, index) in advList" :key="index" class="carousel">
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
      default: []
    }
  }
}
</script>

<style scoped>
.carousel{
  height: 600px;
}
::v-deep .el-carousel__container{
  height: 600px;
}
@media screen and (max-width: 480px){
  .carousel{
    height: 50vh;
  }
  ::v-deep .el-carousel__container{
    height: 50vh;
  }
  .el-image{
    height: 50vh;
  }
}
</style>
<template>
  <div class="brands">
    <el-row>
      <el-col :span="6"><div class="grid-content"></div></el-col>
      <el-col :span="12">
        <el-image :src="brandsImage"></el-image>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Brands",
  data(){
    return{
      brandsImage: require('@/assets/brandsImage.png'),
    }
  }
}
</script>

<style scoped>
.brands{
  margin-top: 5%;
}
</style>
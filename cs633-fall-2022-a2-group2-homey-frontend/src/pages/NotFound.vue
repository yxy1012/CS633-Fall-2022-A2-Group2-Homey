<template>
  <div>
    <el-image :src="notFound"></el-image>
    <el-image :src="notFoundMain" style="padding-top: 5%"></el-image>
    <el-button style="background-color: #e628a6; color: #FFFFFF;">
      <router-link to="/" style="text-decoration: none;color: #FFFFFF">Back To Home</router-link>
    </el-button>
  </div>
</template>

<script>
export default {
  name: "NotFound",
  data(){
    return{
      notFound: require("@/assets/notFound.png"),
      notFoundMain: require("@/assets/404.png")
    }
  }
}
</script>

<style scoped>

</style>
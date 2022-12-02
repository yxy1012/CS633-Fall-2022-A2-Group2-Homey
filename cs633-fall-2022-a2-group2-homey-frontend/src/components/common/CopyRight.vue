<template>
  <div class="copyRight">
    <el-row>
      <el-col :span="6"><div style="min-height: 12px"></div></el-col>
      <el-col :span="4" style="padding-top: 1%">©Homey - All Rights Reserved</el-col>
      <el-col :span="6"><div style="min-height: 12px"></div></el-col>
      <el-col :span="4">
        <el-image :src="shareIcon" style="height: 50%; width: 50%;"></el-image>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "CopyRight",
  data(){
    return{
      shareIcon: require('@/assets/shareIcon.png')
    }
  }
}
</script>

<style scoped>
.copyRight{
  padding: 1%;
  background-color: #e6e4f6;
  color: darkgrey;
  font-weight: bold;
}
</style>
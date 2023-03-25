<template>
  <div class="copyRight">
    <el-row>
      <el-col :span="6"></el-col>
      <el-col :span="4">©Homey - All Rights Reserved</el-col>
      <el-col :span="6"></el-col>
      <el-col :span="4" id="icon">
        <el-image :src="shareIcon"></el-image>
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
#icon .el-image{
  height: 50%;
  width: 50%;
}
.el-col:nth-child(0n + 2){
  padding-top: 1%;
}
.el-col:nth-child(odd){
  min-height: 12px;
}
@media screen and (max-width: 480px){
  .el-col:nth-child(0n + 2){
    margin-left: 7vw;
    width: 90vw;
  }
  #icon{
    margin-left: 20vw;
  }
}
</style>
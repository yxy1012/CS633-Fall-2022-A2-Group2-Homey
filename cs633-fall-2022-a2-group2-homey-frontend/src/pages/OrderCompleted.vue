<template>
  <div>
    <el-image :src="orderCompleted"></el-image>
    <el-row style="position: relative">
      <el-col :span="6"><div class="grid-content"></div></el-col>
      <el-col :span="14">
        <div class="continue">
          <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%; line-height: 1.5" @click="backHome">
            Continue Shopping
          </el-button>
        </div>
        <el-image :src="orderIsCompleted"></el-image>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "OrderCompleted",
  data(){
    return{
      orderCompleted: require("@/assets/orderCompleted.png"),
      orderIsCompleted: require("@/assets/oderIsCompleted.png")
    }
  },
  methods: {
    backHome(){
      this.$router.push("/");
    }
  }
}
</script>

<style scoped>
.continue{
  position: absolute;
  z-index: 100;
  top: 61%;
  left: 47%;
}
</style>
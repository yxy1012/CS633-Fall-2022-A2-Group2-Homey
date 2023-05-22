<template>
  <div class="homeyOffer">
    <div>
      <h1>What Homey Offer!</h1>
    </div>
    <div>
      <el-row>
        <el-col :span="5"><div class="grid-content"></div></el-col>
        <el-col :span="3" v-for="(item, index) in homeyOffers" :key="index" class="offerCard">
          <el-card :body-style="{padding: '0px'}">
            <el-image :src="item.image" style="width: 100%;height: 200px"></el-image>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeyOffer",
  props:{
    homeyOffers:{
      type: Array,
      default: []
    }
  }
}
</script>

<style scoped>
.offerCard{
  margin-right: 2%;
}
</style>
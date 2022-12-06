<template>
  <div class="featuredProducts">
    <div>
      <h1>Featured Products</h1>
    </div>
    <div class="featuredList">
      <el-carousel height="400px">
        <el-carousel-item v-for="item in 4" :key="item">
          <el-row>
            <el-col :span="3"><div class="grid-content"></div></el-col>
            <el-col :span="4" v-for="(item, index) in featuredList" :key="index" class="advCard">
              <router-link to="/productDetails" style="text-decoration: none">
                <el-card :body-style="{ padding: '0px' }">
                  <el-image :src="item.image"></el-image>
                  <div class="featuredDetail">
                    <h4>{{ item.name }}</h4>
                    <div>
                      {{ item.id }}
                    </div>
                    <div>
                      {{ item.price }}
                    </div>
                  </div>
                </el-card>
              </router-link>
            </el-col>
          </el-row>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
</template>

<script>
export default {
  name: "FeaturedPro",
  props:{
    featuredList:{
      type: Array,
      default: () => ([])
    }
  }
}
</script>

<style scoped>
.featuredProducts{
  margin-top: 5%;
}
.featuredList{
  margin-bottom: 5%;
}
.featuredDetail{
  padding-bottom: 5%;
}
.advCard{
  margin-right: 2%;
}
</style>
<template>
  <div>
    <el-image :src="shopCatalog"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="5">
          <h3 style="margin: 0; padding-left: 12%">Featured Items</h3>
          <p style="margin: 0; font-size: small; color: darkgrey;">About 20 results</p>
        </el-col>
        <el-col :span="6"><div class="grid-content"></div></el-col>
        <el-col :span="1" style="padding-top: 0.5%">Sort By:</el-col>
        <el-col :span="2">
          <el-select v-model="sortBy" placeholder="Best Match">
            <el-option label="Category1" value="Category1"></el-option>
            <el-option label="Category2" value="Category2"></el-option>
          </el-select>
        </el-col>
      </el-row>
    </div>
    <div class="featuredItems">
      <el-row>
        <el-col :span="5" v-for="(item, index) in latestList" :key="index" class="featuredItem">
          <el-image :src="item.image" style="width: 85%"></el-image>
          <h4 style="margin: 0">{{ item.name }}</h4>
          <el-row>
            <el-col :span="6"><div class="grid-content"></div></el-col>
            <el-col :span="6">
              {{ item.price }}
            </el-col>
            <el-col :span="6">
              <div style="color: red; text-decoration: line-through">{{ item.originalPrice }}</div>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "ShopCatalog",
  data(){
    return{
      shopCatalog: require('@/assets/shopCatalog.png'),
      latestList:[
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        },
        {
          image: require('../assets/featuredItem.png'),
          name: 'Bermund Chair',
          originalPrice: '$42.00',
          price: '$26.00'
        }
      ],
      sortBy: ''
    }
  }
}
</script>

<style scoped>
.title{
  padding-top: 5%;
}
.featuredItems{
  margin-top: 5%;
  margin-left: 17%;
  margin-bottom: 5%;
}
.featuredItem{
  margin-bottom: 3%;
}
</style>
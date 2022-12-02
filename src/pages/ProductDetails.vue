<template>
  <div>
    <el-image :src="productDetailsImage"></el-image>
    <el-row style="margin-top: 5%;">
      <el-col :span="4"><div class="grid-content"></div></el-col>
      <el-col :span="16">
        <el-card class="productDetails">
          <el-row>
            <el-col :span="3">
              <el-row v-for="(item, index) in productDetails.detailImages" :key="index">
                <el-image :src="item"></el-image>
              </el-row>
            </el-col>
            <el-col :span="8">
              <el-image :src="productDetails.mainImage"></el-image>
            </el-col>
            <el-col :span="12" style="text-align: left">
              <h1>{{ productDetails.name }}</h1>
              <el-row style="margin-bottom: 3%">
                <el-col :span="3">
                  {{ productDetails.price }}
                </el-col>
                <el-col :span="3" style="color: red; text-decoration: line-through">
                  {{ productDetails.originalPrice }}
                </el-col>
              </el-row>
              <el-row class="darkGrey" style="margin-bottom: 3%">
                {{ productDetails.description }}
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-input-number v-model="num" @change="handleChange" :min="1" :max="15" size="small"></el-input-number>
                </el-col>
                <el-col :span="5" style="padding-top: 1%">
                  <el-link :underline="false">Add to Cart</el-link>
                </el-col>
                <el-col :span="3" style="padding-top: 1%;">
                  <el-link :underline="false"><i class="iconfont icon-aixin" style="font-size: large"></i></el-link>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="3">
                  <h4>Share</h4>
                </el-col>
                <el-col :span="4" style="padding-top: 5%">
                  <el-image :src="shareIcon"></el-image>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </el-card>
      </el-col>
    </el-row>
    <el-row class="relatedProducts">
      <el-col :span="4"><div class="grid-content"></div></el-col>
      <el-col :span="18">
        <h2>Related Products</h2>
        <div>
          <el-row>
            <el-col :span="5" v-for="(item, index) in relatedProducts" :key="index" class="relatedItem">
              <el-image :src="item.image"></el-image>
              <h4 style="margin: 0">{{ item.name }}</h4>
              <el-row style="margin-top: 3%">
                <el-col :span="6">{{ item.price }}</el-col>
                <el-col style="color: red; text-decoration: line-through" :span="6">{{ item.originalPrice }}</el-col>
              </el-row>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "ProductDetails",
  data(){
    return{
      productDetailsImage: require("@/assets/productDetailsImage.png"),
      productDetails:{
        mainImage: require("@/assets/mainImage.png"),
        detailImages: [
            require("@/assets/detailImage1.png"),
            require("@/assets/detailImage2.png"),
            require("@/assets/detailImage3.png")
        ],
        name: "Bermund Chair",
        originalPrice: "$42.00",
        price: "$26.00",
        description: "The layer-glued bent wood frame gives the armchair a comfortable resilience, making it perfect to relax in.",
      },
      num: 1,
      shareIcon: require("@/assets/shareIcon2.png"),
      relatedProducts:[
        {
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          originalPrice: '$85.00',
          price: '$40.00'
        },
        {
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          originalPrice: '$85.00',
          price: '$40.00'
        },
        {
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          originalPrice: '$85.00',
          price: '$40.00'
        },
        {
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          originalPrice: '$85.00',
          price: '$40.00'
        },
      ],
    }
  },
  methods: {
    handleChange(value) {
      console.log(value);
    }
  }
}
</script>

<style scoped>
.relatedProducts{
  margin-top: 5%;
  text-align: left;
}
.relatedItem{
  margin-right: 3%;
}
</style>
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
                <el-image :src="item" style="height: 95px; width: 80%"></el-image>
              </el-row>
            </el-col>
            <el-col :span="8">
              <el-image :src="productDetails.image" style="height: 300px; width: 90%"></el-image>
            </el-col>
            <el-col :span="12" style="text-align: left">
              <h1>{{ productDetails.name }}</h1>
              <el-row style="margin-bottom: 3%">
                <el-col :span="3">
                  {{ productDetails.price | priceFilter }}
                </el-col>
                <el-col :span="3" style="color: red; text-decoration: line-through">
                  {{ productDetails.original_price | priceFilter }}
                </el-col>
              </el-row>
              <el-row class="darkGrey" style="margin-bottom: 3%">
                {{ productDetails.description }}
              </el-row>
              <el-row>
                <el-col :span="8">
                  <el-input-number v-model="num" :min="1" :max="15" size="small"></el-input-number>
                </el-col>
                <el-col :span="5" style="padding-top: 1%">
                  <el-link :underline="false" @click="addToCart">Add to Cart</el-link>
                </el-col>
                <el-col :span="3" style="padding-top: 1%;">
                  <el-link :underline="false" @click="addToWishlist"><i class="iconfont icon-aixin" style="font-size: large"></i></el-link>
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
              <router-link :to = "{path: '/productDetails', query: {id: item.id}}" style="text-decoration: none; color: #000000">
                <el-image :src="item.image" style="height: 200px; width: 100%"></el-image>
                <h4 style="margin: 0">{{ item.name }}</h4>
                <el-row style="margin-top: 3%">
                  <el-col :span="6">{{ item.price | priceFilter }}</el-col>
                  <el-col style="color: red; text-decoration: line-through" :span="6">
                    {{ item.original_price | priceFilter }}
                  </el-col>
                </el-row>
              </router-link>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {mapGetters} from "vuex";
export default {
  name: "ProductDetails",
  props:['productId'],
  data(){
    return{
      productDetailsImage: require("@/assets/productDetailsImage.png"),
      productDetails:{
        image: require("@/assets/mainImage.png"),
        detailImages: [
            require("@/assets/detailImage1.png"),
            require("@/assets/detailImage2.png"),
            require("@/assets/detailImage3.png")
        ],
        name: "Bermund Chair",
        original_price: 42.00,
        price: 26.00,
        description: "The layer-glued bent wood frame gives the armchair a comfortable resilience, making it perfect to relax in.",
      },
      num: 1,
      shareIcon: require("@/assets/shareIcon2.png"),
      relatedProducts:[
        {
          id: 1,
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          original_price: 85.00,
          price: 40.00
        },
        {
          id: 1,
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          original_price: 85.00,
          price: 40.00
        },
        {
          id: 1,
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          original_price: 85.00,
          price: 40.00
        },
        {
          id: 1,
          image: require('../assets/relatedProduct.png'),
          name: 'Queen Chair',
          original_price: 85.00,
          price: 40.00
        },
      ],
    }
  },
  computed:{
    ...mapGetters(['getUserId'])
  },
  created () {
    axios.get(this.httpURL + '/product/findById/' + this.productId).then((resp)=>{
      this.productDetails = resp.data;
      this.productDetails.detailImages = [resp.data.image, resp.data.image, resp.data.image]
    })
    axios.get(this.httpURL + '/product/findAll').then((resp)=>{
      let relatedProducts = [];
      resp.data.forEach(item => {
        if(item.type === 5){
          relatedProducts.push(item);
        }
      })
      this.relatedProducts = relatedProducts;
    })
  },
  methods: {
    addToCart(){
      if(this.getUserId === null || ''){
        this.$router.push('/login');
      }else{
        let shoppingCarts = {
          quantity: this.num,
          user: {id: this.getUserId},
          product: {id: this.productId}
        }
        axios.post(this.httpURL + "/shoppingcarts/save", shoppingCarts).then((resp)=>{
          if(resp.data === "success"){
            this.$alert('Add Successfully','Info',{
              confirmButtonText:'OK'
            })
          }else{
            this.$alert('Fail to Add','Warning',{
              confirmButtonText:'OK'
            })
          }
        })
      }
    },
    addToWishlist(){
      if(this.getUserId === null || ''){
        this.$router.push('/login');
      }else{
        let wishlist = {
          user: {id: this.getUserId},
          product: {id: this.productId}
        }
        axios.post(this.httpURL + "/wishlist/save", wishlist).then((resp)=>{
          if(resp.data === "success"){
            this.$alert('Add Successfully','Info',{
              confirmButtonText:'OK'
            })
          }else{
            this.$alert('Fail to Add','Warning',{
              confirmButtonText:'OK'
            })
          }
        })
      }
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
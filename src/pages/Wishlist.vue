<template>
  <div>
    <el-image :src="wishlistImage"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="5">
          <h3 style="margin: 0; padding-left: 5%">My Wishlist</h3>
          <p style="margin: 0; font-size: small; color: darkgrey;">About 2 results</p>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-row v-for="(item, index) in wishlist" :key="index">
        <el-col :span="4"><div class="grid-content"></div></el-col>
        <el-col :span="16">
          <el-card class="orderItem">
            <el-row>
              <el-col :span="6">
                <el-image :src="item.image"></el-image>
              </el-col>
              <el-col :span="16">
                <h3 style="color: #000000;margin-bottom: 2%;text-align: left;">Order {{item.name}}</h3>
                <div style="text-align: left; font-size: smaller; margin-bottom: 2%;">
                  <el-row class="price">
                    <el-col :span="2">
                      {{ item.price }}
                    </el-col>
                    <el-col :span="2">
                      <div style="color: red; text-decoration: line-through">{{ item.originalPrice }}</div>
                    </el-col>
                  </el-row>
                  <el-row class="darkGrey">
                    {{item.description}}
                  </el-row>
                  <el-row class="orderItemDetail">
                    <el-col :span="2"><el-button icon="el-icon-shopping-cart-2" circle></el-button></el-col>
                    <el-col :span="2"><el-button circle style="color: #e628a6"><i class="iconfont icon-aixin"></i></el-button></el-col>
                    <el-col :span="2"><el-button icon="el-icon-zoom-in" circle></el-button></el-col>
                  </el-row>
                </div>
              </el-col>
            </el-row>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Wishlist",
  data(){
    return{
      wishlistImage: require("@/assets/wishlist.png"),
      wishlist:[{
        name: "Mustard Chair",
        image: require("@/assets/wishItem1.png"),
        price: "$42.00",
        originalPrice: "$65.00",
        description: "Thanks to new research and a new technique, this upholstered chair gives you optimal seating comfort."
      },{
        name: "B&B Italian Sofa",
        image: require("@/assets/wishItem2.png"),
        price: "$135.00",
        originalPrice: "",
        description: "After a good night's sleep, you can effortlessly convert your bedroom or guest room into a living room again."
      }]
    }
  }
}
</script>

<style scoped>
.title{
  padding-top: 5%;
}
.orderItem{
  margin-left: 5%;
  margin-top: 5%;
}
.price{
  margin-bottom: 2%;
}
.orderItemDetail{
  margin-top: 3%;
  margin-bottom: 2%;
}
</style>
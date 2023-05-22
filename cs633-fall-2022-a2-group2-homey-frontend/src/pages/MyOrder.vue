<template>
  <div>
    <el-image :src="myOrder"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="5">
          <h3 style="margin: 0; padding-left: 23%">Your Order History</h3>
          <p style="margin: 0; font-size: small; color: darkgrey;">About {{ orderItems.length }} results</p>
        </el-col>
      </el-row>
    </div>
    <div>
      <el-row v-for="(item, index) in orderItems" :key="index">
        <el-col :span="4"><div class="grid-content"></div></el-col>
        <el-col :span="16">
          <el-card class="orderItem">
            <el-row>
              <el-col :span="6">
                <el-image :src="item.product.image"></el-image>
              </el-col>
              <el-col :span="4">
                <h3 style="color: #000000;margin-bottom: 5%;text-align: left;">Order# {{ item.id }}</h3>
                <div style="text-align: left; font-size: smaller; margin-bottom: 5%;">
                  <div class="orderItemDetail">
                    {{ item.total_amount | priceFilter}}
                  </div>
                  <div class="darkGrey orderItemDetail">{{ item.quantity }} items</div>
                  <el-row class="orderItemDetail">
                    <el-col class="darkGrey" :span="8">{{ item.date }}</el-col>
                    <el-col class="darkGrey" :span="2">-</el-col>
                    <el-col class="darkGrey" :span="4">{{ item.status }}</el-col>
                  </el-row>
                </div>
                <el-button style="background-color: #e628a6; color: #FFFFFF; float: left; width: 90%" @click="reorder(item)">
                  Reorder
                </el-button>
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
  name: "MyOrder",
  data(){
    return{
      myOrder: require("@/assets/myOrder.png"),
      orderItems:[{
        id: "#1231918",
        total_amount: 135.00,
        quantity: 5,
        date:"Nov 18",
        status: "Completed",
        product:{
          id: 1,
          name: 'Mustard Chair',
          price: 27.00,
          image: require("@/assets/orderItem1.png")
        }
      }]
    }
  },
  created () {
    axios.get(this.httpURL + '/orders/findByUserId/'+this.$store.getters.getUserId).then((resp)=>{
      this.orderItems = resp.data
    })
  },
  methods: {
    reorder(item){
      this.$router.push({
        name: "checkout",
        params: {
          reorder: true,
          shoppingCarts: [
            {
              quantity: item.quantity,
              product: item.product,
              user: item.user
            }
          ]
        }
      })
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
.orderItemDetail{
  margin-bottom: 2%;
}
</style>
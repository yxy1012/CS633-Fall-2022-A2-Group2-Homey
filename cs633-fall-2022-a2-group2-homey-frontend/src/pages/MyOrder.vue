<template>
  <div>
    <el-image :src="myOrder"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="5">
          <h3 style="margin: 0; padding-left: 23%">Your Order History</h3>
          <p style="margin: 0; font-size: small; color: darkgrey;">About 2 results</p>
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
                <el-image :src="item.image"></el-image>
              </el-col>
              <el-col :span="4">
                <h3 style="color: #000000;margin-bottom: 5%;text-align: left;">Order {{item.id}}</h3>
                <div style="text-align: left; font-size: smaller; margin-bottom: 5%;">
                  <div class="orderItemDetail">{{ item.price}}</div>
                  <div class="darkGrey orderItemDetail">{{ item.itemsNumber }} items</div>
                  <el-row class="orderItemDetail">
                    <el-col class="darkGrey" :span="8">{{item.date}}</el-col>
                    <el-col class="darkGrey" :span="2">-</el-col>
                    <el-col class="darkGrey" :span="4">{{item.orderStatus}}</el-col>
                  </el-row>
                </div>
                <el-button style="background-color: #e628a6; color: #FFFFFF; float: left; width: 90%">
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
        image: require("@/assets/orderItem1.png"),
        price: "$135.00",
        itemsNumber: 5,
        date:"Nov 18",
        orderStatus: "Completed"
      },{
        id: "#1231918",
        image: require("@/assets/orderItem1.png"),
        price: "$135.00",
        itemsNumber: 5,
        date:"Nov 18",
        orderStatus: "Completed"
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
.orderItemDetail{
  margin-bottom: 2%;
}
</style>
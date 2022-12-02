<template>
  <div>
    <el-image :src="shoppingCartImage"></el-image>
    <el-row>
      <el-col :span="4"><div class="grid-content"></div></el-col>
      <el-col :span="12">
        <el-table
            :data="tableData"
            :empty-text="emptyText"
            style="width: 100%">
          <el-table-column width="320" style="position: relative">
            <template slot="header">
              <h2 style="color: black">Product</h2>
            </template>
            <template v-slot:default="slotProps">
              <el-row>
                <el-col :span="8" >
                  <div class="deleteCartItem">
                    <el-link :underline="false" @click="deleteItem(slotProps.$index)">
                      <el-image :src="deleteCartItem" style="width: 30%"></el-image>
                    </el-link>
                  </div>
                  <el-image :src="slotProps.row.shoppingCartItemImage"></el-image>
                </el-col>
                <el-col :span="12" style="padding-top: 12%; color: #000000; ">
                  <h4>{{ slotProps.row.name }}</h4>
                </el-col>
              </el-row>
            </template>
          </el-table-column>
          <el-table-column width="180">
            <template slot="header">
              <h2 style="color: black">Price</h2>
            </template>
            <template v-slot:default="slotProps">
              {{ "$" + slotProps.row.price }}
            </template>
          </el-table-column>
          <el-table-column width="180">
            <template slot="header">
              <h2 style="color: black">Quantity</h2>
            </template>
            <template v-slot:default="slotProps">
              <el-input-number v-model="slotProps.row.quantity" @change="handleChange" :min="1" :max="15" size="mini"></el-input-number>
            </template>
          </el-table-column>
          <el-table-column width="70">
            <template slot="header">
              <h2 style="color: black">Total</h2>
            </template>
            <template v-slot:default="slotProps">
              {{ "$" + slotProps.row.price * slotProps.row.quantity }}
            </template>
          </el-table-column>
        </el-table>
        <el-row style="margin-top: 5%">
          <el-col :span="5">
            <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%">
              Update Cart
            </el-button>
          </el-col>
          <el-col :span="14"><div class="grid-content"></div></el-col>
          <el-col :span="5">
            <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%"
            @click="clear">
              Clear Cart
            </el-button>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="6" style="padding-top: 15%">
        <h3>Cart Totals</h3>
        <el-card style="background-color: #f1f0fe">
          <el-row>
            <el-col :span="6">
              <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Subtotals:</h4>
            </el-col>
            <el-col :span="12"><div class="grid-content"></div></el-col>
            <el-col :span="6" style="padding-top: 6%">
              {{ "$" + subTotals }}
            </el-col>
          </el-row>
          <div class="bottom-line"></div>
          <el-row>
            <el-col :span="6">
              <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Totals:</h4>
            </el-col>
            <el-col :span="12"><div class="grid-content"></div></el-col>
            <el-col :span="6" style="padding-top: 6%">
              {{ "$" + totals }}
            </el-col>
          </el-row>
          <div class="bottom-line"></div>
          <el-row style="margin-top: 5%;">
            <el-col :span="2" style="padding-top: 1%">
              <el-image :src="tip"></el-image>
            </el-col>
            <el-col :span="18" style="font-size: small; text-align: left">Shipping & taxes calculated at checkout</el-col>
          </el-row>
          <el-button style="background-color: rgb(98, 206, 121); color: #FFFFFF; width: 100%; margin-top: 5%"
          @click="toCheckout">
            Proceed To Checkout
          </el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "ShoppingCart",
  data(){
    return{
      shoppingCartImage: require("@/assets/shoppingCartImage.png"),
      deleteCartItem: require("@/assets/deleteCartItem.png"),
      emptyText: "No Item",
      tableData: [{
        name: 'Bermund Chair',
        shoppingCartItemImage: require("@/assets/shoppingCartItem.png"),
        price: 26.00,
        quantity: 2,
        total: 26.00
      }, {
        name: 'Bermund Chair',
        shoppingCartItemImage: require("@/assets/shoppingCartItem.png"),
        price: 26.00,
        quantity: 1,
        total: 26.00
      }, {
        name: 'Bermund Chair',
        shoppingCartItemImage: require("@/assets/shoppingCartItem.png"),
        price: 26.00,
        quantity: 1,
        total: 26.00
      }, {
        name: 'Bermund Chair',
        shoppingCartItemImage: require("@/assets/shoppingCartItem.png"),
        price: 26.00,
        quantity: 1,
        total: 26.00
      }],
      tip: require("@/assets/tip.png")
    }
  },
  methods: {
    handleChange(value) {
      console.log(value);
    },
    deleteItem(index){
      this.tableData.splice(index, 1);
    },
    clear(){
      this.tableData = [];
    },
    toCheckout(){
      this.$router.push("/checkout");
    }
  },
  computed: {
    subTotals: function (){
      let sum = 0;
      this.tableData.forEach(item => {
        sum += item.price * item.quantity
      })
      return sum;
    },
    totals: function (){
      let sum = 0;
      this.tableData.forEach(item => {
        sum += item.price * item.quantity
      })
      return sum;
    }
  }
}
</script>

<style scoped>
.bottom-line{
  min-height: 1px;
  background-color: rgb(213, 214, 218);
  margin-left: 2%;
  margin-top: 2%;
}
.deleteCartItem{
  position: absolute;
  z-index: 100;
  left: 25%;
}
</style>
<template>
  <div>
    <el-image :src="checkout"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="5"><div class="grid-content"></div></el-col>
        <el-col :span="12">
          <h3 style="margin: 0; text-align: left">Shipping Details</h3>
          <p style="margin: 0; font-size: small; color: darkgrey; text-align: left">Enter Your Shipping Address Here!</p>
          <div class="shippingDetails">
            <el-row>
              <el-col :span="8">
                <h4 style="margin: 0; text-align: left">Contact Information</h4>
              </el-col>
              <el-col :span="8"><div class="grid-content"></div></el-col>
              <el-col :span="8" style="font-size: smaller">
                <span class="darkGrey">{{ haveAccount }}</span>
                <router-link to="login" class="darkGrey" style="text-decoration: none;">
                  {{ logIn }}
                </router-link>
              </el-col>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="Email or mobile phone number"></el-input>
            </el-row>
            <el-row style="font-size: smaller">
              <el-checkbox :label="upDate" name="type"></el-checkbox>
            </el-row>
            <el-row style="margin-top: 10%" class="mgb-3">
              <h4 style="margin: 0; text-align: left">Shipping Address</h4>
            </el-row>
            <el-row class="mgb-3">
              <el-col :span="10">
                <el-input placeholder="First name(optional)"></el-input>
              </el-col>
              <el-col :span="4"><div class="grid-content"></div></el-col>
              <el-col :span="10">
                <el-input placeholder="Last name"></el-input>
              </el-col>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="Address"></el-input>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="Apartment, suit, etc(optional)"></el-input>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="City"></el-input>
            </el-row>
            <el-row class="mgb-3">
              <el-col :span="10">
                <el-input placeholder="United States"></el-input>
              </el-col>
              <el-col :span="4"><div class="grid-content"></div></el-col>
              <el-col :span="10">
                <el-input placeholder="Postal Code"></el-input>
              </el-col>
            </el-row>
            <el-row style="margin-top: 10%">
              <el-col :span="6">
                <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%">
                  Calculate Shipping
                </el-button>
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col :span="6" style="margin-top: 3%; margin-left: 2%">
          <el-row v-for="(item, index) in checkoutItems" :key="index">
            <el-row>
              <el-col :span="5">
                <el-image :src="item.shoppingCartItemImage"></el-image>
              </el-col>
              <el-col :span="10" style="margin-top: 2%">
                <h5 style="text-align: left; margin-bottom: 0">{{ item.name }}</h5>
                <el-row style="font-size: small">
                  <el-col class="darkGrey" :span="3">{{ "$" + item.price }}</el-col>
                  <el-col class="darkGrey" :span="3">{{ "*" + item.quantity }}</el-col>
                </el-row>
              </el-col>
              <el-col :span="2" style="margin-top: 10%">
                {{ "$" + item.total }}
              </el-col>
            </el-row>
            <el-row>
              <div class="bottom-line"></div>
            </el-row>
          </el-row>
          <el-row :span="6" style="padding-top: 5%">
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
                <el-col :span="10">
                  <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Shipping & Tax:</h4>
                </el-col>
                <el-col :span="8"><div class="grid-content"></div></el-col>
                <el-col :span="6" style="padding-top: 6%">
                  {{ "$" + shippingAndTax }}
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
              <el-button style="background-color: rgb(98, 206, 121); color: #FFFFFF; width: 100%; margin-top: 5%"
                         @click="toCheckout">
                Proceed To Checkout
              </el-button>
            </el-card>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Checkout",
  data(){
    return{
      checkout: require("@/assets/checkout.png"),
      haveAccount: "Already have an account?",
      logIn: "Log in",
      upDate: "Keep me up to date on news and exclusive offers",
      checkoutItems: [{
        name: 'Bermund Chair',
        shoppingCartItemImage: require("@/assets/shoppingCartItem.png"),
        price: 26.00,
        quantity: 2,
        total: 52.00
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
      shippingAndTax: 15.00
    }
  },
  computed: {
    subTotals: function (){
      let sum = 0;
      this.checkoutItems.forEach(item => {
        sum += item.price * item.quantity
      })
      return sum;
    },
    totals: function (){
      let sum = 0;
      this.checkoutItems.forEach(item => {
        sum += item.price * item.quantity
      })
      return sum + this.shippingAndTax;
    }
  },
  methods: {
    toCheckout(){
      this.$router.push("/orderCompleted");
    }
  }
}
</script>

<style scoped>
.title{
  padding-top: 5%;
}
.shippingDetails{
  background-color: #f1f0fe;
  margin-top: 3%;
  padding: 5% 3% 5% 3% ;
  text-align: left;
}
::v-deep .el-input__inner {
  border-radius: 0px;
  border-top-width: 0px;
  border-left-width: 0px;
  border-right-width: 0px;
  border-bottom-width: 1px;
  background-color: #f1f0fe;
  padding: 0;
  /*outline: medium;*/
}
.bottom-line{
  min-height: 1px;
  background-color: rgb(213, 214, 218);
  margin-left: 2%;
  margin-top: 2%;
}
</style>
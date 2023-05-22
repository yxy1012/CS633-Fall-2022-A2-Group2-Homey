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
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="Mobile phone number" v-model="user.phone_number"></el-input>
            </el-row>
            <el-row style="font-size: smaller">
              <el-checkbox :label="uptoDate" name="type"></el-checkbox>
            </el-row>
            <el-row style="margin-top: 10%" class="mgb-3">
              <h4 style="margin: 0; text-align: left">Shipping Address</h4>
            </el-row>
            <el-row class="mgb-3">
              <el-col :span="10">
                <el-input placeholder="First name(optional)" v-model="user.first_name"></el-input>
              </el-col>
              <el-col :span="4"><div class="grid-content"></div></el-col>
              <el-col :span="10">
                <el-input placeholder="Last name" v-model="user.last_name"></el-input>
              </el-col>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="Address" v-model="user.address"></el-input>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="Apartment, suit, etc(optional)" v-model="user.apartment"></el-input>
            </el-row>
            <el-row class="mgb-3">
              <el-input placeholder="City" v-model="user.city"></el-input>
            </el-row>
            <el-row class="mgb-3">
              <el-col :span="10">
                <el-input placeholder="United States" v-model="user.country" :disabled="true"></el-input>
              </el-col>
              <el-col :span="4"><div class="grid-content"></div></el-col>
              <el-col :span="10">
                <el-input placeholder="Postal Code" v-model="user.postal_code"></el-input>
              </el-col>
            </el-row>
            <el-row style="margin-top: 10%">
              <el-col :span="6">
                <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%" @click="calculate">
                  Calculate Shipping
                </el-button>
              </el-col>
              <el-col :span="8"><div class="grid-content"></div></el-col>
              <el-col :span="6">
                <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%" @click="update">
                  Update Information
                </el-button>
              </el-col>
            </el-row>
          </div>
        </el-col>
        <el-col :span="6" style="margin-top: 3%; margin-left: 2%">
          <el-row v-for="(item, index) in checkoutItems" :key="index">
            <el-row>
              <el-col :span="5">
                <el-image :src="item.product.image"></el-image>
              </el-col>
              <el-col :span="10" style="margin-top: 2%">
                <h5 style="text-align: left; margin-bottom: 0">{{ item.product.name }}</h5>
                <el-row style="font-size: small">
                  <el-col class="darkGrey" :span="8">
                    {{ item.product.price | priceFilter }}
                  </el-col>
                  <el-col class="darkGrey" :span="8">{{ "*" + item.quantity }}</el-col>
                </el-row>
              </el-col>
              <el-col :span="2" style="margin-top: 10%">
                {{ item.product.price * item.quantity | priceFilter }}
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
                  {{ subTotals | priceFilter}}
                </el-col>
              </el-row>
              <div class="bottom-line"></div>
              <el-row>
                <el-col :span="10">
                  <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Shipping & Tax:</h4>
                </el-col>
                <el-col :span="8"><div class="grid-content"></div></el-col>
                <el-col :span="6" style="padding-top: 6%">
                  {{ shippingAndTax | priceFilter}}
                </el-col>
              </el-row>
              <div class="bottom-line"></div>
              <el-row>
                <el-col :span="6">
                  <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Totals:</h4>
                </el-col>
                <el-col :span="12"><div class="grid-content"></div></el-col>
                <el-col :span="6" style="padding-top: 6%">
                  {{ totals | priceFilter}}
                </el-col>
              </el-row>
              <div class="bottom-line"></div>
              <el-button style="background-color: rgb(98, 206, 121); color: #FFFFFF; width: 100%; margin-top: 5%" @click="toCheckout">
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
      uptoDate: "Keep me up to date on news and exclusive offers",
      checkoutItems: [{
        id: 1,
        quantity: 2,
        product: {
          id: 1,
          name: 'Bermund Chair',
          image: require("@/assets/shoppingCartItem.png"),
          price: 26.00,
        },
        user:{
          id: 0
        }
      }, {
        id: 1,
        quantity: 1,
        product: {
          id: 1,
          name: 'Bermund Chair',
          image: require("@/assets/shoppingCartItem.png"),
          price: 26.00,
        },
        user:{
          id: 0
        }
      }, {
        id: 1,
        quantity: 1,
        product: {
          id: 1,
          name: 'Bermund Chair',
          image: require("@/assets/shoppingCartItem.png"),
          price: 26.00,
        },
        user:{
          id: 0
        }
      }, {
        id: 1,
        quantity: 1,
        product: {
          id: 1,
          name: 'Bermund Chair',
          image: require("@/assets/shoppingCartItem.png"),
          price: 26.00,
        },
        user:{
          id: 0
        }
      }],
      shippingAndTax: 0,
      user:{
        phone_number: '',
        first_name: '',
        last_name: '',
        address: '',
        apartment: '',
        city: '',
        country: '',
        postal_code: ''
      }
    }
  },
  created(){
    this.checkoutItems = this.$route.params.shoppingCarts
    axios.get(this.httpURL + "/user/findById/" + this.$store.getters.getUserId).then((resp)=>{
      this.user = resp.data
    })
  },
  computed: {
    subTotals(){
      return this.checkoutItems.reduce((pre, cur)=>pre += cur.product.price * cur.quantity, 0);
    },
    totals(){
      return this.checkoutItems.reduce((pre, cur)=>pre += cur.product.price * cur.quantity, this.shippingAndTax)
    }
  },
  methods:{
    toCheckout(){
      if(this.shippingAndTax !== 0){
        let checkoutItems = [];
        this.checkoutItems.forEach(item=>{
          const date = new Date;
          const checkoutItem = {
            quantity: item.quantity,
            total_amount: item.product.price * item.quantity,
            status: "Completed",
            date: date.toDateString().split( " " )[1] + " " + date.getDate(),
            user: {
              id: this.$store.getters.getUserId
            },
            product: {
              id: item.product.id
            }
          }
          checkoutItems.push(checkoutItem);
        })
        axios.post(this.httpURL + '/orders/saveAll', checkoutItems).then((resp)=>{
          if(resp.data === "success"){
            if(!this.$route.params.reorder){
              axios.put(this.httpURL + '/shoppingcarts/deleteAll', this.checkoutItems).then(()=>{
                this.$router.push("/orderCompleted");
              })
            }else{
              this.$router.push("/orderCompleted");
            }
          }else{
            this.$alert('Fail to Checkout','Warning',{
              confirmButtonText:'OK'
            })
          }
        })
      }else{
        this.$alert('Please Calculate Shipping','Warning',{
          confirmButtonText:'OK'
        })
      }
    },
    calculate(){
      this.shippingAndTax = this.subTotals * 0.08 + 5;
    },
    update(){
      axios.put(this.httpURL + '/user/update', this.user).then((resp)=>{
        if(resp.data === "success"){
          this.$alert('Update Successfully','Info',{
            confirmButtonText:'OK'
          })
        }else{
          this.$alert('Fail to Update','Warning',{
            confirmButtonText:'OK'
          })
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
::v-deep .el-input.is-disabled .el-input__inner{
  background-color: #f1f0fe;
}
.bottom-line{
  min-height: 1px;
  background-color: rgb(213, 214, 218);
  margin-left: 2%;
  margin-top: 2%;
}
</style>
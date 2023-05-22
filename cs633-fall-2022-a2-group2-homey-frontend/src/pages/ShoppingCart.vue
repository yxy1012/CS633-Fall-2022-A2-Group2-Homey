<template>
  <div>
    <el-image :src="shoppingCartImage"></el-image>
    <el-row>
      <el-col :span="4"><div class="grid-content"></div></el-col>
      <el-col :span="12">
        <el-table :data="tableData" :empty-text="emptyText" style="width: 100%">
          <el-table-column width="320" style="position: relative">
            <template slot="header">
              <h2 style="color: black">Product</h2>
            </template>
            <template v-slot="slotProps">
              <el-row>
                <el-col :span="8">
                  <div class="deleteCartItem">
                    <el-link :underline="false" @click="deleteItem(slotProps.$index)">
                      <el-image :src="deleteCartItem" style="width: 30%"></el-image>
                    </el-link>
                  </div>
                  <el-image :src="slotProps.row.product.image"></el-image>
                </el-col>
                <el-col :span="12" style="color: #000000; ">
                  <h4>{{ slotProps.row.product.name }}</h4>
                </el-col>
              </el-row>
            </template>
          </el-table-column>
          <el-table-column width="180">
            <template slot="header">
              <h2 style="color: black">Price</h2>
            </template>
            <template v-slot="slotProps">
              {{ slotProps.row.product.price | priceFilter }}
            </template>
          </el-table-column>
          <el-table-column width="170">
            <template slot="header">
              <h2 style="color: black">Quantity</h2>
            </template>
            <template v-slot="slotProps">
              <el-input-number v-model="slotProps.row.quantity" :min="1" :max="15" size="mini"></el-input-number>
            </template>
          </el-table-column>
          <el-table-column width="80">
            <template slot="header">
              <h2 style="color: black">Total</h2>
            </template>
            <template v-slot="slotProps">
              {{ slotProps.row.product.price * slotProps.row.quantity | priceFilter}}
            </template>
          </el-table-column>
        </el-table>
        <el-row style="margin-top: 5%">
          <el-col :span="5">
            <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%" @click="update">
              Update Cart
            </el-button>
          </el-col>
          <el-col :span="14"><div class="grid-content"></div></el-col>
          <el-col :span="5">
            <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%" @click="clear">
              Clear Cart
            </el-button>
          </el-col>
        </el-row>
      </el-col>
      <el-col :span="6">
        <h3>Cart Totals</h3>
        <el-card style="background-color: #f1f0fe">
          <el-row>
            <el-col :span="6">
              <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Subtotals:</h4>
            </el-col>
            <el-col :span="12"><div class="grid-content"></div></el-col>
            <el-col :span="6" style="padding-top: 6%">
              {{ subTotals | priceFilter }}
            </el-col>
          </el-row>
          <div class="bottom-line"></div>
          <el-row>
            <el-col :span="6">
              <h4 style="margin-bottom: 0; text-align: left; margin-left: 3%">Totals:</h4>
            </el-col>
            <el-col :span="12"><div class="grid-content"></div></el-col>
            <el-col :span="6" style="padding-top: 6%">
              {{ totals | priceFilter }}
            </el-col>
          </el-row>
          <div class="bottom-line"></div>
          <el-row style="margin-top: 5%;">
            <el-col :span="2" style="padding-top: 1%">
              <el-image :src="tip"></el-image>
            </el-col>
            <el-col :span="18" style="font-size: small; text-align: left">Shipping & taxes calculated at checkout</el-col>
          </el-row>
          <el-button style="background-color: rgb(98, 206, 121); color: #FFFFFF; width: 100%; margin-top: 5%" @click="toCheckout">
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
        id: 1,
        quantity: 2,
        product:{
          id: 2,
          name: "B&B Italian Sofa",
          quantity: 2,
          price: 135.0,
          original_price: null,
          description: "After a good night's sleep, you can effortlessly convert your bedroom or guest room into a living room again.",
          image: "http://localhost:8181/images/wishItem2.png"
        },
        user:{
          id: 0
        }
      }],
      tip: require("@/assets/tip.png")
    }
  },
  created(){
    axios.get(this.httpURL + '/shoppingcarts/findByUserId/' + this.$store.getters.getUserId).then((resp)=>{
      this.tableData = resp.data
    })
  },
  methods:{
    deleteItem(index){
      this.$confirm('Delete this item?', 'Warning', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(()=>{
        const id = this.tableData[index].id
        axios.delete(this.httpURL + '/shoppingcarts/deleteById/' + id).then(()=>{
          this.tableData.splice(index, 1);
        })
        this.$message({
          type: 'success',
          message: 'Delete Successfully'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Cancel Deleting'
        })
      })
    },
    clear(){
      this.$confirm('Clear this cart?', 'Warning', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(()=>{
        axios.put(this.httpURL + '/shoppingcarts/deleteAll', this.tableData).then(()=>{
          this.tableData = [];
        })
        this.$message({
          type: 'success',
          message: 'Delete Successfully'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Cancel Clearing'
        })
      })
    },
    toCheckout(){
      if(this.tableData.length > 0){
        this.$router.push({
          name: "checkout",
          params: {
            reorder: false,
            shoppingCarts: this.tableData
          }
        })
      }else{
        this.$alert('No Items in the Shopping Cart','Warning',{
          confirmButtonText:'OK'
        })
      }
    },
    update(){
      axios.put(this.httpURL + '/shoppingcarts/update', this.tableData).then((resp)=>{
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
  },
  computed:{
    subTotals(){
      return this.tableData.reduce((pre, cur)=>pre += cur.product.price * cur.quantity, 0)
    },
    totals(){
      return this.tableData.reduce((pre, cur)=>pre += cur.product.price * cur.quantity, 0)
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
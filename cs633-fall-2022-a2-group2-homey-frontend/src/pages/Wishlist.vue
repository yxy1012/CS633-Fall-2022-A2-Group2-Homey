<template>
  <div>
    <el-image :src="wishlistImage"></el-image>
    <div class="title">
      <el-row>
        <el-col :span="3"><div class="grid-content"></div></el-col>
        <el-col :span="5">
          <h3 style="margin: 0; padding-left: 5%">My Wishlist</h3>
          <p style="margin: 0; font-size: small; color: darkgrey;">About {{ wishlist.length }} results</p>
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
                <el-image :src="item.product.image"></el-image>
              </el-col>
              <el-col :span="16">
                <h3 style="color: #000000;margin-bottom: 2%;text-align: left;">{{item.product.name}}</h3>
                <div style="text-align: left; font-size: smaller; margin-bottom: 2%;">
                  <el-row class="price">
                    <el-col :span="2">
                      {{item.product.price ? "$" + item.product.price.toFixed(2) : item.price}}
                    </el-col>
                    <el-col :span="2">
                      <div style="color: red; text-decoration: line-through">
                        {{item.product.original_price ? "$" + item.product.original_price.toFixed(2) : item.product.original_price}}
                      </div>
                    </el-col>
                  </el-row>
                  <el-row class="darkGrey">
                    {{item.product.description}}
                  </el-row>
                  <el-row class="orderItemDetail">
                    <el-col :span="2">
                      <el-button icon="el-icon-shopping-cart-2" circle @click="addToCart(index)"></el-button>
                    </el-col>
                    <el-col :span="2">
                      <el-button circle style="color: #e628a6" @click="remove(index)"><i class="iconfont icon-aixin"></i></el-button>
                    </el-col>
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
        id: 1,
        product:{
          name: "Mustard Chair",
          image: require("@/assets/wishItem1.png"),
          price: "$42.00",
          original_price: "$65.00",
          description: "Thanks to new research and a new technique, this upholstered chair gives you optimal seating comfort."
        }
      }]
    }
  },
  created () {
    const _this=this
    axios.get('http://localhost:8181/wishlist/findByUserId/'+this.$store.getters.getUserId).then(function (resp) {
      console.log(resp)
      _this.wishlist = resp.data
    })
  },
  methods:{
    remove(index){
      this.$confirm('Remove this item?', 'Warning', {
        confirmButtonText: 'Confirm',
        cancelButtonText: 'Cancel',
        type: 'warning'
      }).then(() => {
        let id = this.wishlist[index].id;
        const _this=this
        axios.delete('http://localhost:8181/wishlist/deleteById/' + id).then(function (resp){
          _this.wishlist.splice(index, 1);
        })
        this.$message({
          type: 'success',
          message: 'Remove Successfully'
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: 'Cancel Removing'
        });
      });
    },
    addToCart(index){
      let shoppingcart = {
        user: {id: this.$store.getters.getUserId},
        product: {id: this.wishlist[index].product.id},
        quantity: 1
      };
      const _this = this
      axios.post('http://localhost:8181/shoppingcarts/save', shoppingcart).then(function (resp){
        console.log(resp)
        if(resp.data == "success"){
          _this.$alert('Add Successfully','Info',{
            confirmButtonText:'OK'
          });
        }else{
          _this.$alert('Fail to Add','Warning',{
            confirmButtonText:'OK'
          });
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
.price{
  margin-bottom: 2%;
}
.orderItemDetail{
  margin-top: 3%;
  margin-bottom: 2%;
}
</style>
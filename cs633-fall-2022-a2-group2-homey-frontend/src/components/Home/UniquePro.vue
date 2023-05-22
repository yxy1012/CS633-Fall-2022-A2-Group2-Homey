<template>
  <div class="unique">
    <el-row>
      <el-col :span="6"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-image :src="uniqueProduct.image"></el-image>
      </el-col>
      <el-col :span="8">
        <h1>Unique Features of Latest & Trending Products</h1>
        <ul>
          <li v-for="(item, index) in uniqueProduct.details" :key="index">
            {{ item }}
          </li>
        </ul>
        <el-row>
          <el-col :span="6">
            <el-button style="background-color: #e628a6; color: #FFFFFF" @click="addToCart">
              Add To Cart
            </el-button>
          </el-col>
          <el-col :span="8">
            <el-row>{{ uniqueProduct.name }}</el-row>
            <el-row>{{ uniqueProduct.price }}</el-row>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "UniquePro",
  props:{
    uniqueProduct:{
      type: Object,
      default: {}
    }
  },
  methods:{
    addToCart(){
      const shoppingCart = {
        user: {id: this.$store.getters.getUserId},
        product: {id: this.uniqueProduct.id},
        quantity: 1
      }
      axios.post(this.httpURL + '/shoppingcarts/save', shoppingCart).then((resp)=>{
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
</script>

<style scoped>
.unique{
  margin-top: 5%;
  margin-bottom: 5%;
  padding-top: 5%;
  min-height: 400px;
  background-color: #f1f0fe;
  text-align: left
}
</style>
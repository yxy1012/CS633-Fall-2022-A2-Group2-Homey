<template>
  <div class="pageFooter">
    <el-row>
      <el-col :span="5"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-row><h1 style="float: left">Homey</h1></el-row>
        <el-row>
          <el-input placeholder="Enter Email Address" style="width: 60%; float: left;" v-model="email"></el-input>
          <el-button style="float: left; width: 35%; position: relative; right: 12px;
          background-color: #e628a6; color: #FFFFFF" @click="goToRegister">Sign up</el-button>
        </el-row>
        <el-row v-for="(item, index) in info" :key="index">
          <el-link style="float: left; margin-top: 5%">{{item}}</el-link>
        </el-row>
      </el-col>
      <el-col :span="4" style="margin-left: 5%">
        <el-row class="categories"><h3>Categories</h3></el-row>
        <el-row v-for="(item, index) in categories" :key="index" class="categories">
          <el-link>{{item}}</el-link>
        </el-row>
      </el-col>
      <el-col :span="4">
        <el-row class="customerCare"><h3>Customer Care</h3></el-row>
        <el-row v-for="(item, index) in customerCare" :key="index" class="customerCare">
          <el-link>{{item}}</el-link>
        </el-row>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "PageFooter",
  data() {
    return {
      email: '',
      info:['Contact Info', '1010 Commonwealth Avenue, Boston, MA 02215'],
      categories: ['Chairs & Sofas', 'Tables', 'Bed', 'Bookcases', 'Dressers & Wardrobes'],
      customerCare: ['My Account', 'Order History', 'Order Tracking', 'FAQ', 'Contact Us']
    }
  },
  methods : {
    goToRegister(){
      this.$router.push({
        name: "register",
        query: {
          email: this.email
        }
      });
      this.email = ''
    }
  }
}
</script>

<style scoped>
.pageFooter{
  padding-top: 3%;
  padding-bottom: 6%;
  margin-top: 5%;
  background-color: #f1f0fe;
}
.categories{
  margin-bottom: 2%;
  text-align: left;
}
.customerCare{
  margin-bottom: 2%;
  text-align: left;
}
</style>
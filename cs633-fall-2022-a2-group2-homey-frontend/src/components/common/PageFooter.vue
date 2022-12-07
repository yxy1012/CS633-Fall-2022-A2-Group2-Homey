<template>
  <div class="pageFooter">
    <el-row>
      <el-col :span="5"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-row>
          <h1 style="float: left">Homey</h1>
        </el-row>
        <el-row>
          <el-input placeholder="Enter Email Address" style="width: 60%; float: left;" v-model="email"></el-input>
          <el-button style="float: left; width: 35%; position: relative; right: 12px;
          background-color: #e628a6; color: #FFFFFF" @click="goToRegister">
              Sign up
          </el-button>
        </el-row>
        <el-row>
          <el-link style="float: left; margin-top: 5%">
            Contact Info
          </el-link>
        </el-row>
        <el-row>
          <el-link style="float: left; margin-top: 5%">
            1010 Commonwealth Avenue, Boston, MA 02215
          </el-link>
        </el-row>
      </el-col>
      <el-col :span="4" style="margin-left: 5%">
        <el-row class="categories">
          <h3>Categories</h3>
        </el-row>
        <el-row class="categories">
          <el-link>Chairs & Sofas</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Tables</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Bed</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Bookcases</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Dressers & Wardrobes</el-link>
        </el-row>
      </el-col>
      <el-col :span="4">
        <el-row class="customerCare">
          <h3>Customer Care</h3>
        </el-row>
        <el-row class="customerCare">
          <el-link>My Account</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>Order History</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>Order Tracking</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>FAQ</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>Contact Us</el-link>
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
      email:''
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
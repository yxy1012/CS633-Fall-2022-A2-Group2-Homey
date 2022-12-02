<template>
  <div>
    <el-image :src="myAccount"></el-image>
    <div class="loginCard">
      <el-row>
        <el-col :span="9"><div class="grid-content"></div></el-col>
        <el-col :span="7">
          <el-card class="login">
            <h2>{{ formTitle }}</h2>
            <p class="hint">{{ hint }}</p>
            <el-form ref="form" :model="form">
              <el-form-item>
                <el-input v-model="form.email" placeholder="Email Address"></el-input>
              </el-form-item>
              <el-form-item>
                <el-input placeholder="Password" v-model="form.password" show-password></el-input>
              </el-form-item>
              <el-form-item>
                <el-input placeholder="Confirm Password" v-model="form.confirmPassword" show-password></el-input>
              </el-form-item>
              <el-form-item>
                <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%">
                  {{ btnTitle }}
                </el-button>
              </el-form-item>
              <el-form-item>
                <span class="darkGrey">{{ haveAccount }}</span>
                <router-link to="login">
                  {{ goSignIn }}
                </router-link>
              </el-form-item>
            </el-form>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data(){
    return{
      myAccount: require("@/assets/myAccount.png"),
      formTitle: "Register",
      hint: "Please register by creating account below.",
      form: {
        email: "",
        password: "",
        confirmPassword: ""
      },
      btnTitle: "Sign Up",
      haveAccount: "Already have an account?",
      goSignIn: "Go to sign in"
    }
  }
}
</script>

<style scoped>
.loginCard{
  margin-top: 4%;
}
.login{
  padding-left: 7%;
  padding-right: 7%;
}
.hint{
  color: darkgrey;
}
a{
  color: darkgrey;
  text-decoration: none;
}
</style>
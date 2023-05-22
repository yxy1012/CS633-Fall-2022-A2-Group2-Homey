<template>
  <div>
    <el-image :src="myAccount"></el-image>
    <div class="loginCard">
      <el-row>
        <el-col :span="9"><div class="grid-content"></div></el-col>
        <el-col :span="7">
          <el-card class="login">
            <h2>Login</h2>
            <p class="hint">Please login using account detail below.</p>
            <el-form ref="form" :model="form" :rules="rules">
              <el-form-item prop="email">
                <el-input v-model="form.email" placeholder="Email Address"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input placeholder="Password" v-model="form.password" show-password></el-input>
<!--                <a href="javascript:void(0);" class="forgot">Forgot your password?</a>-->
              </el-form-item>
              <el-form-item>
                <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%" @click="login">Sign In</el-button>
              </el-form-item>
              <el-form-item>
                <span class="darkGrey">Don't have an account?</span>
                <router-link to="register">Create account</router-link>
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
  name: "Login",
  data(){
    const checkEmail = (rule, value, callback) => {
      const regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (regEmail.test(value)) {
        return callback();
      }
      callback(new Error("Please enter correct email address"));
    };
    return{
      myAccount: require("@/assets/myAccount.png"),
      form: {
        email: "",
        password: ""
      },
      rules:{
        email:[
          { required: true, message: 'Please enter your email', trigger: 'blur' },
          { validator: checkEmail, trigger: 'blur' }
        ],
        password: [
          { required: true, message: 'Please enter your password', trigger: 'blur' },
          { min: 6, max: 16, message: '6 to 16 characters in length', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    login(){
      this.$refs.form.validate((valid)=>{
        if (valid) {
          axios.get(this.httpURL + '/user/login/' + this.form.email + '/' + this.form.password).then((resp)=>{
            const {login, id, email} = resp.data
            if(login){
              sessionStorage.setItem('userId', id)
              sessionStorage.setItem('email', email)
              this.$store.commit('setUserId', id)
              this.$store.commit('setEmail', email)
              this.$router.push({path:'/'})
            }else{
              this.$alert('Uncorrected password or email address','Alert');
            }
          })
        }else{
          this.$alert('Error email format or password format','Alert');
        }
      })
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

.forgot{
  float: left;
}
</style>
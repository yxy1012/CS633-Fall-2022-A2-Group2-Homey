<template>
  <div>
    <el-image :src="myAccount"></el-image>
    <div class="loginCard">
      <el-row>
        <el-col :span="9"><div class="grid-content"></div></el-col>
        <el-col :span="7">
          <el-card class="login">
            <h2>Register</h2>
            <p class="hint">Please register by creating account below.</p>
            <el-form ref="form" :model="form" :rules="rules">
              <el-form-item prop="email">
                <el-input v-model="form.email" placeholder="Email Address"></el-input>
              </el-form-item>
              <el-form-item prop="password">
                <el-input placeholder="Password" v-model="form.password" show-password></el-input>
              </el-form-item>
              <el-form-item prop="confirmPassword">
                <el-input placeholder="Confirm Password" v-model="form.confirmPassword" show-password></el-input>
              </el-form-item>
              <el-form-item>
                <el-button style="background-color: #e628a6; color: #FFFFFF; width: 100%" @click="register">
                  Sign Up
                </el-button>
              </el-form-item>
              <el-form-item>
                <span class="darkGrey">Already have an account?</span>
                <router-link to="login">
                  Go to sign in
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
    const checkEmail = (rule, value, callback) => {
      const regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (regEmail.test(value)) {
        return callback();
      }
      callback(new Error("Please enter correct email address"));
    }
    const validateRePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please confirm your password'))
      } else if (value !== this.form.password) {
        callback(new Error('Password does not match'))
      }
      callback()
    }
    return{
      myAccount: require("@/assets/myAccount.png"),
      form: {
        email: "",
        password: "",
        confirmPassword: ""
      },
      rules:{
        email:[
          { required: true, message: 'Please enter your email', trigger: 'blur' },
          { validator: checkEmail, trigger: 'blur' }
        ],
        password: [
          { required: true, message: 'Please enter your password', trigger: 'blur' },
          { min: 6, max: 16, message: '6 to 16 characters in length', trigger: 'blur' }
        ],
        confirmPassword: [
          { required: true, message: 'Please confirm your password', trigger: 'blur' },
          { min: 6, max: 16, message: '6 to 16 characters in length', trigger: 'blur' },
          { validator: validateRePassword, trigger: 'blur' }
        ]
      }
    }
  },
  created(){
    this.form.email = this.$route.query.email;
  },
  methods: {
    register(){
      this.$refs.form.validate((valid)=>{
        if(valid){
          axios.post(this.httpURL + '/user/save', this.form).then((resp)=>{
            if(resp.data === "success"){
              this.$alert('success','Message',{
                confirmButtonText:'OK',
                callback:()=>{
                  this.$router.push('/login')
                }
              })
            }else if(resp.data === "error"){
              this.$alert('Fail to register');
            }else{
              this.$alert('This email already exists')
            }
          })
        }else{
          this.$alert('Register information error','Warning');
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
</style>
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
    let checkEmail = (rule, value, callback) => {
      const regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (regEmail.test(value)) {
        return callback();
      }
      callback(new Error("Please enter correct email address"));
    };
    let validateRePassword = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please confirm your password'))
      } else if (value !== this.form.password) {
        callback(new Error('Password does not match'))
      }
      callback()
    };
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
      goSignIn: "Go to sign in",
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
  created() {
    this.form.email = this.$route.query.email;
  },
  methods: {
    register(){
      const _this=this
      this.$refs['form'].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/user/save',this.form).then(function (resp) {
            console.log(resp)
            if(resp.data == "success"){
              _this.$alert('success','Message',{
                confirmButtonText:'OK',
                callback:action => {
                  _this.$router.push('/login')
                }
              });
            }else if(resp.data == "error"){
              _this.$alert('Fail to register');
            } else {
              _this.$alert('This email already exists');
              _this.form.username='This email already exists, please renter the email address'
            }
          })
        }else{
          _this.$alert('Register information error','Warning');
        }
      });
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
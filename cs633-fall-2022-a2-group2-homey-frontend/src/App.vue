<template>
  <div id="app">
    <HomeHead></HomeHead>
    <router-view></router-view>
    <Brands></Brands>
    <PageFooter></PageFooter>
    <CopyRight></CopyRight>
  </div>
</template>

<script>
import HomeHead from "@/components/common/HomeHead";
import PageFooter from "@/components/common/PageFooter";
import CopyRight from "@/components/common/CopyRight";
import Brands from "@/components/common/Brands";
export default {
  name: 'App',
  components: {CopyRight, PageFooter, HomeHead, Brands},
  created(){
    if (sessionStorage.getItem('store')) {
      this.$store.replaceState(
          Object.assign(
              {},
              this.$store.state,
              JSON.parse(sessionStorage.getItem('store'))
          )
      )
    }
    window.addEventListener('beforeunload', ()=>{
      sessionStorage.setItem('store', JSON.stringify(this.$store.state))
    })
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>

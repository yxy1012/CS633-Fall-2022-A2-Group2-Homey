<template>
  <div id="app">
    <HomeHead></HomeHead>
    <router-view></router-view>
    <PageFooter></PageFooter>
    <CopyRight></CopyRight>
  </div>
</template>

<script>
import HomeHead from "@/components/common/HomeHead";
import PageFooter from "@/components/common/PageFooter";
import CopyRight from "@/components/common/CopyRight";
export default {
  name: 'App',
  components: {CopyRight, PageFooter, HomeHead},
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

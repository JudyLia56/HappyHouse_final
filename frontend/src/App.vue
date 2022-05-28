<template>
  <div id="app">
    <header-nav-bar></header-nav-bar>
    <router-view></router-view>
    <app-footer></app-footer>
  </div>
</template>

<script>
import HeaderNavBar from "@/components/layout/HeaderNavBar.vue";
import AppFooter from "@/components/layout/AppFooter.vue";

export default {
  name: "App",
  components: {
    HeaderNavBar,
    AppFooter,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

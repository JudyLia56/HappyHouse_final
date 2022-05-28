<template lang="">
  <b-container class="bv-example-row mt-3 text-center">
    <br /><br /><br />
    <h3 class="underline-orange">
      <b-icon icon="house-fill" font-scale="1" variant="info"></b-icon>
      아파트 매매 실거래가 조회 서비스
    </h3>
    <b-row>
      <b-col>
        <house-search-bar></house-search-bar>
      </b-col>
    </b-row>
    <house-map></house-map>

    <b-row>
      <b-col cols="6" align="left">
        <house-list />
      </b-col>
      <b-col cols="6">
        <house-detail />
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import HouseSearchBar from "@/components/house/HouseSerachBar.vue";
import HouseMap from "@/components/house/HouseMap.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseDetail from "@/components/house/HouseDetail.vue";

export default {
  name: "HouseView",
  components: {
    HouseSearchBar,
    HouseMap,
    HouseList,
    HouseDetail,
  },
};
</script>
<style scoped>
@charset "utf-8";
@import url("https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap");

h3 {
  font-family: "Gowun Batang", serif;
}
</style>

<template lang="">
  <b-container class="bv-example-row mt-3 text-center">
    <br /><br /><br />
    <h3 class="underline-orange">
      <b-icon icon="newspaper" font-scale="1" variant="info"></b-icon>
      뉴스 검색
    </h3>
    <b-row>
      <b-col>
          <news-list></news-list>
      </b-col>
    </b-row>

    <b-row>
      <b-col cols="6" align="left">
      </b-col>
      <b-col cols="6">
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import NewsList from "@/components/news/NewsList.vue";

export default {
  name: "NewsView",
  components: {
      NewsList,
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

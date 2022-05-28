<template>
  <b-row
    class="m-5"
    @click="openNews"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <!-- <b-col cols="2" class="text-center align-self-center">
      <b-img thumbnail :src="imgUrl" alt="Image 1"></b-img>
    </b-col> -->
    <b-col class="align-self-center bold-font">
      📰
      {{
        single_news.title
          .replaceAll("&", '"')
          .replaceAll("quot;", "")
          .replaceAll(/<[^>]*>?/g, "")
      }}
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: "NewsListItem",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    single_news: Object,
  },
  methods: {
    openNews() {
      window.open(`${this.single_news.link}`);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.apt {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}

.bold-font {
  font-weight: bolder;
}
</style>

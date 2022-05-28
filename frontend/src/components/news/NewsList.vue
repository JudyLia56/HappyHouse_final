<template>
  <div>
    <div>
      <b-form-input
        v-model="keyword"
        placeholder="검색어를 입력하세요"
        class="mt-3 mb-3 rounded"
        @keyup.enter="getNews"
      ></b-form-input>
      <b-button
        block
        variant="outline-primary"
        class="mt-3 mb-3"
        @click="getNews"
        >검색</b-button
      >
    </div>
    <b-container v-if="news && news.length != 0" class="bv-example-row mt-3">
      <news-list-item
        v-for="(single_news, index) in news"
        :key="index"
        :single_news="single_news"
      />
    </b-container>
    <b-container v-else class="bv-example-row mt-3">
      <b-row>
        <b-col
          ><b-alert show variant="info">뉴스 목록이 없습니다.</b-alert></b-col
        >
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";
import NewsListItem from "@/components/news/NewsListItem.vue";

const newsStore = "newsStore";

export default {
  name: "NewsList",
  components: {
    NewsListItem,
  },
  data() {
    return {
      keyword: null,
    };
  },
  computed: {
    ...mapState(newsStore, ["news"]),
  },
  methods: {
    ...mapActions(newsStore, ["getNewsList"]),
    getNews() {
      this.getNewsList(this.keyword);
    },
  },
};
</script>

<style></style>

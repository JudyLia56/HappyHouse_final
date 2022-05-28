import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import houseStore from "@/store/modules/houseStore.js";
import memberStore from "@/store/modules/memberStore.js";
import newsStore from "@/store/modules/newsStore.js";

const store = new Vuex.Store({
  modules: {
    houseStore,
    memberStore,
    newsStore,
  },
});

export default store;

<template lang="">
  <div>
    <br /><br />
    <b-row>
      <b-col>
        <b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
        ></b-form-select>
      </b-col>
      <b-col>
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="searchApt"
        ></b-form-select>
      </b-col>
    </b-row>

    <!-- <b-row class="mt-4 mb-4 text-center">
      <b-col class="sm-3">
        <b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="searchApt"
        ></b-form-select>
      </b-col>
    </b-row> -->
  </div>
</template>
<script>
import { mapState, mapActions, mapMutations } from "vuex";

const houseStore = "houseStore";
export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
    };
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "houses"]),
  },
  created() {
    console.log("debug");
    this.CLEAR_SIDO_LIST();
    this.getSido();
  },
  methods: {
    ...mapActions(houseStore, ["getSido", "getGugun", "getHouseList"]),
    ...mapMutations(houseStore, ["CLEAR_SIDO_LIST", "CLEAR_GUGUN_LIST"]),
    gugunList() {
      console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    searchApt() {
      if (this.gugunCode) this.getHouseList(this.gugunCode);
      this.$EventBus.$emit("markMarker");
    },
  },
};
</script>
<style lang=""></style>

<template>
  <b-container v-if="house" class="bv-example-row">
    <b-row>
      <b-col
        ><h3>
          <b>{{ house.아파트 }}</b>
        </h3></b-col
      >
    </b-row>
    <b-row class="mb-2 mt-1">
      <b-col
        ><b-img :src="require('@/assets/apt.png')" fluid-grow></b-img
      ></b-col>
    </b-row>

    <hr class="my-4" />
    <b-row>
      <b-col> 일련번호 : {{ house.일련번호 }} </b-col>
    </b-row>

    <hr class="my-4" />
    <b-row>
      <b-col> 아파트 이름 : {{ house.아파트 }} </b-col>
    </b-row>

    <hr class="my-4" />
    <b-row>
      <b-col> 법정동 : {{ house.법정동 }} </b-col>
    </b-row>

    <hr class="my-4" />
    <b-row>
      <b-col> 층수 : {{ house.층 }}층 </b-col>
    </b-row>

    <hr class="my-4" />
    <b-row
      @mouseover="colorChange(true)"
      @mouseout="colorChange(false)"
      :class="{ 'mouse-over-bgcolor': isColor }"
    >
      <b-col>
        거래금액:
        {{ (parseInt(house.거래금액.replace(",", "")) * 10000) | price }}원
      </b-col>
    </b-row>

    <hr class="my-4" />
  </b-container>
</template>

<script>
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseDetail",
  data() {
    return {
      isColor: false,
    };
  },
  computed: {
    ...mapState(houseStore, ["house"]),
    // house() {
    //   return this.$store.state.house;
    // },
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
  methods: {
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style>
.mouse-over-bgcolor {
  background-color: pink;
}
</style>

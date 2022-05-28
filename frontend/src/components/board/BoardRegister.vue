<template>
  <b-container class="bv-example-row mt-5">
    <br /><br />
    <h3 class="underline-orange">
      <b-icon
        icon="clipboard-check"
        font-scale="1"
        variant="info"
        class="mr-2"
      ></b-icon
      >공지사항 등록
    </h3>
    <br /><br /><br />
    <board-input-item type="register" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/item/BoardInputItem.vue";

export default {
  name: "BoardWrite",
  components: {
    BoardInputItem,
  },
};
</script>

<style></style>

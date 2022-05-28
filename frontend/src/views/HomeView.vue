<template lang="">
  <div>
    <br /><br /><br />
    <div>
      <b-carousel
        id="carousel-1"
        :interval="3000"
        controls
        indicators
        background="#ababab"
        img-width="1024"
        img-height="480"
        style="text-shadow: 1px 1px 2px #333"
      >
        <!-- Slides with img slot -->
        <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
        <b-carousel-slide
          caption="해피하우스 서비스를 이용해주셔서 감사합니다."
          text="해피하우스는 공공데이터 OPEN API를 활용하여 지역별 아파트 실거래가와 정보를 상세하게 검색할 수 있는 서비스 입니다. "
        >
          <template #img>
            <img
              class="d-block img-fluid w-100"
              width="1024"
              height="480"
              src="@/assets/carousel1.jpg"
              alt="image slot"
            />
          </template>
        </b-carousel-slide>

        <!-- Slides with img slot -->
        <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
        <b-carousel-slide
          caption="해피하우스 서비스를 이용해주셔서 감사합니다."
          text="해피하우스는 공공데이터 OPEN API를 활용하여 지역별 아파트 실거래가와 정보를 상세하게 검색할 수 있는 서비스 입니다."
        >
          <template #img>
            <img
              class="d-block img-fluid w-100"
              width="1024"
              height="480"
              src="@/assets/carousel2.jpg"
              alt="image slot"
            />
          </template>
        </b-carousel-slide>

        <!-- Slides with img slot -->
        <!-- Note the classes .d-block and .img-fluid to prevent browser default image alignment -->
        <b-carousel-slide
          caption="해피하우스 서비스를 이용해주셔서 감사합니다."
          text="해피하우스는 공공데이터 OPEN API를 활용하여 지역별 아파트 실거래가와 정보를 상세하게 검색할 수 있는 서비스 입니다."
        >
          <template #img>
            <img
              class="d-block img-fluid w-100"
              width="1024"
              height="480"
              src="@/assets/carousel3.jpg"
              alt="image slot"
            />
          </template>
        </b-carousel-slide>
      </b-carousel>
    </div>
  </div>
</template>
<script>
export default {};
</script>
<style></style>

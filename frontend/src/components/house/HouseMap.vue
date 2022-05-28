<template lang="">
  <div>
    <b-button
      block
      variant="outline-primary"
      @click="markMarker"
      class="mt-4 mb-4"
      pill
      >검색</b-button
    >
    <div id="map" class="mt-4 mb-4 rounded"></div>
  </div>
</template>
<script>
import { mapState } from "vuex";
let moveCoord = null;
const houseStore = "houseStore";
export default {
  name: "KakaoMap",
  data() {
    return {
      map: null,
      // markerPositions: [
      //   {
      //     title: "카카오",
      //     latlng: new kakao.maps.LatLng(33.450705, 126.570677),
      //   },
      // ],
      // markers: [],
    };
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
  },
  created() {
    // this.$EventBus.$on("markMarker", this.markMarker);
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      console.log("맵 초기화");
      this.initMap();
    } else {
      console.log("else블락");
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${process.env.VUE_APP_KAKAOMAP_KEY}&libraries=services`;
      //   script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=6240c46e1877b64f80eeee95c8c4fd55`;
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      console.log("실행되는가?");
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.4618904, 127.1453145),
        level: 4,
      };

      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    markMarker() {
      const tempMap = this.map;
      const geocoder = new kakao.maps.services.Geocoder();
      let flag = false;

      this.houses.forEach((house) => {
        let searchAddress = `${house.법정동} ${house.지번}`;
        geocoder.addressSearch(searchAddress, function (result, status) {
          // 정상적으로 검색이 완료됐으면
          if (status === kakao.maps.services.Status.OK) {
            // console.log("정상검색");
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            moveCoord = coords;

            // // 마커 이미지를 커스터마이징 한다.
            const imgSrc = require("@/assets/marker.png");
            const imgSize = new kakao.maps.Size(30, 46.6);
            const markerImage = new kakao.maps.MarkerImage(imgSrc, imgSize);

            // 결과값으로 받은 위치를 마커로 표시합니다
            var marker = new kakao.maps.Marker({
              position: coords,
              image: markerImage,
            });

            let infowindow = new kakao.maps.InfoWindow({
              content: `<div style="width:150px;text-align:center;padding:6px 0;"><b>${house.아파트}</b></div>`,
            });
            infowindow.open(tempMap, marker);

            marker.setMap(tempMap);
            if (!flag) {
              tempMap.setCenter(moveCoord);
              flag != flag;
            }
          }
        });
      });
    },
  },
};
</script>
<style scoped>
#map {
  width: 100%;
  height: 480px;
  margin: 0 auto;
}
</style>

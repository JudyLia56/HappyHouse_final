<template>
  <footer class="footer has-cards">
    <hr />
    <div class="row align-items-center justify-content-md-between">
      <div class="col-md-12">
        <div class="copyright">
          &copy; {{ year }}
          <a
            href="https://github.com/xxxjinjordan"
            target="_blank"
            rel="noopener"
            >Jin Sang Woo</a
          >
          &
          <a
            href="https://github.com/Sungeun12?tab=repositories"
            target="_blank"
            rel="noopener"
            >Shin Sung Eun</a
          >
        </div>
      </div>
      <div class="col-md-12">
        <br />
        <div>
          <ul class="nav nav-footer justify-content-center">
            <li class="nav-item">
              <a
                href="https://github.com"
                class="nav-link fa"
                target="_blank"
                rel="noopener"
              >
                <img src="@/assets/github.png" width="30" height="30"
              /></a>
            </li>

            <li class="nav-item">
              <a
                href="https://ssafy.com"
                class="nav-link fa"
                target="_blank"
                rel="noopener"
              >
                <img src="@/assets/ssafy.png" width="30" height="30"
              /></a>
            </li>
            <li class="nav-item">
              <a
                href="https://google.com"
                class="nav-link fa"
                target="_blank"
                rel="noopener"
              >
                <img src="@/assets/google.png" width="30" height="30"
              /></a>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </footer>
</template>
<script>
export default {
  name: "app-footer",
  data() {
    return {
      year: new Date().getFullYear(),
    };
  },
};
</script>
<style></style>

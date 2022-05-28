<template lang="">
  <div class="page">
    <header>
      <router-link to="/">
        <img
          src="@/assets/happyhouselogo.png"
          class="d-inline-block align-middle"
          alt="logo"
        />
      </router-link>
      <nav>
        <ul>
          <li>
            <router-link :to="{ name: 'house' }" class="link align-self-center"
              ><a href="#">시세 조회</a></router-link
            >
          </li>
          <li>
            <router-link :to="{ name: 'board' }" class="link align-self-center"
              ><a href="#">공지사항</a></router-link
            >
          </li>
          <li>
            <router-link :to="{ name: 'news' }" class="link align-self-center"
              ><a href="#">뉴스</a></router-link
            >
          </li>
          <li>
            <b-navbar-nav class="ml-auto" v-if="userInfo">
              <b-nav-item class="align-self-center small-font"
                ><b-avatar
                  variant="success"
                  v-text="
                    userInfo ? userInfo.userid.charAt(0).toUpperCase() : ''
                  "
                  size="sm"
                  class="mr-2"
                ></b-avatar
                ><router-link
                  :to="{ name: 'mypage' }"
                  class="link align-self-center small-font mr-2"
                  >{{ userInfo.username }}({{ userInfo.userid }})님</router-link
                >
                <b-icon
                  icon="arrow-right-square-fill"
                  aria-hidden="true"
                  variant="danger"
                  @click.prevent="onClickLogout"
                ></b-icon>
              </b-nav-item>
              <!-- <b-nav-item class="align-self-center"></b-nav-item>
              <b-nav-item
                class="link align-self-center small-font"
                @click.prevent="onClickLogout"
                >로그아웃</b-nav-item
              > -->
            </b-navbar-nav>
            <b-navbar-nav class="ml-auto" v-else>
              <b-nav-item-dropdown right>
                <template #button-content>
                  <b-icon
                    icon="people"
                    font-scale="1.5"
                    variant="dark"
                  ></b-icon>
                </template>
                <b-dropdown-item href="#"
                  ><router-link :to="{ name: 'signUp' }" class="link"
                    ><b-icon icon="person-plus" variant="primary"></b-icon>
                    회원가입</router-link
                  ></b-dropdown-item
                >
                <b-dropdown-item href="#"
                  ><router-link :to="{ name: 'signIn' }" class="link"
                    ><b-icon icon="unlock" variant="primary"></b-icon>
                    로그인</router-link
                  ></b-dropdown-item
                >
              </b-nav-item-dropdown>
            </b-navbar-nav>
          </li>
        </ul>
        <ul>
          <li></li>
        </ul>
      </nav>
    </header>
  </div>
</template>
<script>
import { mapState, mapMutations } from "vuex";
// import ms from "@/store/modules/memberStore";

const memberStore = "memberStore";
export default {
  name: "HeaderNavBar",
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClick() {
      this.$refs.dropdown.hide(true);
    },
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false);
      this.SET_USER_INFO(null);
      sessionStorage.removeItem("access-token");
      if (this.$route.path != "/") this.$router.push({ name: "home" });
    },
  },
};
</script>
<style scoped>
@charset "utf-8";
@import url("https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap");

ul {
  list-style: none;
}

a {
  text-decoration: none;
  outline: none;
  font-weight: bold;
  color: black;
  font-family: "Gowun Batang", serif;
}

.page {
  width: 1440px;
  margin: 0 auto;
}

header {
  width: 100;
  height: 10px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

header > h2 {
  margin-left: 20px;
}

header > nav {
  width: 600px;
  height: 100%;
}

header ul {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: space-between;
}

header ul > li {
  font-size: 20px;
  height: 100%;
  display: flex;
  align-items: center;
}

.small-font {
  font-size: 20px;
}
</style>

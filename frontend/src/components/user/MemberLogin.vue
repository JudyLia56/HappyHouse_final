<template>
  <b-container class="bv-example-row mt-3">
    <b-container class="bv-example-row mt-3 text-center">
      <br /><br /><br />
      <h3>
        <b-icon
          icon="person-check-fill"
          variant="info"
          class="login-banner mr-2"
        ></b-icon
        >로그인
      </h3>
      <router-view></router-view>
    </b-container>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" dismissible v-if="isLoginError"
              >아이디 또는 비밀번호를 확인하세요.</b-alert
            >
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                v-model="user.userid"
                required
                placeholder="아이디 입력"
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                type="password"
                id="userpwd"
                v-model="user.userpwd"
                required
                placeholder="비밀번호 입력"
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-row>
              <b-col class="text-right">
                <b-button
                  type="button"
                  variant="outline-primary"
                  class="border rounded"
                  @click="confirm"
                  >로그인</b-button
                >
              </b-col>
              <b-col class="ml-n3">
                <b-button
                  type="button"
                  variant="outline-success"
                  class="border rounded"
                  @click="movePage"
                  >회원가입</b-button
                >
              </b-col>
            </b-row>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberLogin",
  data() {
    return {
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    movePage() {
      this.$router.push({ name: "signUp" });
    },
  },
};
</script>

<style>
@charset "utf-8";
@import url("https://fonts.googleapis.com/css2?family=Gowun+Batang:wght@700&display=swap");

h3 {
  font-family: "Gowun Batang", serif;
}
</style>

<template>
  <b-container class="bv-example-row mt-3">
    <b-container class="bv-example-row mt-3 text-center">
      <br /><br /><br />
      <h3>
        <b-icon
          icon="pencil-square"
          variant="info"
          class="login-banner mr-2"
        ></b-icon
        >회원정보수정
      </h3>
      <!-- <router-view></router-view> -->
    </b-container>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isLoginError" dismissible
              >아이디 또는 비밀번호를 확인하세요.</b-alert
            >
            <b-form-group label="아이디:" label-for="userid">
              <b-form-input
                id="userid"
                v-model="userInfo.userid"
                placeholder="ID는 변경할 수 없습니다."
                required
                @keyup.enter="confirm"
                disabled
              ></b-form-input>
              <b-form-invalid-feedback :state="validation" v-if="tempid">
                아이디는 5글자 이상 12글자 이하여야 합니다.
              </b-form-invalid-feedback>
              <b-form-valid-feedback :state="validation">
                길이가 적절합니다. ✔
              </b-form-valid-feedback>
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
            <b-form-group label="비밀번호 재입력:" label-for="userpwdre">
              <b-form-input
                type="password"
                id="userpwdre"
                v-model="passwordre"
                required
                placeholder="비밀번호 재입력"
                @keyup.enter="confirm"
              ></b-form-input>
              <b-form-invalid-feedback
                :state="passvalidation"
                v-if="passwordre"
              >
                비밀번호가 다릅니다.
              </b-form-invalid-feedback>
              <b-form-valid-feedback :state="passvalidation">
                비밀번호가 같습니다. ✔
              </b-form-valid-feedback>
            </b-form-group>
            <b-form-group label="이름:" label-for="userpwd">
              <b-form-input
                type="username"
                id="username"
                v-model="userInfo.username"
                required
                placeholder="이름은 변경할 수 없습니다."
                @keyup.enter="confirm"
                disabled
              ></b-form-input>
            </b-form-group>
            <b-form-group label="이메일:" label-for="useremail">
              <b-form-input
                type="email"
                id="useremail"
                v-model="tempemail"
                required
                placeholder="email 입력"
                @keyup.enter="confirm"
              ></b-form-input>
              <b-form-select
                id="input-3"
                v-model="user.email"
                :options="options"
                required
                class="mt-3 mb-3"
              ></b-form-select>
            </b-form-group>
            <b-row>
              <b-col class="text-right">
                <b-button
                  type="button"
                  variant="outline-primary"
                  class="border rounded"
                  @click="update"
                  >정보수정</b-button
                >
              </b-col>
              <b-col class="ml-n3">
                <b-button
                  type="reset"
                  variant="outline-warning"
                  class="border rounded"
                  >초기화</b-button
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
  name: "MemberUpdate",
  data() {
    return {
      user: {
        userid: null,
        userpwd: null,
        username: null,
        email: null,
        // joindate: null,
      },
      options: [
        { text: "이메일을 선택하세요", value: null },
        { text: "네이버", value: "@naver.com" },
        { text: "구글", value: "@gmail.com" },
        { text: "다음", value: "@hanmail.com" },
        { text: "싸피", value: "@ssafy.com" },
      ],
      tempid: "",
      passwordre: "",
      tempemail: "",
    };
  },
  computed: {
    ...mapState(memberStore, [
      "isLogin",
      "isLoginError",
      "isRegisterError",
      "userInfo",
    ]),
    validation() {
      return this.tempid.length > 4 && this.tempid.length < 13;
    },
    passvalidation() {
      return this.user.userpwd === this.passwordre;
    },
  },
  methods: {
    ...mapActions(memberStore, ["updateUser"]),
    ...mapState(memberStore, ["userInfo"]),
    update() {
      this.user.userid = this.userInfo.userid;
      this.user.username = this.userInfo.username;
      this.user.email = this.tempemail + this.user.email;
      // this.user.joindate = new Date();
      console.log(this.user);
      this.updateUser(this.user);
      console.log(this.user);
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

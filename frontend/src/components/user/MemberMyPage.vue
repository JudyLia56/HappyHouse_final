<template>
  <b-container class="mt-4" v-if="userInfo">
    <b-container class="bv-example-row mt-3 text-center">
      <br /><br /><br />
      <h3>
        <b-icon
          icon="
person-lines-fill"
          variant="info"
          class="login-banner mr-2"
        ></b-icon
        >마이페이지
      </h3>
      <router-view></router-view>
    </b-container>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <br /><br />
        <b-jumbotron>
          <!-- <template #header>My Page</template>

          <template #lead> 내 정보 확인페이지입니다. </template> -->

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.userid }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start">{{
                userInfo.username
              }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이메일</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.email }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">가입일</b-col
              ><b-col cols="4" align-self="start">{{
                userInfo.joindate
              }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-button v-b-modal.modal-center2 variant="outline-info" class="mr-2"
            >팔로잉</b-button
          >
          <b-modal id="modal-center2" centered title="팔로잉 목록" hide-footer>
            <b-row v-for="follower in following" :key="follower.id">
              <b-col sm="8"
                >🎈 <b>{{ follower.userid }}</b
                >({{ follower.username.charAt(0) + "**" }})</b-col
              >
              <b-col sm="4"
                ><input
                  type="submit"
                  value="팔로우 끊기"
                  @click="unfollowUser(follower)"
                  class="btn_submit float-right"
              /></b-col>
            </b-row>
          </b-modal>

          <b-button
            v-b-modal.modal-center1
            variant="outline-info"
            class="ml-2 mr-2"
            >팔로워</b-button
          >
          <b-modal id="modal-center1" centered title="팔로워 목록" hide-footer>
            <b-row v-for="follower in followers" :key="follower.id">
              <b-col sm="8"
                >🎈 <b>{{ follower.userid }}</b
                >({{ follower.username.charAt(0) + "**" }})</b-col
              >
              <!-- <b-col sm="4"
                ><input
                  type="submit"
                  value="팔로우 끊기"
                  @click="unfollowUser(follower)"
                  class="btn_submit float-right"
              /></b-col> -->
            </b-row>
          </b-modal>

          <b-button
            v-b-modal.modal-prevent-closing
            variant="outline-info"
            class="ml-2"
            >유저 목록</b-button
          >
          <b-modal
            id="modal-prevent-closing"
            centered
            title="유저 목록"
            hide-footer
          >
            <b-row v-for="user in users" :key="user.id">
              <b-col sm="8"
                >🎈 <b>{{ user.userid }}</b
                >({{ user.username.charAt(0) + "**" }})</b-col
              >
              <b-col sm="4"
                ><input
                  type="submit"
                  value="팔로우"
                  @click="followUser(user)"
                  class="btn_submit float-right"
              /></b-col>
            </b-row>
          </b-modal>

          <hr class="my-4" />

          <b-button
            variant="outline-primary"
            href="#"
            class="mr-2"
            @click="movePage"
            >정보수정</b-button
          >
          <b-button
            variant="outline-danger"
            href="#"
            class="ml-2"
            @click="confirmDelete"
            >회원탈퇴</b-button
          >
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row>
    <!-- <button @click="debug"></button> -->
  </b-container>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import {
  listFollowers,
  listFollowing,
  deleteFollower,
  addFollower,
} from "@/api/follower";
import { listUser } from "@/api/member";

const memberStore = "memberStore";

export default {
  name: "MemberMyPage",
  data() {
    return {
      users: [],
      followers: [],
      following: [],
      visible: false,
      unfollow: {
        from_userid: null,
        to_userid: null,
      },
      follow: {
        from_userid: null,
        to_userid: null,
      },
      unfollow_userid: "",
    };
  },
  components: {},
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  created() {
    listFollowers(
      this.userInfo.userid,
      (response) => {
        response.data.followList.forEach((element) => {
          this.followers.push(element);
        });
      },
      () => {}
    );
    listFollowing(
      this.userInfo.userid,
      (response) => {
        response.data.followList.forEach((element) => {
          this.following.push(element);
        });
      },
      () => {}
    );
    listUser(
      (response) => {
        this.users = response.data;
      },
      () => {}
    );
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    ...mapActions(memberStore, ["deleteUser"]),
    confirmDelete() {
      if (confirm("정말로 탈퇴하시겠습니까?")) {
        this.deleteUser(this.userInfo);
        this.SET_IS_LOGIN(false);
        this.SET_USER_INFO(null);
        sessionStorage.removeItem("access-token");
        if (this.$route.path != "/") this.$router.push({ name: "home" });
      }
    },
    movePage() {
      this.$router.push({ name: "update" });
    },
    debug() {
      console.log(this.following);
    },
    handleClickButton() {
      this.visible = !this.visible;
    },
    unfollowUser(value) {
      this.unfollow.from_userid = this.userInfo.userid;
      this.unfollow.to_userid = value.userid;
      deleteFollower(
        this.unfollow,
        () => {
          alert("팔로우를 해제했습니다.");
          this.$router.push({ name: "home" });
        },
        () => {
          alert("팔로우 해제를 할 수 없습니다!");
        }
      );
    },

    followUser(value) {
      let isFollowed = false;
      let isMe = false;
      if (value.userid === this.userInfo.userid) {
        alert("자신은 팔로우 할 수 없습니다.");
        isMe = true;
      }

      if (isMe) return;
      this.following.forEach((element) => {
        if (element.userid === value.userid) {
          alert("이미 팔로우한 회원입니다.");
          isFollowed = true;
        }
      });
      if (isFollowed) return;
      this.follow.from_userid = this.userInfo.userid;
      this.follow.to_userid = value.userid;
      addFollower(
        this.follow,
        (response) => {
          if (response.result === 2) {
            alert("이미 팔로우한 회원입니다.");
            return;
          }
          alert("팔로우 했습니다.");
          this.$router.push({ name: "home" });
        },
        () => {
          alert("팔로우 할 수 없습니다!");
        }
      );
    },
  },
};
</script>

<style scoped>
li.none {
  list-style-type: none;
}
</style>

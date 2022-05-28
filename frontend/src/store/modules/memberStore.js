import jwt_decode from "jwt-decode";
import { login, register, deleteMember, update } from "@/api/member.js";
import { findById } from "../../api/member";
import router from "@/router/index.js";
// import { register } from "@/api/member.js";

const memberStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    isRegisterError: false,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    SET_REGISTER_ERROR: (state, isRegisterError) => {
      state.isRegisterError = isRegisterError;
      console.log("뮤테이션 되긴됨");
    },
  },
  actions: {
    async userConfirm({ commit }, user) {
      await login(
        user,
        (response) => {
          if (response.data.message === "success") {
            let token = response.data["access-token"];
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem("access-token", token);
          } else {
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
          }
        },
        () => {}
      );
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      findById(
        decode_token.userid,
        (response) => {
          if (response.data.message === "success") {
            commit("SET_USER_INFO", response.data.userInfo);
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    registerUser({ commit }, user) {
      register(
        user,
        (response) => {
          // if (response.data.message === "success") {
          //   commit("SET_REGISTER_ERROR", false);
          // } else {
          //   commit("SET_REGISTER_ERROR", true);
          //   console.log("등록 실패");
          //   console.log(response);
          // }
          if (response.data === "success") {
            alert("회원가입에 성공하였습니다!");
            router.push({ name: "signIn" });
          } else {
            alert("회원가입에 실패하였습니다!");
            router.push({ name: "signUp" });
          }
          commit("SET_REGISTER_ERROR", false);
          console.log("등록 성공");
        },
        () => {
          commit("SET_REGISTER_ERROR", true);
          console.log("등록 실패");
        }
      );
    },
    deleteUser({ commit }, userInfo) {
      deleteMember(
        userInfo,
        (response) => {
          if (response.data === "success") {
            alert("성공적으로 탈퇴되었습니다.");
            router.push({ name: "home" });
            console.log("삭제 성공");
          } else {
            alert("회원 탈퇴에 실패했습니다.");
            router.push({ name: "mypage" });
            console.log("삭제 실패");
          }
          commit("");
        },
        () => {
          console.log("삭제 실패");
        }
      );
    },
    updateUser({ commit }, user) {
      update(
        user,
        (response) => {
          if (response.data === "success") {
            alert("정보 수정에 성공하였습니다!");
            router.push({ name: "home" });
            console.log("수정 성공");
          } else {
            alert("정보 수정에 실패하였습니다!");
            router.push({ name: "update" });
            console.log("수정 실패");
          }
          commit("");
        },
        () => {
          console.log("수정 실패");
        }
      );
    },
  },
};

export default memberStore;

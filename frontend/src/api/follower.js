import { apiInstance } from "./index.js";

const api = apiInstance();

function listFollowing(userid, success, fail) {
  api.get(`/friend/following/${userid}`).then(success).catch(fail);
}

function listFollowers(userid, success, fail) {
  api.get(`/friend/follower/${userid}`).then(success).catch(fail);
}

function deleteFollower(unfollow, success, fail) {
  api
    .delete(`friend/`, { data: JSON.stringify(unfollow) })
    .then(success)
    .catch(fail);
}

function addFollower(follow, success, fail) {
  api.post(`friend/`, JSON.stringify(follow)).then(success).catch(fail);
}

// function addFollower(userid, success, fail) {
//   api.post(`/friend/regist`, userid).then(success).catch(fail);
// }

// function writeArticle(article, success, fail) {
//   console.log(article);
//   api
//     .post(`/noticeboard/regist`, JSON.stringify(article))
//     .then(success)
//     .catch(fail);
// }

// function getArticle(articleno, success, fail) {
//   api.get(`/noticeboard/detail/${articleno}`).then(success).catch(fail);
// }

// function modifyArticle(article, success, fail) {
//   api
//     .put(`/noticeboard/update/${article.no}`, JSON.stringify(article))
//     .then(success)
//     .catch(fail);
// }

// function deleteArticle(no, success, fail) {
//   api.delete(`/noticeboard/delete/${no}`).then(success).catch(fail);
// }

// function viewArticle(articleno, success, fail) {
//   api.put(`/noticeboard/countViews/${articleno}`).then(success).catch(fail);
// }

export { listFollowers, deleteFollower, listFollowing, addFollower };

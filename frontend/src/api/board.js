import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(success, fail) {
  api.get(`/noticeboard/list`).then(success).catch(fail);
}

function writeArticle(article, success, fail) {
  console.log(article);
  api
    .post(`/noticeboard/regist`, JSON.stringify(article))
    .then(success)
    .catch(fail);
}

function getArticle(articleno, success, fail) {
  api.get(`/noticeboard/detail/${articleno}`).then(success).catch(fail);
}

function modifyArticle(article, success, fail) {
  api
    .put(`/noticeboard/update/${article.no}`, JSON.stringify(article))
    .then(success)
    .catch(fail);
}

function deleteArticle(no, success, fail) {
  api.delete(`/noticeboard/delete/${no}`).then(success).catch(fail);
}

function viewArticle(articleno, success, fail) {
  api.put(`/noticeboard/countViews/${articleno}`).then(success).catch(fail);
}

export {
  listArticle,
  writeArticle,
  getArticle,
  modifyArticle,
  deleteArticle,
  viewArticle,
};

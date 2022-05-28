import { apiInstance } from "./index.js";

const api = apiInstance();

function newsList(params, success, fail) {
  api.get(`/news/list/${params}`).then(success).catch(fail);
}

export { newsList };

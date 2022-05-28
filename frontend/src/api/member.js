import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

function register(user, success, fail) {
  console.log("JSON나간다", JSON.stringify(user));
  api.post(`/user/register`, JSON.stringify(user)).then(success).catch(fail);
}

function deleteMember(user, success, fail) {
  api
    .delete(`/user/delete`, { data: JSON.stringify(user) })
    .then(success)
    .catch(fail);
}

function update(user, success, fail) {
  api.put(`/user/update`, JSON.stringify(user)).then(success).catch(fail);
}

function listUser(success, fail) {
  api.get(`/user/list`).then(success).catch(fail);
}

// function logout(success, fail)

export { login, findById, register, deleteMember, update, listUser };

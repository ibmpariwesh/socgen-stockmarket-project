import { createStore } from "redux";
const obj = {
  jwtToken: "",
  haveToken: false,
  cachedComp: {},
};
const reducerfn = (state = obj, action) => {
  if (action.type === "UPDATE_TOKEN") {
    return {
      ...state,
      haveToken: !state.haveToken,
      jwtToken: action.jwtToken,
    };
  }
  if (action.type === "FORGET_LOGIN") {
    return {
      ...state,
      haveToken: !state.haveToken,
      jwtToken: "",
    };
  }
  if (action.type === "EDIT_COMPANY") {
    return {
      ...state,
      cachedComp: action.cacheComp,
    };
  }
  return state;
};
const store = createStore(reducerfn);

export default store;

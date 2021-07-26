import React, { useState } from "react";
import UserLanding from "../userPage/UserLanding";
import "./LoginPage.css";
import { AwesomeButton } from "react-awesome-button";
import "react-awesome-button/dist/styles.css";
import { useDispatch, useSelector } from "react-redux";
import axios from "axios";
import jwt_decode from "jwt-decode";
import AdminLanding from "../AdminPage/AdminLanding";

function LoginPage() {
  //   const [creds, setCreds] = useState({});
  const glob_state = useSelector((state) => state);
  const hav_tok = glob_state.haveToken;
  const [badCreds, setBadCreds] = useState(false);
  const [creds, setCreds] = useState();
  const [showUserLanding, setShowUserLanding] = useState(false);
  const [showAdminLanding, setShowAdminLanding] = useState(false);
  const dispatch = useDispatch();

  const badCredAlert = <h6 className="inv-pos">Invalid Credentials</h6>;
  const onUserNameChange = (e) => {
    setCreds((prevState) => {
      return {
        ...prevState,
        username: e.target.value,
      };
    });
  };

  const onPasswordChange = (e) => {
    setCreds((prevState) => {
      return {
        ...prevState,
        password: e.target.value,
      };
    });
  };

  const onSubmit = () => {
    axios
      .post("http://localhost:9999/jwt-request", creds)
      .then((resp) => {
        var result = resp.data;

        console.log(jwt_decode(result));
        dispatch({
          type: "UPDATE_TOKEN",
          jwtToken: result,
        });
        setBadCreds(false);
        if (jwt_decode(result).sub === "user") {
          setShowUserLanding(true);
        }
        if (jwt_decode(result).sub === "admin") {
          setShowAdminLanding(true);
        }
      })
      .catch((error) => {
        console.log(creds);
        if (error.response) {
          setBadCreds(true);
          console.log("1");
        } else if (error.request) {
          console.log("2");
          console.log(error.request);
        } else {
          console.log("3");
          console.log("Error", error.message);
        }
        console.log("4");
      });
  };
  const loginPage = (
    <div className="blurred-box">
      <div className="user-login-box">
        {/* <span className="user-icon"></span> */}
        <h2 className="login-head">Login</h2>
        <label className="lbl-white">Username</label>
        <input
          className="user-password"
          onChange={onUserNameChange}
          type="text"
        />
        <label className="lbl-white">password</label>
        <input
          className="user-password1"
          onChange={onPasswordChange}
          type="password"
        />
        {badCreds && badCredAlert}
        <AwesomeButton
          type="primary green"
          className="login-button"
          onPress={onSubmit}
        >
          Login
        </AwesomeButton>
      </div>
    </div>
  );
  if (hav_tok && showUserLanding) {
    console.log("user landing");
    return <UserLanding />;
  }
  if (hav_tok && showAdminLanding) {
    console.log("admin landing");
    return <AdminLanding />;
  }

  return loginPage;
}

export default LoginPage;

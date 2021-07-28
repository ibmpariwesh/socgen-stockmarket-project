import axios from "axios";
import React, { useState } from "react";
import AwesomeButton from "react-awesome-button";
import "react-awesome-button/dist/styles.css";
import { useDispatch, useSelector } from "react-redux";
import { Link } from "react-router-dom";

import "./SignUp.css";
function SignUp() {
  const [details, setDetails] = useState();
  const dispatch = useDispatch();
  const Token = useSelector((state) => state.jwtToken);
  const head = {
    headers: {
      authorization: "Bearer " + Token,
    },
  };
  const userHandler = (e) => {
    setDetails({
      ...details,
      userName: e.target.value,
    });
  };
  const emailHandler = (e) => {
    setDetails({
      ...details,
      email: e.target.value,
    });
  };
  const passHandler = (e) => {
    setDetails({
      ...details,
      password: e.target.value,
    });
  };
  const numberHandler = (e) => {
    setDetails({
      ...details,
      mobileNumber: e.target.value,
    });
  };
  const signupHandler = () => {
    console.log(details);
    // setDetails({ role: "ROLE_ADMIN", ...details });
    const finDetails = {
      ...details,
      role: "ROLE_ADMIN",
    };
    axios.post("http://localhost:9999/post_cred", finDetails, head).then(() => {
      console.log(finDetails);
    });
  };

  return (
    <div>
      <h3 className="hd">Sign Up</h3>
      <label className="lbl-pos">Set Username</label>
      <br />
      <input type="text" className="form-control ipt" onChange={userHandler} />
      <label className="lbl-pos">Set Password</label>
      <br />
      <input
        type="password"
        className="form-control ipt"
        onChange={passHandler}
      />
      <label className="lbl-pos">Your Email</label>
      <br />
      <input type="text" className="form-control ipt" onChange={emailHandler} />
      <label className="lbl-pos">Mobile Number</label>
      <br />
      <input
        type="text"
        className="form-control ipt"
        onChange={numberHandler}
      />
      <Link to="/login">
        <button className="btn btn-primary btn-pos" onClick={signupHandler}>
          SignUp
        </button>
      </Link>
    </div>
  );
}

export default SignUp;

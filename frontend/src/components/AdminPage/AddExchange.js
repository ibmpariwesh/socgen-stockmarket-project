import axios from "axios";
import React, { useState } from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import { useHistory } from "react-router-dom";

import "./AddExchange.css";
function AddExchange() {
  const [xDetails, setxDetails] = useState();
  const [locDetails, setLocDetails] = useState();
  const Token = useSelector((state) => state.jwtToken);
  let history = useHistory();
  const head = {
    headers: {
      authorization: "Bearer " + Token,
    },
  };
  const obj = {
    name: "",
    brief: "",
    remarks: "",
  };
  const loc = {
    street: "",
    city: "",
    country: "",
    zip: "",
  };
  const nameChangeHandler = (e) => {
    setxDetails({ ...xDetails, name: e.target.value });
  };
  const briefChangeHandler = (e) => {
    setxDetails({ ...xDetails, brief: e.target.value });
  };
  const remarksChangeHandler = (e) => {
    setxDetails({ ...xDetails, remarks: e.target.value });
  };
  const streetChangeHandler = (e) => {
    setLocDetails({ ...locDetails, street: e.target.value });
  };
  const cityChangeHandler = (e) => {
    setLocDetails({ ...locDetails, city: e.target.value });
  };
  const countryChangeHandler = (e) => {
    setLocDetails({ ...locDetails, country: e.target.value });
  };
  const zipChangeHandler = (e) => {
    setLocDetails({ ...locDetails, zip: e.target.value });
  };
  // console.log(xDetails);
  // console.log(locDetails);
  const submitHandler = () => {
    setxDetails({
      ...obj,
      xDetails,
    });
    setLocDetails({
      ...loc,
      ...locDetails,
    });
    setxDetails({ ...xDetails, address: locDetails });
    axios
      .post("http://localhost:9999/stock_exchange/add_exchange", xDetails, head)
      .then(() => {
        history.push("/manage_exchange");
      });
  };
  return (
    <div className="form-border">
      <div className="form-group">
        <label className="label-white">Stock Exchange Name</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={nameChangeHandler}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Brief</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={briefChangeHandler}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Remarks</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={remarksChangeHandler}
        />
      </div>
      <br />
      <h3 className="form-hlabel">Address</h3>
      <br />
      <br />
      <div className="form-group">
        <label className="label-white">Street</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={streetChangeHandler}
        />
      </div>
      <div className="form-group">
        <label className="label-white">City</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={cityChangeHandler}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Country</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={countryChangeHandler}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Zip Code</label>
        <br />
        <input
          type="text"
          className="form-control box-editx1"
          onChange={zipChangeHandler}
        />
      </div>
      <br />
      <Link to="/manage_exchange">
        <button className="btn btn-success btn-s" onClick={submitHandler}>
          Submit
        </button>
      </Link>
    </div>
  );
}

export default AddExchange;

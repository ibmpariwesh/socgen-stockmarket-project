import axios from "axios";
import React, { useState, useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";

import "./EditCompany.css";
function EditCompany() {
  const [company, setCompany] = useState();
  const comp = useSelector((state) => state.cachedComp);
  useEffect(() => {
    setCompany(comp);
  }, []);
  // console.log(props.comp);

  const Token = useSelector((state) => state.jwtToken);
  // console.log(company);
  const nameHandler = (e) => {
    if (e.target.value === "") {
      setCompany({
        name: comp.name,
        ...company,
      });
    } else {
      setCompany({
        ...company,
        name: e.target.value,
      });
    }
  };
  const ceoHandler = (e) => {
    if (e.target.value === "") {
      setCompany({
        ceo: comp.ceo,
        ...company,
      });
    } else {
      setCompany({
        ...company,
        ceo: e.target.value,
      });
    }
  };
  const descriptionHandler = (e) => {
    if (e.target.value === "") {
      setCompany({
        description: comp.description,
        ...company,
      });
    } else {
      setCompany({
        ...company,
        description: e.target.value,
      });
    }
  };
  const stockCodeHandler = (e) => {
    if (e.target.value === "") {
      setCompany({
        stockCode: comp.stockCode,
        ...company,
      });
    } else {
      setCompany({
        ...company,
        stockCode: e.target.value,
      });
    }
  };
  const imageLinkHandler = (e) => {
    if (e.target.value === "") {
      setCompany({
        ...company,
        imageLink: comp.imageLink,
      });
    } else {
      setCompany({
        ...company,
        imageLink: e.target.value,
      });
    }
  };
  const submitHandler = (e) => {
    e.preventDefault();
    delete company["fetchedSE"];
    console.log(company);
    axios.post("http://localhost:9999/company/update_company", company, {
      headers: {
        Authorization: "Bearer " + Token,
      },
    });
    // props.refresh();
  };
  // return (
  //   <div className="edit-box">
  //     <h1>EDIT HERE</h1>
  //   </div>
  // );
  return (
    <div className="edit-box">
      <form>
        <div className="form-group">
          <label className="label-white">Company Name</label>
          <input
            type="text"
            className="form-control"
            onChange={nameHandler}
            aria-describedby="emailHelp"
            placeholder={comp.name}
          />
        </div>
        <div className="form-group">
          <label className="label-white">CEO</label>

          <input
            type="text"
            onChange={ceoHandler}
            className="form-control"
            placeholder={comp.ceo}
          />
        </div>
        <div className="form-group">
          <label className="label-white">Description</label>
          <input
            type="text"
            onChange={descriptionHandler}
            className="form-control"
            placeholder={comp.description}
          />
        </div>
        <div className="form-group">
          <label className="label-white">Stock code</label>
          <input
            type="text"
            onChange={stockCodeHandler}
            className="form-control"
            placeholder={comp.stockCode}
          />
        </div>
        <div className="form-group">
          <label className="label-white">Image Link</label>
          <input
            onChange={imageLinkHandler}
            type="text"
            className="form-control"
            placeholder={comp.imageLink}
          />
        </div>
        <small className="label-white">
          * empty field's details will not be updated{" "}
        </small>
        <button className="btn btn-primary btn-sbt" onClick={submitHandler}>
          Submit
        </button>
      </form>
    </div>
  );
}

export default EditCompany;

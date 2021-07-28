import React, { useEffect, useState } from "react";
import { Route, Link } from "react-router-dom";
import Select from "react-select";
// import "./ManageCompany.css";
import "./AddCompany.css";
import axios from "axios";
import { useSelector } from "react-redux";
function AddCompany() {
  const Token = useSelector((state) => state.jwtToken);
  const [xList, setxList] = useState();
  const [selList, setSelList] = useState();
  useEffect(() => {
    axios
      .get("http://localhost:9999/stock_exchange/get_all", {
        headers: {
          authorization: "Bearer " + Token,
        },
      })
      .then((res) => {
        console.log(res.data);
        setxList(res.data);
      });
  }, []);
  const head = {
    headers: {
      authorization: "Bearer " + Token,
    },
  };
  const obj = {
    name: "",
    ceo: "",
    description: "",
    stockCode: "",
    imageLink:
      "http://maxenterprises.lk/wp-content/uploads/2019/06/no_photo_found.png",
  };
  console.log(selList);
  const options = [];
  const [companyDetails, setCompanyDetails] = useState();
  console.log(companyDetails);
  const onNameChange = (e) => {
    setCompanyDetails({
      ...companyDetails,
      name: e.target.value,
    });
  };

  const onCEOchange = (e) => {
    setCompanyDetails({
      ...companyDetails,
      ceo: e.target.value,
    });
  };

  const onDescriptionChange = (e) => {
    setCompanyDetails({
      ...companyDetails,
      description: e.target.value,
    });
  };
  const onStockCodeChange = (e) => {
    setCompanyDetails({
      ...companyDetails,
      stockCode: e.target.value,
    });
  };
  const onImageLinkChange = (e) => {
    setCompanyDetails({
      ...companyDetails,
      imageLink: e.target.value,
    });
  };
  if (xList != null) {
    const ls = xList.forEach((elem) => {
      options.push({
        value: elem.id,
        label: elem.name,
      });
    });
  }
  const seChangeHandler = (e) => {
    setSelList({
      xArr: e.map((elem) => {
        return elem.value;
      }),
    });
  };
  const submitHandler = () => {
    setCompanyDetails({ ...obj, ...companyDetails });
    axios
      .post("http://localhost:9999/company/add_company", companyDetails, head)
      .then(() => {
        let cid = axios.get(
          "http://localhost:9999/company/getIdByName/" + companyDetails["name"],
          head
        );
        cid.then((resp) => {
          if (selList === undefined) return;
          for (let id in selList["xArr"]) {
            axios.post(
              "http://localhost:9999/er_maps/add_company_exchange",
              {
                companyId: resp.data,
                stockId: selList["xArr"][id],
              },
              head
            );
          }
        });
      });
    // console.log(companyDetails["name"]);
  };
  return (
    <div className="form-border">
      <div className="form-group">
        <label className="label-white">Company Name</label>
        <br />
        <input
          type="text"
          className="form-control box-editx"
          onChange={onNameChange}
        />
      </div>

      <div className="form-group">
        <label className="label-white">CEO</label>
        <br />
        <input
          type="text"
          className="form-control box-editx"
          onChange={onCEOchange}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Description</label>
        <br />
        <input
          type="text"
          className="form-control box-editx"
          onChange={onDescriptionChange}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Stock code</label>
        <br />
        <input
          type="text"
          className="form-control box-editx"
          onChange={onStockCodeChange}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Image Link</label>
        <br />
        <input
          type="text"
          className="form-control box-editx"
          onChange={onImageLinkChange}
        />
      </div>
      <div className="form-group">
        <label className="label-white">Stock Exchanges</label>
        <br />
      </div>
      <Select
        onChange={seChangeHandler}
        isMulti
        multiple
        options={options}
        className="select-p"
      />
      <Link to="/manage_company">
        <button className="btn btn-primary s-btn" onClick={submitHandler}>
          Submit
        </button>
      </Link>
    </div>
  );
}

export default AddCompany;

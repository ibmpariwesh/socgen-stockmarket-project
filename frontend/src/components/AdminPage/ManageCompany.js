import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector, useDispatch } from "react-redux";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

import { Button } from "react-bootstrap";
import "./ManageCompany.css";
import EditCompany from "./EditCompany";

function ManageCompany(props) {
  const Token = useSelector((state) => state.jwtToken);
  const [compList, setCompList] = useState(null);
  const [showCompany, setShowCompany] = useState(false);
  const [showEdit, setShowEdit] = useState(false);
  const [company, setCompany] = useState();
  const dispatch = useDispatch();
  useEffect(() => {
    axios
      .get("http://localhost:9999/company/get_companies/", {
        headers: {
          authorization: "Bearer " + Token,
        },
      })
      .then((resp) => {
        console.log(resp.data);
        setCompList(resp.data);
        setShowCompany(true);
      });
  }, [showCompany]);

  const editStyle = {
    // display: "inline",
    position: "absolute",
    float: "left",
    textDecoration: "none",
    marginLeft: "300px",
    marginRight: "100px",
    marginTop: "-70px",
  };
  if (showCompany) {
    var newList = compList.map((item, index) => {
      return (
        <div className="comp-hold" key={index}>
          <div className="image-cropper">
            <img src={item.imageLink} className="rounded c-img" />
          </div>
          <h3 className="company-text">{item.name}</h3>
          <h5 className="company-text2">{item.fetchedSE}</h5>
          {/* <Button
            variant="primary"
            className="btn-edit"
            onClick={() => {
              editHandler(item);
            }}
          >
            Edit
          </Button> */}
          <Link
            to="/company/edit"
            style={editStyle}
            onClick={() => {
              dispatch({
                type: "EDIT_COMPANY",
                cacheComp: item,
              });
            }}
          >
            edit
          </Link>
          <Button variant="danger" className="btn-delete">
            Delete
          </Button>
        </div>
      );
    });
  }
  return <div className="list-hold">{compList !== null && newList}</div>;
}

export default ManageCompany;

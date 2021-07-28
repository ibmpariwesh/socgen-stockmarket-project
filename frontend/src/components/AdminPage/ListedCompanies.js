import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import "./ListedCompany.css";
function ListedCompanies(props) {
  const [cList, setCList] = useState();
  const Token = useSelector((state) => state.jwtToken);
  const head = {
    headers: {
      authorization: "Bearer " + Token,
    },
  };
  //   console.log(props.location.query);
  useEffect(() => {
    axios
      .get(
        "http://localhost:9999/api/getCompForEx/" + props.location.query.id,
        head
      )
      .then((resp) => {
        // console.log(resp.data);
        setCList(resp.data);
      });
  }, []);
  if (cList !== undefined) {
    var newList = cList.map((item, index) => {
      return (
        <div className="comp-hold1" key={index}>
          <div className="image-cropper">
            <img src={item.imageLink} className="rounded c-img" />
          </div>
          <h3 className="company-text">{item.name}</h3>
          <h5 className="company-text2">{item.ceo}</h5>
          {/* <h5 className="company-texta3x">{item.}</h5> */}
        </div>
      );
    });
  }
  return (
    <div>
      <h2 className="hdng-1">
        Companies Listed in {" " + props.location.query.name}
      </h2>
      {newList}
    </div>
  );
}

export default ListedCompanies;

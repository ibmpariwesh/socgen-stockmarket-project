import React, { useState } from "react";
import { Navbar, Container, Nav } from "react-bootstrap";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import ManageCompany from "./ManageCompany";
import EditCompany from "./EditCompany";
import "./ManageCompany.css";

function AdminLanding() {
  const [showCompany, setShowCompany] = useState(true);
  const dispatch = useDispatch();
  const onLogout = () => {
    dispatch({
      type: "FORGET_LOGIN",
    });
  };
  const toggleShow = () => {
    setShowCompany(!showCompany);
  };
  return (
    <Router>
      <div>
        <Navbar
          className="nvbr"
          collapseOnSelect
          expand="lg"
          bg="dark"
          variant="dark"
          fixed="top"
        >
          <Container>
            <Navbar.Brand href="#home">Stock Market App</Navbar.Brand>
            <Navbar.Toggle aria-controls="responsive-navbar-nav" />
            <Navbar.Collapse id="responsive-navbar-nav">
              <Nav className="me-auto">
                {/* <Nav.Link onClick={toggleShow}>Manage Company</Nav.Link> */}
                <Link
                  style={{ textDecoration: "none", color: "white", margin: 10 }}
                  to="/manage_company"
                >
                  ManageCompany
                </Link>
                <Nav.Link>Manage Exchange</Nav.Link>

                <Nav.Link>Update IPO</Nav.Link>

                <Nav.Link>Import Data</Nav.Link>
              </Nav>
              <Nav>
                <button
                  className="button glass red-a"
                  type="button"
                  onClick={onLogout}
                >
                  LogOut
                </button>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>

        <Route path="/manage_company" component={ManageCompany} exact />

        <Route path="/company/edit" component={EditCompany} exact />
      </div>
    </Router>
  );
}

export default AdminLanding;

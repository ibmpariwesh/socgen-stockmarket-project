import React from "react";
import { Navbar, Container, Nav } from "react-bootstrap";
import { useDispatch } from "react-redux";
import "bootstrap/dist/css/bootstrap.min.css";
import "./UserLanding.css";
// import AwesomeButton from "react-awesome-button";
// import "react-awesome-button/dist/styles.css";
function UserLanding() {
  const dispatch = useDispatch();
  const onLogout = () => {
    dispatch({
      type: "FORGET_LOGIN",
    });
  };
  return (
    <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
      <Container>
        <Navbar.Brand href="#home">Stock Market App</Navbar.Brand>
        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
        <Navbar.Collapse id="responsive-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="#ipos">IPOs</Nav.Link>
            <Nav.Link href="#company">Compare Company</Nav.Link>
            <Nav.Link href="#sectors">Compare Sectors</Nav.Link>
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
  );
}

export default UserLanding;

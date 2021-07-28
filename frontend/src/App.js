import "./App.css";
import LoginPage from "./components/Login/LoginPage";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import SignUp from "./components/Login/SignUp";

function App() {
  return (
    <Router>
      <div className="App">
        <Route path="/" component={LoginPage} exact />
        <Route path="/signup" component={SignUp} exact />
      </div>
    </Router>
  );
}

export default App;

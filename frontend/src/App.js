import "./App.css";
import LoginPage from "./components/Login/LoginPage";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";

function App() {
  return (
    <div className="App">
      <Route path="/" component={LoginPage} exact />
    </div>
  );
}

export default App;

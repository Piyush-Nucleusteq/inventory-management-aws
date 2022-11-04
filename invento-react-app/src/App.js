//import Login from './Component/Login/Login';
//import Sidebar from './Component/AdminDashboard/Sidebar/Sidebar';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Registration from "./Component/Registration/Registration";
import Login from "./Component/Login/Login";
import Home from "./Pages/Home";
import AssignNewItem from "./Pages/AssignNewItem";
import EmployeeDashboard from "./Component/EmployeeDashboard/EmployeeDashboard";
import ResetPassword from "./Component/ResetPassword/ResetPassword";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/registration" element={<Registration />} />
        <Route path="/" element={<Login />} />
        <Route path="/reset" element={<ResetPassword />} />
        <Route path="/dashboard" element={<Home />} />
        <Route path="/employee" element={<Home />} />
        <Route path="/item" element={<Home />} />
        <Route path="/assignItem" element={<Home />} />
        <Route path="/modal" element={<modal />} />
        <Route path="/employeeDashboard" element={<EmployeeDashboard />} />
        <Route
          path="/assignNewItem/:employeeId/:employeeTableId"
          element={<AssignNewItem />}
        />
      </Routes>
    </Router>
  );
}

export default App;

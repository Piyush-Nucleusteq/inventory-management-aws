import Header from "../Component/Header/Header";
import SideBar from "../Component/SideBar/SideBar";
import "./Home.css";
import { useLocation, Link } from "react-router-dom";
import EmployeeForm from "../Component/Form/EmployeeForm";
import ItemForm from "../Component/Form/ItemForm";
import Dashboard from "../Component/Dashboard/Dashboard";
import AssignItem from "../Component/AssignItem/AssignItem";

const Home = () => {
  const location = useLocation();
  const pathname = location.pathname;

  console.log(pathname)

  return (
    <div className="home-container">
      <Header />

      <div className="page-content">
        <SideBar className="sidebar">
          <SideBar.Item className={pathname === "/" ? "active" : ""}>
            <Link to="/dashboard">Dashboard</Link>
          </SideBar.Item>
          <SideBar.Item className={pathname === "/employee" ? "active" : ""}>
            <Link to="/employee">Add Employee</Link>
          </SideBar.Item>
          <SideBar.Item className={pathname === "/item" ? "active" : ""}>
            <Link to="/item">Add Item</Link>
          </SideBar.Item>
          <SideBar.Item className={pathname === "/assignItem" ? "active" : ""}>
            <Link to="/assignItem">Assign Item</Link>
          </SideBar.Item>
        </SideBar>

        <div className="content">
          {pathname === "/dashboard" && <Dashboard />}
          {pathname === "/employee" && <EmployeeForm />}
          {pathname === "/item" && <ItemForm />}
          {pathname === "/assignItem" && <AssignItem />}
        </div>
      </div>
    </div>
  );
};

export default Home;

import "./Header.css";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";

const Header = ({ className }) => {
  const navigate = useNavigate();
  function handleLogout() {
    toast.info("Logged Out Successfully !", {
      position: "top-right",
      autoClose: 1000,
    });
    setTimeout(function () {
      console.log("Insidee logout>>");
      localStorage.removeItem("userEmail");
      navigate("/");
    }, 1000);
  }
  return (
    <header className={className ? `header ${className}` : "header"}>
      <div className="logo">Inventory Management Portal</div>
      <button
        className="sign-out-btn"
        onClick={() => {
          localStorage.setItem("userLogin", JSON.stringify(null));
          localStorage.setItem("employeeLogin", JSON.stringify(null));
          handleLogout();

          navigate("/");
        }}
      >
        Sign out
      </button>
    </header>
  );
};

export default Header;

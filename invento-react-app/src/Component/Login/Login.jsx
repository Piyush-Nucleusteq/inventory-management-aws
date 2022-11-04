import React from "react";
import { useState, useEffect } from "react";
import "./loginFrom.css";
import Axios from "axios";
import { Base64 } from "js-base64";
import { useNavigate, Link } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { BASE_URL } from "../Constants/apiConstants";

const Login = () => {
  const initialValues = { email: "", password: "" };
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const navigate = useNavigate();
  let isValid = false;
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
    setFormErrors(validate(formValues));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setFormErrors(validate(formValues));
    if (isValid) {
      setIsSubmit(true);
      var encodePassword = Base64.encode(formValues.password);
      localStorage.setItem("userEmail", JSON.stringify(formValues.email));
      Axios.post(BASE_URL + `loginUser`, {
        email: formValues.email,
        password: encodePassword,
      })
        .then((res) => {
          if (res.status === 200) {
            console.log(">>>>>>>>>>>>>>>>>> login");
            localStorage.setItem("userLogin", JSON.stringify(res.data));
            if (res.data.role === "admin") {
              navigate("/dashboard");
            } else {
              localStorage.setItem("employeeLogin", JSON.stringify(res.data));
              if (res.data.firstLogin === true) {
                navigate("/reset", { state: formValues });
              } else {
                navigate("/employeeDashboard");
              }
            }
          }
          console.log(res.data);
        })
        .catch((err) => {
          console.log("what err in catch", err);
          if (err.response.status === 401) {
            toast.error("Invalid Credentials!", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          } else if (err.response.status === 400)
            toast.error("Login failed", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
        });
      setFormValues(initialValues);
    }
  };

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
      console.log(formValues);
    }
  }, [formErrors]);
  const validate = (values) => {
    const errors = {};
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;

    if (!values.email) {
      errors.email = "Email is required!";
    } else if (!regex.test(values.email)) {
      errors.email = "This is not a valid email format!";
    }
    if (!values.password) {
      errors.password = "Password is required";
    }
    console.log("what errors", errors);
    if (Object.keys(errors).length === 0) {
      isValid = true;
    }
    return errors;
  };

  return (
    <>
      <div className="loginroot">
        <div className="container">
          <div className="screen">
            <div className="screen__content">
              <form className="login" onSubmit={handleSubmit}>
                <h2>Welocome to Inventory Portal</h2>
                <div className="login__field">
                  <input
                    id="email"
                    type="text"
                    className="login__input"
                    placeholder=" Email"
                    name="email"
                    value={formValues.email}
                    onChange={handleChange}
                  />

                  <p className="errormsg">{formErrors.email}</p>
                </div>
                <div className="login__field">
                  <input
                    id="password"
                    type="password"
                    className="login__input"
                    name="password"
                    placeholder="Password"
                    autocomplete="on"
                    value={formValues.password}
                    onChange={handleChange}
                  />

                  <p className="errormsg">{formErrors.password}</p>
                </div>
                <button className="button login__submit">
                  <span className="button__text">Login</span>
                </button>
              </form>
              <div className="text">
                <p className="text-center">
                  Don't have an account? <Link to="/registration">Sign up</Link>
                </p>
              </div>
            </div>
            <ToastContainer />
            <div className="screen__background">
              {/* <span className="screen__background__shape screen__background__shape4"></span> */}
              <span className="screen__background__shape screen__background__shape3"></span>
              <span className="screen__background__shape screen__background__shape2"></span>
              <span className="screen__background__shape screen__background__shape1"></span>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;

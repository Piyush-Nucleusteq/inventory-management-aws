import React from "react";
import { useState, useEffect } from "react";
import "./ResetPassword.css";
import Axios from "axios";
import { Base64 } from "js-base64";
import { useNavigate, Link, useLocation } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { BASE_URL } from "../Constants/apiConstants";

const ResetPassword = () => {
  const initialValues = { password: "", resetPassword: "" };
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  const navigate = useNavigate();
  let isValid = false;
  let userEmail = JSON.parse(localStorage.getItem("userEmail"));
  console.log("incoming >>", userEmail);
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
      var encodePassword = Base64.encode(formValues.resetPassword);
      Axios.put(BASE_URL + `reset`, {
        email: userEmail,
        password: encodePassword,
      })
        .then((res) => {
          if (res.status === 200) {
            console.log(">>>>>>>>>>>>>>>>>> login");
            localStorage.setItem("userLogin", JSON.stringify(res.data));
            if (res.status === 200) {
              navigate("/");
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
            toast.error("Reset Password failed", {
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

    if (!values.password) {
      errors.password = "Password is required";
    }
    if (!values.resetPassword) {
      errors.resetPassword = "Reset Password is required!";
    }
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
              <form className="login">
                <h2>Welocome to Inventory Portal</h2>

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
                <div className="login__field">
                  <input
                    id="resetPassword"
                    type="password"
                    className="login__input"
                    placeholder=" Reset Password"
                    name="resetPassword"
                    value={formValues.resetPassword}
                    onChange={handleChange}
                  />

                  <p className="errormsg">{formErrors.resetPassword}</p>
                </div>
                <button className="button login__submit">
                  <span className="button__text" onClick={handleSubmit}>
                    Reset Password
                  </span>
                </button>
              </form>
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

export default ResetPassword;

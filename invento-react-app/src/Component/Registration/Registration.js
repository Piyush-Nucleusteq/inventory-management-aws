import React, { useEffect } from "react";
import { useState } from "react";
import "../Registration/Registration.css";
import Axios from "axios";
import { Base64 } from "js-base64";
import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { BASE_URL } from "../Constants/apiConstants";

const Registration = () => {
  const navigate = useNavigate();
  const initialValues = {
    firstName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    designation: "",
    password: "",
    confirmPassword: "",
    dateOfBirth: "",
    dateOfJoining: "",
    location: "",
    employeeId: "",
  };
  const [formValues, setFormValues] = useState(initialValues);
  const [formErrors, setFormErrors] = useState({});
  const [isSubmit, setIsSubmit] = useState(false);
  let isValid = false;

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormValues({ ...formValues, [name]: value });
    setFormErrors(validate(formValues));
  };

  const handleSubmit = (e) => {
    // e.preventDefault();
    setFormErrors(validate(formValues));

    console.log("what formErros>>>", Object.keys(formErrors).length);

    if (isValid) {
      setIsSubmit(true);

      var encodePassword = Base64.encode(formValues.password);
      Axios.post(BASE_URL+"user", {
        firstName: formValues.firstName,
        lastName: formValues.lastName,
        email: formValues.email,
        phoneNumber: formValues.phoneNumber,
        designation: formValues.designation,
        dateOfBirth: formValues.dateOfBirth,
        dateOfJoining: formValues.dateOfJoining,
        password: encodePassword,
        location: formValues.location,
        employeeId: formValues.employeeId,
        role: "admin",
      })
        .then((res) => {
          if (res.status === 200) {
            navigate("/");
            toast.success("Registration successful!", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          } else if (res.status === 302) {
            toast.error(
              "Email or employeeid or primary contact - already exist!",
              { draggable: true, position: toast.POSITION.TOP_CENTER }
            );
          } else if (res.status === 400)
            toast.error("Registration failed", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          console.log(res);
        })
        .catch((err) => {
          console.log("what err in catch", err);
          if (err.response.status === 302) {
            toast.error(
              "Email or employeeid or primary contact - already exist!",
              { draggable: true, position: toast.POSITION.TOP_CENTER }
            );
          } else if (err.response.status === 400)
            toast.error("Registration failed", {
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
    console.log("what values", values);
    const errors = {};
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;
    const minNameLengthRegExp = /.{2,}/;
    const contactRegExp = /[0-9]{10}/;
    const regexddmmyyyy = /^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/;

    if (!values.firstName) {
      errors.firstName = "First name is required!";
    } else if (!minNameLengthRegExp.test(values.firstName)) {
      errors.firstName = "Please enter valid first name!";
    }
    if (!values.email) {
      errors.email = "Email is required!";
    } else if (!regex.test(values.email)) {
      errors.email = "Please Enter Valid Company Credentials!";
    }
    if (!values.password) {
      errors.password = "Password is required";
    } else if (values.password.length < 4) {
      errors.password = "Password must be more than 4 characters";
    } else if (values.password.length > 10) {
      errors.password = "Password cannot exceed more than 10 characters";
    }
    if (!values.lastName) {
      errors.lastName = "Last Name is required!";
    } else if (!minNameLengthRegExp.test(values.lastName)) {
      errors.lastName = "This is not a valid last name!";
    }
    if (!values.confirmPassword) {
      errors.confirmPassword = "Enter Confirm Password";
    } else if (values.confirmPassword !== values.password) {
      initialValues.confirmPassword = "Passowrds doesn't Match";
    }
    if (!regexddmmyyyy.test(values.dateOfBirth)) {
      errors.dateOfBirth = "Date of birth is required!";
    }
    if (!values.designation) {
      errors.designation = "Designation required!";
    }
    if (!values.location) {
      errors.location = "Location required!";
    }
    if (!values.employeeId) {
      errors.employeeId = "Employee Id required!";
    }
    if (!regexddmmyyyy.test(values.dateOfJoining)) {
      errors.dateOfJoining = "Date of joining is required!";
    }
    if (!contactRegExp.test(values.phoneNumber)) {
      errors.phoneNumber = "Contact is required!.";
    }
    console.log("what errors", errors);
    if (Object.keys(errors).length === 0) {
      isValid = true;
    }
    return errors;
  };
  return (
    <>
      <div className="container1">
        <div className="screen1">
          <div className="screen__content1">
            <div className="login1">
              <h2>Welocome to Inventory Portal</h2>
              <div
                style={{
                  maxHeight: "122vh",
                  display: "flex",
                  flexDirection: "column",
                  flexWrap: "wrap",
                }}
              >
                <div className="login__field1">
                  <label for="firstName" className="labletag">
                    First Name
                  </label>
                  <input
                    id="firstName"
                    type="text"
                    className="login__input1"
                    placeholder=" First Name"
                    name="firstName"
                    value={formValues.firstName}
                    onChange={handleChange}
                  />
                  <p className="errormsg1">{formErrors.firstName}</p>
                </div>
                <div className="login__field1">
                  <label for="employeeId" className="labletag">
                    Employee ID
                  </label>
                  <input
                    id="employeeId"
                    type="text"
                    className="login__input1"
                    placeholder="Employee ID"
                    name="employeeId"
                    value={formValues.employeeId}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.employeeId}</p>
                </div>

                <div className="login__field1">
                  <label for="email" className="labletag">
                    Email
                  </label>
                  <input
                    id="email"
                    type="text"
                    className="login__input1"
                    name="email"
                    placeholder="Email"
                    value={formValues.email}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.email}</p>
                </div>
                <div className="login__field1">
                  <label for="password" className="labletag">
                    Password
                  </label>
                  <input
                    id="password"
                    type="password"
                    className="login__input1"
                    name="password"
                    placeholder="Password"
                    value={formValues.password}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.password}</p>
                </div>
                <div className="login__field1">
                  <label for="dateOfJoining" className="labletag">
                    Date Of Joining
                  </label>
                  <input
                    id="dateOfJoining"
                    type="date"
                    min="2018-01-01"
                    className="login__input1"
                    placeholder="Date Of Joining"
                    name="dateOfJoining"
                    value={formValues.dateOfJoining}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.dateOfJoining}</p>
                </div>

                <div className="login__field1">
                  <label for="location" className="labletag">
                    Location
                  </label>
                  <select
                    className="location"
                    name="location"
                    value={formValues.location}
                    onChange={handleChange}
                  >
                    <option value="">Location</option>
                    <option value="Indore">Indore</option>
                    <option value="Raipur">Raipur</option>
                    <option value="Bangalore">Bangalore</option>
                    <option value="Phoenix Arizona">Phoenix Arizona</option>
                    <option value="Canada">Canada</option>
                  </select>

                  <p className="errormsg1">{formErrors.location}</p>
                </div>

                <div className="login__field1">
                  <label for="lastName" className="labletag">
                    Last Name
                  </label>
                  <input
                    id="lastName"
                    type="text"
                    className="login__input1"
                    placeholder="Last Name"
                    name="lastName"
                    value={formValues.lastName}
                    onChange={handleChange}
                  />
                  <p className="errormsg1">{formErrors.lastName}</p>
                </div>

                <div className="login__field1">
                  <label for="dob" className="labletag">
                    Date Of Birth
                  </label>
                  <input
                    id="dateOfBirth"
                    type="date"
                    max="2006-01-01"
                    className="login__input1"
                    placeholder="Date Of Birth "
                    name="dateOfBirth"
                    value={formValues.dateOfBirth}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.dateOfBirth}</p>
                </div>
                <div className="login__field1">
                  <label for="designation" className="labletag">
                    Designation
                  </label>
                  <select
                    className="designation"
                    name="designation"
                    value={formValues.designation}
                    onChange={handleChange}
                  >
                    <option value="">Designation</option>
                    <option value="Intern">Intern</option>
                    <option value="Developer">Developer</option>
                    <option value="Senior developer">Senior developer</option>
                    <option value="Manager">Manager</option>
                    <option value="Oprations">Oprations</option>
                    <option value="Recruiter">Recruiter</option>
                  </select>
                  <p className="errormsg1">{formErrors.designation}</p>
                </div>
                <div className="login__field1">
                  <label for="confirmPassword" className="labletag">
                    Confirm Password
                  </label>
                  <input
                    id="confirmPassword"
                    type="password"
                    className="login__input1"
                    placeholder="Confirm Password"
                    name="confirmPassword"
                    value={formValues.confirmPassword}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.confirmPassword}</p>
                </div>
                <div className="login__field1">
                  <label for="phoneNumber" className="labletag">
                    Phone Number
                  </label>
                  <input
                    id="phoneNumber"
                    type="text"
                    className="login__input1"
                    placeholder="Phone Number"
                    name="phoneNumber"
                    value={formValues.phoneNumber}
                    onChange={handleChange}
                  />

                  <p className="errormsg1">{formErrors.phoneNumber}</p>
                </div>

                <button
                  className="button login__submit1"
                  onClick={handleSubmit}
                >
                  <span className="button__text1">Sign Up</span>
                </button>
              </div>
            </div>
          </div>
          <ToastContainer />
          <div className="screen__background1">
            {/* <span className="screen__background__shape screen__background__shape4"></span> */}
            <span className="screen__background__shape screen__background__shape31"></span>
            <span className="screen__background__shape screen__background__shape21"></span>
            <span className="screen__background__shape screen__background__shape11"></span>
          </div>
        </div>
      </div>
      <div className="text" onClick={() => navigate("/")}>
        <p className="text-center">Already have an account?Sign in</p>
      </div>
    </>
  );
};

export default Registration;

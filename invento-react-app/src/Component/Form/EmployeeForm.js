import axios from "axios";
import { useState } from "react";
import { Base64 } from "js-base64";
import "./employee-form.css";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { useEffect } from "react";
import { BASE_URL } from "../Constants/apiConstants";

const selectStyles = {
  padding: "5px 10px",
  border: "none",
  borderBottom: "1px solid #202020",
};

const buttonStyles = {
  width: "100%",
  backgroundColor: "#202020",
  color: "#fff",
  padding: "12px 24px",
  border: 0,
  letterSpacing: "1px",
  marginTop: "16px",
};

const locations = ["Indore", "Raipur", "Bangalore", "Phoenix", "Canada"];

const designations = [
  "Intern",
  "Developer",
  "Senior developer",
  "Manager",
  "Oprations",
  "Recruiter",
];

const EmployeeForm = () => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [empId, setEmpId] = useState("");
  const [phone, setPhone] = useState("");
  const [dob, setDob] = useState("");
  const [doj, setDoj] = useState("");
  const [location, setLocation] = useState("");
  const [designation, setDesignation] = useState("");
  const [formErrors, setFormErrors] = useState({});

  const [isSubmit, setIsSubmit] = useState(false);
  let isValid = false;

  useEffect(() => {
    console.log(formErrors);
    if (Object.keys(formErrors).length === 0 && isSubmit) {
    }
  }, [formErrors]);

  const onSubmit = async (e) => {
    e.preventDefault();

    const errors = {};
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;
    const minNameLengthRegExp = /.{2,}/;
    const contactRegExp = /[0-9]{10}/;
    const regexddmmyyyy = /^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/;
    const regexEmployee = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;

    if (firstName.trim() === "") {
      errors.firstName = "First Name is Required";
    } else if (!minNameLengthRegExp.test(lastName)) {
      errors.firstName = "Not a valid first name!";
    }
    if (lastName.trim() === "") {
      errors.lastName = "Last Name is Required";
    } else if (!minNameLengthRegExp.test(lastName)) {
      errors.lastName = "Not a valid last name!";
    }
    if (email.trim() === "") {
      errors.email = "Email is Required";
    } else if (!regex.test(email)) {
      errors.email = "Please Enter Valid Company Credentials!";
    }
    if (empId.trim() === "") {
      errors.empId = "Employee ID is Required";
    }
    if (dob.trim() === "") {
      errors.dob = "Date Of Birth is Required";
    } else if (!regexddmmyyyy.test(dob)) {
      errors.dob = "Date of birth is required!";
    }
    if (doj.trim() === "") {
      errors.doj = "Date Of Joining is Required";
    } else if (!regexddmmyyyy.test(doj)) {
      errors.doj = "Date of joining is invalid!";
    }
    if (location.trim() === "") {
      errors.location = "Location is required";
    }
    if (designation.trim() === "") {
      errors.designation = "Designation is required!";
    }
    if (phone.trim() === "") {
      errors.phone = "Designation last name";
    } else if (!contactRegExp.test(phone)) {
      errors.phone = "Phone Number is invalid!";
    }
    if (Object.keys(errors).length === 0) {
      isValid = true;
    }

    setFormErrors(errors);

    if (isValid) {
      setIsSubmit(true);
      var encodePassword = Base64.encode(empId + "@" + dob);
      console.log(empId + "@" + dob);

      const { data } = await axios

        .post(BASE_URL + "employee", {
          firstName: firstName,
          lastName: lastName,
          email: email,
          phoneNumber: phone,
          designation: designation,
          dateOfBirth: dob,
          dateOfJoining: doj,
          location: location,
          employeeId: empId,
          role: "employee",
          password: encodePassword,
        })
        .then((res) => {
          if (res.status === 200) {
            toast.success("Employee addded successfully!", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
              theme: "dark",
            });
            setFormErrors({});
            setFirstName("");
            setLastName("");
            setEmail("");
            setDob("");
            setDoj("");
            setEmpId("");
            setLocation("");
            setDesignation("");
            setPhone("");
          } else if (res.status === 302) {
            toast.error(
              "Email or employeeid or primary contact - already exist!",
              { draggable: true, position: toast.POSITION.TOP_CENTER }
            );
          }
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
            toast.error("Adding employee failed", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
        });
    }
  };

  return (
    <div className="emp-form-container">
      <form className="emp-form" onSubmit={onSubmit}>
        <div className="form-group">
          <label for="first-name">First Name</label>
          <input
            id="first-name"
            type="text"
            placeholder="First Name"
            value={firstName}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                firstName: "",
              });
              setFirstName(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.firstName}</p>
        </div>

        <div className="form-group">
          <label for="last-name">Last Name</label>
          <input
            id="last-name"
            type="text"
            placeholder="Last Name"
            value={lastName}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                lastName: "",
              });
              setLastName(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.lastName}</p>
        </div>

        <div className="form-group">
          <label for="email">Email</label>
          <input
            id="email"
            type="email"
            placeholder="Email"
            value={email}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                email: "",
              });
              setEmail(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.email}</p>
        </div>

        <div className="form-group">
          <label for="eid">Employee Id</label>
          <input
            id="eid"
            type="text"
            placeholder="Employee Id"
            value={empId}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                empId: "",
              });
              setEmpId(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.empId}</p>
        </div>

        <div className="form-group">
          <label for="phone">Phone Number</label>
          <input
            id="phone"
            type="text"
            placeholder="Phone number"
            value={phone}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                phone: "",
              });
              setPhone(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.phone}</p>
        </div>

        <div className="form-group">
          <label for="dob">Date of Birth</label>
          <input
            id="dob"
            type="date"
            max="2006-01-01"
            placeholder="Date of Birth"
            value={dob}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                dob: "",
              });
              setDob(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.dob}</p>
        </div>

        <div className="form-group">
          <label for="doj">Date of Joining</label>
          <input
            id="doj"
            min="2018-01-01"
            type="date"
            placeholder="Date of Joining"
            value={doj}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                doj: "",
              });
              setDoj(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.doj}</p>
        </div>

        <div className="form-group">
          <label for="location">Choose Location</label>
          <select
            className="select"
            id="location"
            style={selectStyles}
            value={location}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                location: "",
              });
              setLocation(e.target.value);
            }}
          >
            <option value="">Choose Location</option>
            {locations.map((location) => (
              <option value={location}>{location}</option>
            ))}
          </select>
          <p className="errormsg2">{formErrors.location}</p>
        </div>

        <div className="form-group">
          <label for="location">Choose Designation</label>

          <select
            className="select"
            id="designation"
            style={selectStyles}
            value={designation}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                designation: "",
              });
              setDesignation(e.target.value);
            }}
          >
            <option value="" id="designation">
              Choose Designation
            </option>
            {designations.map((designation) => (
              <option value={designation}>{designation}</option>
            ))}
          </select>
          <p className="errormsg2">{formErrors.designation}</p>
        </div>

        <button className="button" style={buttonStyles}>
          Submit
        </button>
      </form>
      <ToastContainer />
    </div>
  );
};

export default EmployeeForm;

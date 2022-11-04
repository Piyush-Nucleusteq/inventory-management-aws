import axios from "axios";
import { useState } from "react";
import "./UpdateEmployee.css";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
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

const UpdateEmployee = (props) => {
  console.log("PROPS_REC - ", props);
  const [employee, setEmployee] = useState(props.updateEmployeeData);
  const [formErrors, setFormErrors] = useState({});

  const setEmployeeValue = (key, value) => {
    let newEmployee = { ...employee };
    newEmployee[key] = value;
    setEmployee(newEmployee);
  };
  const onSubmit = async (e) => {
    e.preventDefault();

    const errors = {};
    const regex = /^[A-Za-z0-9._%+-]+@nucleusteq.com$/i;
    const minNameLengthRegExp = /.{2,}/;
    const contactRegExp = /[0-9]{10}/;
    const regexddmmyyyy = /^\d{4}\-(0[1-9]|1[012])\-(0[1-9]|[12][0-9]|3[01])$/;

    // if (firstName.trim() === "") {
    //   errors.firstName = "First Name is Required";
    // } else if (!minNameLengthRegExp.test(lastName)) {
    //   errors.firstName = "Not a valid first name!";
    // }
    // if (lastName.trim() === "") {
    //   errors.lastName = "Last Name is Required";
    // } else if (!minNameLengthRegExp.test(lastName)) {
    //   errors.lastName = "Not a valid last name!";
    // }
    // if (email.trim() === "") {
    //   errors.email = "Email is Required";
    // } else if (!regex.test(email)) {
    //   errors.email = "Please Enter Valid Company Credentials!";
    // }
    // if (empId.trim() === "") {
    //   errors.empId = "Employee ID is Required";
    // }
    // if (dob.trim() === "") {
    //   errors.dob = "Date Of Birth is Required";
    // } else if (!regexddmmyyyy.test(dob)) {
    //   errors.dob = "Date of birth is required!";
    // }
    // if (doj.trim() === "") {
    //   errors.doj = "Date Of Joining is Required";
    // } else if (!regexddmmyyyy.test(doj)) {
    //   errors.doj = "Date of joining is required!";
    // }
    // if (location.trim() === "") {
    //   errors.location = "Location last name";
    // }
    // if (designation.trim() === "") {
    //   errors.designation = "Designation last name";
    // }
    // if (phone.trim() === "") {
    //   errors.phone = "Designation last name";
    // } else if (!contactRegExp.test(phone)) {
    //   errors.phone = "Contact is required!.";
    // }

    setFormErrors(errors);

    // Call to api
    try {
      const resp = await axios
        .put(BASE_URL + "employee", {
          ...employee,
          role: "employee",
          password: " ",
        })
        .then((res) => {
          if (res.status === 200) {
            toast.success("Employee Updated successfully!", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          } else if (res.status === 302) {
            toast.error(
              "Email or employeeid or primary contact - already exist!",
              { draggable: true, position: toast.POSITION.TOP_CENTER }
            );
          } else if (res.status === 400)
            toast.error("Updating employee failed", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          console.log(res);
        });
      return props.onUpdateEmployee();
    } catch (error) {
      console.log(error.response.data);
    }

    // Do something
  };

  return (
    <>
      <div id="backdrop" onClick={props.onUpdateEmployee}></div>
      <div className="emp-form-container2">
        <form className="emp-form2" onSubmit={onSubmit}>
          <div className="form-group2">
            <label for="first-name">First Name</label>
            <input
              id="first-name"
              type="text"
              placeholder="First Name"
              value={employee.firstName}
              onChange={(e) => setEmployeeValue("firstName", e.target.value)}
            />
            <p className="errormsg2">{formErrors.firstName}</p>
          </div>

          <div className="form-group2">
            <label for="last-name">Last Name</label>
            <input
              id="last-name"
              type="text"
              placeholder="Last Name"
              value={employee.lastName}
              onChange={(e) => setEmployeeValue("lastName", e.target.value)}
            />
            <p className="errormsg2">{formErrors.lastName}</p>
          </div>

          <div className="form-group2">
            <label for="email" className="disable">
              Email
            </label>
            <input
              disabled="true"
              id="email"
              type="email"
              placeholder="Email"
              value={employee.email}
              onChange={(e) => setEmployeeValue("email", e.target.value)}
            />
            <p className="errormsg2">{formErrors.email}</p>
          </div>

          <div className="form-group2">
            <label for="eid" className="disable">
              Employee Id
            </label>
            <input
              disabled="true"
              id="eid"
              type="text"
              placeholder="Employee Id"
              value={employee.employeeId}
              onChange={(e) => setEmployeeValue("employeeId", e.target.value)}
            />
            <p className="errormsg2">{formErrors.empId}</p>
          </div>

          <div className="form-group2">
            <label for="phone" className="disable">
              Phone Number
            </label>
            <input
              disabled="true"
              id="phone"
              type="number"
              placeholder="Phone number"
              value={employee.phoneNumber}
              onChange={(e) => setEmployeeValue("phoneNumber", e.target.value)}
            />
            <p className="errormsg2">{formErrors.phone}</p>
          </div>

          <div className="form-group2">
            <label for="dob">Date of Birth</label>
            <input
              id="dob"
              type="date"
              max="2006-01-01"
              placeholder="Date of Birth"
              value={employee.dateOfBirth}
              onChange={(e) => setEmployeeValue("dateOfBirth", e.target.value)}
            />
            <p className="errormsg2">{formErrors.dob}</p>
          </div>

          <div className="form-group2">
            <label for="doj">Date of Joining</label>
            <input
              id="doj"
              min="2018-01-01"
              type="date"
              placeholder="Date of Joining"
              value={employee.dateOfJoining}
              onChange={(e) =>
                setEmployeeValue("dateOfJoining", e.target.value)
              }
            />
            <p className="errormsg2">{formErrors.doj}</p>
          </div>

          <div className="form-group2">
            <label for="location">Choose Location</label>
            <select
              className="select"
              id="location"
              style={selectStyles}
              value={employee.location}
              onChange={(e) => setEmployeeValue("location", e.target.value)}
            >
              <option value="">Choose Location</option>
              {locations.map((location) => (
                <option value={location}>{location}</option>
              ))}
            </select>
            <p className="errormsg2">{formErrors.location}</p>
          </div>

          <div className="form-group2">
            <label for="location">Choose Designation</label>

            <select
              className="select"
              id="designation"
              style={selectStyles}
              value={employee.designation}
              onChange={(e) => setEmployeeValue("designation", e.target.value)}
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
          <div className="form-group2">
            <label for="doe">Date of Exit</label>
            <input
              id="doe"
              type="date"
              min={employee.dateOfJoining}
              // max="2006-01-01"
              placeholder="Date of Exit"
              value={employee.dateOfExit}
              onChange={(e) => setEmployeeValue("dateOfExit", e.target.value)}
            />
            <p className="errormsg2">{formErrors.doe}</p>
          </div>

          <button className="button" style={buttonStyles}>
            Update
          </button>
        </form>

        <ToastContainer />
      </div>
    </>
  );
};
export default UpdateEmployee;

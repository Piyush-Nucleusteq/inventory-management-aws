import axios from "axios";
import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { BASE_URL } from "../Constants/apiConstants";
import Header from "../Header/Header";

const EmployeeDashboard = () => {
  const [user, setUser] = useState();
  const [employeeData, setEmployeeData] = useState([]);
  const [employeeDetails, setEmployeeDetails] = useState({});
  const navigate = useNavigate();
  useEffect(() => {
    checkUserLogin();
  }, []);
  function checkUserLogin() {
    let user = JSON.parse(localStorage.getItem("employeeLogin"));
    if (user == null) {
      navigate("/");
    } else {
      setUser(user);
      console.log(user);
    }
  }

  const handleSubmit = async () => {
    var id = JSON.parse(localStorage.getItem("employeeLogin"));
    console.log("--->", id);
    try {
      const { data } = await axios.get(
        BASE_URL + `AssignItem/${id.employeeId}`
      );
      console.log(data);
      setEmployeeData(data);
    } catch (error) {
      alert(error);
    }
  };

  const getUserData = async () => {
    var id = JSON.parse(localStorage.getItem("employeeLogin"));
    console.log("--->", id);
    try {
      const { data } = await axios.get(
        BASE_URL + `searchEmployee/${id.employeeId}`
      );
      console.log("employee details>>>", data);
      setEmployeeDetails(data);
    } catch (error) {
      alert(error);
    }
  };

  useEffect(() => {
    handleSubmit();
    getUserData();
  }, []);

  return (
    <>
      <div className="emp-dash-container">
        <Header />
        <div className="employee-data-container">
          {employeeDetails.length !== 0 && (
            <table style={{ marginBottom: "2rem" }}>
              <thead>
                <tr>
                  <th>Employee Name</th>
                  <th>Employee Email</th>
                  <th>Employee Id</th>
                  <th>Phone Number</th>
                  <th>Date of Joining</th>
                  <th>Designation</th>
                  <th>Location</th>
                </tr>
              </thead>

              <tbody>
                <tr>
                  <td>
                    {employeeDetails.firstName || employeeDetails.firstName}
                    {employeeDetails.lastName || employeeDetails.lastName}
                  </td>
                  <td>{employeeDetails.email || employeeDetails.email}</td>
                  <td>
                    {employeeDetails.employeeId || employeeDetails.employeeId}
                  </td>
                  <td>{employeeDetails.phoneNumber}</td>
                  <td>{employeeDetails.dateOfJoining}</td>
                  <td>{employeeDetails.designation}</td>
                  <td>{employeeDetails.location}</td>
                </tr>
              </tbody>
            </table>
          )}

          {employeeData.length > 0 && (
            <table>
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Item number</th>
                  <th>Item Name</th>
                  <th>Date of assign</th>
                  <th>Item Condition</th>
                  <th>Incidents</th>
                </tr>
              </thead>

              <tbody>
                {employeeData.map((item) => (
                  <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.itemNumber}</td>
                    <td>{item.itemName}</td>
                    <td>{item.dateOfAssigned}</td>
                    <td>{item.itemCondition}</td>
                    <td>
                      {item.incidentsIfAny ? item.incidentsIfAny : "N.A."}
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      </div>
      <footer style={{ backgroundColor: "grey" }}>
        <p>in case of any query , please contact : operations@nucleusteq.com</p>
      </footer>
    </>
  );
};

export default EmployeeDashboard;

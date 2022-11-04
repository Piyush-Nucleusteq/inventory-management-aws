import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { Link } from "react-router-dom";
import "./AssignItem.css";
import { ToastContainer, toast } from "react-toastify";
import { BASE_URL } from "../Constants/apiConstants";

const AssignItem = () => {
  const [search, setSearch] = useState("");
  const [employeeData, setEmployeeData] = useState([]);
  const [assignData, setAssignData] = useState([]);
  const [employeeTableId, setEmployeeTableId] = useState(0);
  const [isData, setisData] = useState(false);
  const handleDelete = async (paramId) => {
    console.log("incoming id is ", paramId);
    const { data } = await axios.delete(
      BASE_URL + `AssignItem/delete/${paramId}`
    );
    handleSubmit();
  };
  const handleSubmit = async () => {
    try {
      const { data } = await axios.get(BASE_URL + `AssignItem/${search}`);
      if (data.length === 0) {
        const { data } = await axios.get(BASE_URL + `searchEmployee/${search}`);
        console.log("--->data", data);
        const data1 = { ...data, item: null };
        console.log("New data", data1);
        setEmployeeData([data1]);
        setAssignData([]);
        console.log(data.userId);
        setEmployeeTableId(data.userId);
        setisData(true);
      } else {
        setEmployeeData(data);
        setisData(false);
        setEmployeeTableId(data[0].employeeTableId);
        setAssignData([]);
      }
    } catch (error) {
      console.log("---> error", error);
      toast.error(error.response.data.message, {
        position: "top-right",
        autoClose: 1000,
      });
    }
  };
  const handleAssignData = async () => {
    const { data } = await axios.get(BASE_URL + `AllAssignedItem`);
    console.log(data);
    setAssignData(data);
  };
  useEffect(() => {
    handleAssignData();
  }, []);

  return (
    <div className="assign-page-container">
      <div className="search-form-container">
        <input
          type="text"
          placeholder="Enter employee id"
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
        <button onClick={handleSubmit}>Search</button>
      </div>

      <div className="employee-data-container">
        {employeeData.length > 0 && (
          <table style={{ marginBottom: "2rem" }}>
            <thead>
              <tr>
                <th>Employee Name</th>
                <th>Employee Email</th>
                <th>Employee Id</th>
              </tr>
            </thead>

            <tbody>
              <tr>
                <td>
                  {employeeData[0].firstName} {employeeData[0].lastName}
                </td>
                <td>{employeeData[0].email}</td>
                <td>{employeeData[0].employeeId}</td>
              </tr>
            </tbody>
          </table>
        )}
        {isData
          ? null
          : employeeData.length > 0 && (
              <table>
                <thead>
                  <tr key={console.log(employeeData[0].item === null)}>
                    <th>Id</th>
                    <th>Item number</th>
                    <th>Item Name</th>
                    <th>Date of assign</th>
                    <th>Item Condition</th>
                    <th>Incidents</th>
                    <th></th>
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
                      <td>
                        <button
                          className="delete"
                          onClick={() => {
                            handleDelete(item.id);
                          }}
                        >
                          Un-Assign
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            )}
      </div>
      <div className="assign-data-container">
        {assignData.length !== 0 && (
          <table>
            <thead>
              <tr>
                <th>Id</th>
                <th>EmployeeId</th>
                <th>Item number</th>
                <th>Item Name</th>
                <th>Date of assign</th>
                <th>Item Condition</th>
                <th>Incidents</th>
                <th></th>
              </tr>
            </thead>

            <tbody>
              {assignData.map((assign) => (
                <tr key={assign.id}>
                  <td>{assign.id}</td>
                  <td>{assign.employeeId}</td>
                  <td>{assign.itemNumber}</td>
                  <td>{assign.itemName}</td>
                  <td>{assign.dateOfAssigned}</td>
                  <td>{assign.itemCondition}</td>
                  <td>
                    {assign.incidentsIfAny ? assign.incidentsIfAny : "N.A."}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>

      {employeeData.length > 0 && (
        <div className="btn-container">
          <Link
            to={`/assignNewItem/${employeeData[0].employeeId}/${employeeTableId}`}
            style={{
              padding: "1rem 2rem",
              backgroundColor: "#303030",
              color: "#fff",
              marginTop: "2rem",
            }}
          >
            {localStorage.setItem(
              "userDetails",
              JSON.stringify(employeeData[0])
            )}
            Assign New Item
          </Link>
        </div>
      )}
      <ToastContainer />
    </div>
  );
};

export default AssignItem;

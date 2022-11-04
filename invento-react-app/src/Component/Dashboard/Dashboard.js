import axios from "axios";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { BASE_URL } from "../Constants/apiConstants";
import UpdateEmployee from "../Update/UpdateEmployee";
import UpdateItem from "../Update/UpdateItem";
import "./Dashboard.css";

const urls = [BASE_URL + "employee", BASE_URL + "item"];

const Dashboard = () => {
  let navigate = useNavigate();
  function checkUserLogin() {
    let user = JSON.parse(localStorage.getItem("userLogin"));
    if (user == null) {
      console.log("inside iff>>>", user);
      navigate("/");
    } else {
      console.log("inside else", user);
      getData();
    }
  }
  const [updateemployeerecord, setUpdateEmployeeRecord] = useState({});
  const [createemployeeflag, setCreateEmployeeFlag] = useState(false);
  const [employees, setEmployees] = useState([]);
  const [updateitemrecord, setUpdateItemRecord] = useState({});
  const [createitemflag, setCreateItemFlag] = useState(false);
  const [isEmp, setIsEmp] = useState(true);

  const fetchData = async (url) => {
    try {
      const { data } = await axios.get(url);
      console.log(data);
      return data;
    } catch (error) {}
  };

  let handleUpdate = (e) => {
    setUpdateEmployeeRecord(e);
    console.log("handleupdate for employee working", e);
    setCreateEmployeeFlag(true);
  };
  let handleUpdateItem = (e) => {
    setUpdateItemRecord(e);
    console.log("handle update for item working", e);
    setCreateItemFlag(true);
  };

  function CreateEmployeeFlagFunction() {
    setCreateEmployeeFlag(!createemployeeflag);
    getData();
  }
  function CreateItemFlagFunction() {
    setCreateItemFlag(!createitemflag);
    getData();
  }
  const getData = async () => {
    const url = isEmp ? urls[0] : urls[1];

    const data = await fetchData(url);
    console.log(url + " " + data);
    let newData = data.sort(function (a, b) {
      if (a?.createdAt && b?.createdAt) {
        return (
          new Date(a.createdAt).getTime() - new Date(b.createdAt).getTime()
        );
      }
      return a.itemId - b.itemId;
    });
    setEmployees(newData);
  };
  useEffect(() => {
    checkUserLogin();
  }, [isEmp]);

  return (
    <div className="table-container">
      <div>
        <div className="btn-group">
          <button
            onClick={() => setIsEmp(true)}
            className={isEmp ? "active" : ""}
          >
            Employee Data
          </button>
          <button
            onClick={() => setIsEmp(false)}
            className={!isEmp ? "active" : ""}
          >
            Item Data
          </button>
        </div>

        {isEmp && (
          <table>
            <thead>
              <tr>
                <th>Emp Id</th>
                <th> Name</th>
                {/* <th>Last Name</th> */}
                <th>Email</th>
                <th>Designation</th>
                <th>Date of Birth</th>
                <th>Date of Joining</th>
                <th>Date of Exit</th>
                <th>Location</th>
                <th>Phone Number</th>
                <th></th>+
              </tr>
            </thead>

            <tbody>
              {employees.map((emp) => (
                <tr key={emp.employeeId}>
                  <td>{emp.employeeId}</td>
                  <td>
                    {emp.firstName} {emp.lastName}
                  </td>
                  {/* <td>{emp.lastName}</td> */}
                  <td>{emp.email}</td>
                  <td>{emp.designation}</td>
                  <td>{emp.dateOfBirth}</td>
                  <td>{emp.dateOfJoining}</td>
                  <td>{emp.dateOfExit}</td>
                  <td>{emp.location}</td>
                  <td>{emp.phoneNumber}</td>
                  <td>
                    <button
                      className="update"
                      onClick={() => {
                        handleUpdate(emp);
                      }}
                    >
                      Update
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}

        {!isEmp && (
          <table>
            <thead>
              <tr>
                <th>Item Id</th>
                <th>Item Number</th>
                <th>Item Name</th>
                <th>Item Type</th>
                <th>Item Location</th>
                <th>Item Condition</th>
                <th>Item Warranty</th>
                <th>Item Assigned</th>
                <th>Date of Purchase</th>
                <th></th>
              </tr>
            </thead>

            <tbody>
              {employees.map((item, idx) => (
                <tr key={item.itemId}>
                  <td>{idx + 1}</td>
                  {/* <td>{item.itemId}</td> */}
                  <td>{item.itemNumber}</td>
                  <td>{item.itemName}</td>
                  <td>{item.itemType}</td>
                  <td>{item.itemLocation}</td>
                  <td>{item.itemCondition}</td>
                  <td>{`${item.itemWarrantyPeriod}${" years"}`}</td>
                  <td>{item.itemAssigned ? "Assigned" : "Un-Assigned"}</td>
                  <td>{item.dateOfPurchase}</td>
                  <td>
                    <button
                      className="update"
                      onClick={() => {
                        handleUpdateItem(item);
                      }}
                    >
                      Update
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>

      <div id="create-employee-div">
        {createemployeeflag && (
          <UpdateEmployee
            onUpdateEmployee={CreateEmployeeFlagFunction}
            updateEmployeeData={updateemployeerecord}
          />
        )}
      </div>
      <div id="create-employee-div">
        {createitemflag && (
          <UpdateItem
            onUpdateItem={CreateItemFlagFunction}
            updateItemData={updateitemrecord}
          />
        )}
      </div>
    </div>
  );
};

export default Dashboard;

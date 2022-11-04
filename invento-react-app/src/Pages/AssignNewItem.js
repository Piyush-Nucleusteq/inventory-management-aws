import axios from "axios";
import { useState } from "react";
import { useEffect } from "react";
import { Navigate, useParams } from "react-router-dom";
import Header from "../Component/Header/Header";
import "./AssignNewItem.css";
import { useNavigate } from "react-router-dom";
import { BASE_URL } from "../Component/Constants/apiConstants";

// const getRandomId = () => {
//   return Math.random() * 1000000;
// };

const AssignNewItem = () => {
  const navigate = useNavigate();
  const defaultAssignedData = {
    itemName: "",
    assignedDate: "",
  };

  const [itemData, setItemData] = useState([]);

  const { employeeId, employeeTableId } = useParams();
  const employeeData = JSON.parse(localStorage.getItem("userDetails"));

  const [row, setRow] = useState([
    {
      itemtableId: null,
      assignedDate: null,
      employeeTableId: parseInt(employeeTableId),
      employeeId: employeeId,
      itemReceivedAt: "Office",
    },
  ]);

  const handleChange = (type, index, value) => {
    console.log("type index value", type, index, value);
    let temp = row;
    temp[index][type] = value;
    console.log("Temp data", temp);
    setRow(temp);
  };
  const handleItemDelete = (idx) => {
    const list = [...row];
    list.splice(idx, 1);
    setRow(list);
  };
  const addMoreRow = () => {
    setRow([
      ...row,
      {
        itemtableId: null,
        assignedDate: "",
        employeeTableId: parseInt(employeeTableId),
        employeeId: employeeId,
        itemReceivedAt: "Office",
      },
    ]);
  };
  const setRowData = (rowIndex, rowKey, rowValue) => {
    let oldRow = [...row];
    oldRow[rowIndex][rowKey] = rowValue;
    setRow(oldRow);
  };
  const fetchData = async () => {
    try {
      const { data } = await axios.get(BASE_URL + "UnAssignedItem");
      console.log(data);
      setItemData(data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const handleItemAdd = async (item) => {
    let newArray = row.map((item) => ({
      ...item,
      itemtableId: Number(item.itemtableId.split("+")[0]),
    }));
    console.log("new array", newArray);
    try {
      await axios.post(BASE_URL + "AssignItem", newArray).then((res) => {
        if (res.status === 200) {
          navigate("/assignItem");
        }
        console.log("response data", res);
        fetchData();
        console.log("Success...");
      });
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <Header />

      <div className="table-container">
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
                {employeeData?.firstName} {employeeData?.lastName}
              </td>
              <td>{employeeData?.email}</td>
              <td>{employeeData?.employeeId}</td>
            </tr>
          </tbody>
        </table>
        <table>
          <thead>
            <tr>
              <th>Id</th>
              <th>Item No. with Name</th>
              <th>Date of assigned</th>
              <th></th>
            </tr>
          </thead>

          <tbody>
            {row.map((item, idx) => (
              <tr key={item.id}>
                <td>{idx + 1}</td>
                {console.log("item name is", item.itemName)}
                <td>
                  <select
                    value={item.itemtableId}
                    onChange={(e, key) => {
                      console.log("CHANGE_ ", e.target.value);
                      setRowData(idx, "itemtableId", e.target.value);
                    }}
                  >
                    <option value="">Select an Item</option>
                    {itemData.map((item) => {
                      const temp = row.find(
                        (assItem, cidx) =>
                          assItem.itemtableId == item.itemId && cidx != idx
                      );

                      if (temp) {
                        return null;
                      }

                      return (
                        <option value={item.itemId} key={item.itemId}>
                          {item.itemName}
                        </option>
                      );
                    })}
                  </select>
                </td>

                <td>
                  <input
                    type="date"
                    value={item.assignedDate}
                    onChange={(e) => {
                      setRowData(idx, "assignedDate", e.target.value);
                    }}
                  />
                </td>
                <td>
                  <button onClick={() => handleItemDelete(idx)}>Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        <td>
          <button className="add" onClick={() => addMoreRow()}>
            Add
          </button>
        </td>
      </div>
      <td>
        <button className="assign-item" onClick={() => handleItemAdd()}>
          Assign Item
        </button>
      </td>
    </div>
  );
};

export default AssignNewItem;

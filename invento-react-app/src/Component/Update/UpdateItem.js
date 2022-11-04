import axios from "axios";
import { useState } from "react";
import "./UpdateItem.css";
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

const itemTypes = ["Hardware", "Software", "Others"];

const UpdateItem = (props) => {
  const [item, setItem] = useState(props.updateItemData);
  const [formErrors, setFormErrors] = useState({});

  const setItemValue = (key, value) => {
    let newItem = { ...item };
    newItem[key] = value;
    // newItem["itemWarrantyPeriod"] = `${value}${"years"}`;
    // console.log(item);
    setItem(newItem);
  };

  // fxn to run on submit
  const onSubmit = async (e) => {
    e.preventDefault();

    // Validations
    const errors = {};

    // if (itemName.trim() === "") {
    //   errors.itemName = "Item Name is Required";
    // }
    // if (itemNumber.trim() === "") {
    //   errors.itemNumber = "Item Number is Required";
    // }
    // if (dop.trim() === "") {
    //   errors.dop = "Date Of Purchase is Required";
    // }
    // if (type.trim() === "") {
    //   errors.type = "Item Type is Required";
    // }
    // if (warranty.trim() === "") {
    //   errors.warranty = "Warranty Period is Required";
    // }
    // if (location.trim() === "") {
    //   errors.location = "Location is Required";
    // }

    setFormErrors(errors);

    // Call to api
    try {
      const { data } = await axios
        .put(BASE_URL + "item", {
          ...item,
        })
        .then((res) => {
          if (res.status === 200) {
            toast.success("Item updated successfully!", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          } else if (res.status === 302) {
            toast.error(
              "Email or employeeid or primary contact - already exist!",
              { draggable: true, position: toast.POSITION.TOP_CENTER }
            );
          } else if (res.status === 400)
            toast.error("Adding Item failed", {
              draggable: true,
              position: toast.POSITION.TOP_CENTER,
            });
          console.log(res);
        });
      console.log(data);
    } catch (error) {
      // handle error
      console.log(error);
    }

    // Do something
  };

  return (
    <>
      <div id="backdrop" onClick={props.onUpdateItem}></div>
      <div className="emp-form-container2">
        <form className="emp-form2" onSubmit={onSubmit}>
          <div className="form-group2">
            <label htmlFor="item-name">Item Name</label>
            <input
              id="item-name"
              type="text"
              placeholder="Item Name"
              value={item.itemName}
              onChange={(e) => setItemValue("itemName", e.target.value)}
            />
            <p className="errormsg2">{formErrors.itemName}</p>
          </div>

          <div className="form-group2">
            <label htmlFor="item-number" className="disable">
              Item Number
            </label>
            <input
              disabled="true"
              id="item-number"
              type="text"
              placeholder="item-number"
              value={item.itemNumber}
              onChange={(e) => setItemValue("itemNumber", e.target.value)}
            />
            {/* check validation */}
            <p className="errormsg2">{formErrors.itemNumber}</p>
          </div>

          {/* Asset Type dropdown */}
          <div className="form-group2">
            <label htmlFor="itemType">Item Type</label>
            <select
              className="select"
              id="itemType"
              style={selectStyles}
              value={item.itemType}
              onChange={(e) => setItemValue("itemType", e.target.value)}
            >
              <option value="">Select Type</option>
              {itemTypes.map((itemType) => (
                <option value={itemType}>{itemType}</option>
              ))}
            </select>
            {/* check validation */}
            <p className="errormsg2">{formErrors.itemType}</p>
          </div>

          <div className="form-group2">
            <label htmlFor="dop">Date of Purchase</label>
            <input
              id="dop"
              type="date"
              placeholder="Date of Purchase"
              value={item.dateOfPurchase}
              onChange={(e) => setItemValue("dateOfPurchase", e.target.value)}
            />
            {/* check validation */}
            <p className="errormsg2">{formErrors.dop}</p>
          </div>

          <div className="form-group2">
            <label htmlFor="warranty">Warranty Period (in years)</label>
            <input
              id="warranty"
              type="number"
              placeholder="Warranty Period"
              value={item.itemWarrantyPeriod}
              onChange={(e) =>
                setItemValue("itemWarrantyPeriod", e.target.value)
              }
            />
            {/* check validation */}
            <p className="errormsg2">{formErrors.warranty}</p>
          </div>

          <div className="form-group2">
            <label htmlFor="location">Item Location</label>
            <select
              className="select"
              id="location"
              style={selectStyles}
              value={item.itemLocation}
              onChange={(e) => setItemValue("itemLocation", e.target.value)}
            >
              <option value="">Choose Location</option>
              {locations.map((location) => (
                <option value={location}>{location}</option>
              ))}
            </select>
            {/* check validation */}
            <p className="errormsg2">{formErrors.location}</p>
          </div>

          <button className="button" style={buttonStyles}>
            Update
          </button>
          <ToastContainer />
        </form>
      </div>
    </>
  );
};

export default UpdateItem;

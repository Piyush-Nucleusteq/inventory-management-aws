import axios from "axios";
import { useState } from "react";
import "./ItemForm.css";
import { ToastContainer, toast } from "react-toastify";
import { BASE_URL } from "../Constants/apiConstants";
import "react-toastify/dist/ReactToastify.css";
import { useEffect } from "react";

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

const ItemForm = () => {
  const [itemName, setItemName] = useState("");
  const [itemNumber, setItemNumber] = useState("");
  const [warranty, setWarranty] = useState("");
  const [type, setType] = useState("");
  const [dop, setDop] = useState("");
  const [location, setLocation] = useState("");
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

    if (itemName.trim() === "") {
      errors.itemName = "Item Name is Required";
    }
    if (itemNumber.trim() === "") {
      errors.itemNumber = "Item Number is Required";
    }
    if (dop.trim() === "") {
      errors.dop = "Date Of Purchase is Required";
    }
    if (type.trim() === "") {
      errors.type = "Item Type is Required";
    }
    if (warranty.trim() === "") {
      errors.warranty = "Warranty Period is Required";
    }
    if (location.trim() === "") {
      errors.location = "Location is Required";
    }
    if (Object.keys(errors).length === 0) {
      isValid = true;
    }
    setFormErrors(errors);

    if (isValid) {
      setIsSubmit(true);
      try {
        const { data } = await axios
          .post(BASE_URL + "item", {
            itemName: itemName,
            itemNumber: itemNumber,
            itemLocation: location,
            dateOfPurchase: dop,
            itemWarrantyPeriod: warranty,
            itemAssigned: "Un-Assigned",
            itemCondition: "Working",
            itemType: type,
          })
          .then((res) => {
            if (res.status === 200) {
              toast.success("Item addded successfully!", {
                draggable: true,
                position: toast.POSITION.TOP_CENTER,
              });
              setFormErrors({});
              setItemName("");
              setItemNumber("");
              setLocation("");
              setDop("");
              setWarranty("");
              setType("");
            }

            console.log(res);
          });
        console.log(data);
      } catch (error) {
        if (error.status === 500)
          toast.error("Adding item failed", {
            draggable: true,
            position: toast.POSITION.TOP_CENTER,
          });
        console.log(error);
      }
    }
  };

  return (
    <div className="emp-form-container11">
      <form className="emp-form11" onSubmit={onSubmit}>
        <div className="form-group11">
          <label htmlFor="item-name">Item Name</label>
          <input
            id="item-name"
            type="text"
            placeholder="Item Name"
            value={itemName}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                itemName: "",
              });
              setItemName(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.itemName}</p>
        </div>

        <div className="form-group11">
          <label htmlFor="item-number">Item Number</label>
          <input
            id="item-number"
            type="text"
            placeholder="item-number"
            value={itemNumber}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                itemNumber: "",
              });
              setItemNumber(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.itemNumber}</p>
        </div>

        <div className="form-group11">
          <label htmlFor="type">Item Type</label>
          <select
            className="select"
            id="type"
            style={selectStyles}
            value={type}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                type: "",
              });
              setType(e.target.value);
            }}
          >
            <option value="">Select Type</option>
            {itemTypes.map((itemType) => (
              <option value={itemType}>{itemType}</option>
            ))}
          </select>
          <p className="errormsg2">{formErrors.type}</p>
        </div>

        <div className="form-group11">
          <label htmlFor="dop">Date of Purchase</label>
          <input
            id="dop"
            type="date"
            placeholder="Date of Purchase"
            value={dop}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                dop: "",
              });
              setDop(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.dop}</p>
        </div>

        <div className="form-group11">
          <label htmlFor="warranty">Warranty Period</label>
          <input
            id="warranty"
            type="number"
            placeholder="Warranty Period"
            value={warranty}
            onChange={(e) => {
              setFormErrors({
                ...formErrors,
                warranty: "",
              });
              setWarranty(e.target.value);
            }}
          />
          <p className="errormsg2">{formErrors.warranty}</p>
        </div>

        <div className="form-group11">
          <label htmlFor="location">Item Location</label>
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
        <button className="button" style={buttonStyles}>
          Submit
        </button>
        <ToastContainer />
      </form>
    </div>
  );
};

export default ItemForm;

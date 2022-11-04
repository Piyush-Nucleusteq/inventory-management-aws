package com.capstone.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author Assign Item Dto Out.
 *
 */
public final class AssignItemDtoOut {
    /**
     * stores id.
     */
    private int id;
    /**
     * stores first name.
     */
    private String firstName;
    /**
     * stores last name.
     */
    private String lastName;
    /**
     * stores email.
     */
    private String email;
    /**
     * stores employee id.
     */
    private String employeeId;
    /**
     * stores employee table id.
     */
    private int employeeTableId;
    /**
     * stores item table id.
     */
    private int itemTableId;
    /**
     * stores item number.
     */
    private String itemNumber;
    /**
     * stores item name.
     */
    private String itemName;
    /**
     * stores date of assigned.
     */
    private String dateOfAssigned;
    /**
     * stores item condition.
     */
    private String itemCondition;
    /**
     * stores incidents if any.
     */
    private String incidentsIfAny;
    /**
     * @return id.
     */
    public int getId() {
        return id;
    }
    /**
     * @param id : id.
     */
    public void setId(final int id) {
        this.id = id;
    }
    /**
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName : first name.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName : last name.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email : email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    /**
     * @return employee id.
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId : employee id.
     */
    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }
    /**
     * @return employee table id.
     */
    public int getEmployeeTableId() {
        return employeeTableId;
    }
    /**
     * @param employeeTableId : employee table id.
     */
    public void setEmployeeTableId(final int employeeTableId) {
        this.employeeTableId = employeeTableId;
    }
    /**
     * hash code method.
     */
    @Override
    public int hashCode() {
         return Objects.hash(dateOfAssigned, email, employeeId,
                employeeTableId, firstName, id, incidentsIfAny,
                itemCondition, itemName, itemNumber, itemTableId,
                lastName);
    }
    /**
     * equals method.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        AssignItemDtoOut other = (AssignItemDtoOut) obj;
        return Objects.equals(dateOfAssigned, other.dateOfAssigned)
                && Objects.equals(email, other.email)
                && Objects.equals(employeeId, other.employeeId)
                && employeeTableId == other.employeeTableId
                && Objects.equals(firstName, other.firstName)
                && id == other.id
                && Objects.equals(incidentsIfAny, other.incidentsIfAny)
                && Objects.equals(itemCondition, other.itemCondition)
                && Objects.equals(itemName, other.itemName)
                && Objects.equals(itemNumber, other.itemNumber)
                && itemTableId == other.itemTableId
                && Objects.equals(lastName, other.lastName);
    }
    /**
     * @return item table id.
     */
    public int getItemTableId() {
        return itemTableId;
    }
    /**
     * @param itemTableId : item table id.
     */
    public void setItemTableId(final int itemTableId) {
        this.itemTableId = itemTableId;
    }
    /**
     * @return item number.
     */
    public String getItemNumber() {
        return itemNumber;
    }
    /**
     * @param itemNumber : item number.
     */
    public void setItemNumber(final String itemNumber) {
        this.itemNumber = itemNumber;
    }
   /**
    * @return item name.
    */
    public String getItemName() {
        return itemName;
    }
    /**
     * @param itemName : item name.
     */
    public void setItemName(final String itemName) {
         this.itemName = itemName;
    }
    /**
     * @return date of assigned.
     */
    public String getDateOfAssigned() {
        return dateOfAssigned;
    }
    /**
     * @param dateOfAssigned : date of assigned.
     */
    public void setDateOfAssigned(final String dateOfAssigned) {
        this.dateOfAssigned = dateOfAssigned;
    }
    /**
     * @return item location.
     */
    public String getItemCondition() {
        return itemCondition;
    }
    /**
     * @param itemCondition : item location.
     */
    public void setItemCondition(final String itemCondition) {
        this.itemCondition = itemCondition;
    }
    /**
     * @return incidents if any.
     */
    public String getIncidentsIfAny() {
        return incidentsIfAny;
    }
    /**
     * @param incidentsIfAny : incidents if any.
     */
    public void setIncidentsIfAny(final String incidentsIfAny) {
        this.incidentsIfAny = incidentsIfAny;
    }
    /**
     * to string method.
     */
    @Override
    public String toString() {
        return "AssignItemDtoOut [id=" + id + ", firstName=" + firstName + ","
                + " lastName=" + lastName + ", email=" + email + ","
                + " employeeId=" + employeeId + ","
                + " employeeTableId=" + employeeTableId + ","
                + " itemTableId=" + itemTableId
                + ", itemNumber=" + itemNumber + ", itemName=" + itemName + ","
                + " dateOfAssigned=" + dateOfAssigned
                + ", itemCondition=" + itemCondition + ","
                + " incidentsIfAny=" + incidentsIfAny + "]";
    }
}

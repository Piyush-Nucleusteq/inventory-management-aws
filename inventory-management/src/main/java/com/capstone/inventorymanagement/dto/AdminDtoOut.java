package com.capstone.inventorymanagement.dto;
import java.util.Objects;
/**
 * @author Admin dto out for response.
 *
 */
public final class AdminDtoOut {
    /**
     * employee message.
     */
    private String employeeMessage;
    /**
     * @return get employee message.
     */
    public String getEmployeeMessage() {
        return employeeMessage;
    }
    /**
     * @param employeeMessage : employee message.
     */
    public void setEmployeeMessage(final String employeeMessage) {
       this.employeeMessage = employeeMessage;
    }
    /**
     * to string.
     */
    @Override
    public String toString() {
        return "adminDtoOut [employeeMessage=" + employeeMessage + "]";
    }
    /**
     * hash code method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(employeeMessage);
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
        AdminDtoOut other = (AdminDtoOut) obj;
        return Objects.equals(employeeMessage, other.employeeMessage);
    }
}

package com.capstone.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author piyush
 *
 */
public final class LoginDtoOut {
    /**
     * role.
     */
    private String role;
    /**
     * first Name.
     */
    private String firstName;
    /**
     * employee id.
     */
    private String employeeId;
    /**
     * first login.
     */
    private boolean firstLogin;
    /**
     * @return status if first login
     */
    public boolean isFirstLogin() {
        return firstLogin;
    }
    /**
     * @param firstLogin : first login.
     */
    public void setFirstLogin(final boolean firstLogin) {
       this.firstLogin = firstLogin;
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
     * @return role.
     */
    public String getRole() {
         return role;
    }
    /**
     * @param role : role of given user.
     */
    public void setRole(final String role) {
        this.role = role;
    }
    /**
     * @return first name.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName : first name of given email.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }
    /**
     * @param role : role.
     * @param firstName : first name.
     */
    public LoginDtoOut(final String role, final String firstName) {
        super();
        this.role = role;
        this.firstName = firstName;
    }
    /**
     * constructor without fields.
     */
    public LoginDtoOut() {
        super();
    }
    /**
     * hash code method for loginDdtoOut.
     */
   @Override
     public int hashCode() {
         return Objects.hash(firstName, role);
    }
    /**
     * equals mehtod for loginDdtoOut.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
            }
        if  (getClass() != obj.getClass()) {
            return false;
            }
        LoginDtoOut other = (LoginDtoOut) obj;
        return Objects.equals(firstName, other.firstName)
                  && Objects.equals(role, other.role);
    }
    /**
     * to string method for LoginDtoOut.
     */
    @Override
    public String toString() {
        return "LoginDtoOut [role=" + role + ", firstName=" + firstName + "]";
    }
}

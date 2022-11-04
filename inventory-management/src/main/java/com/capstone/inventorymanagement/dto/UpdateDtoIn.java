package com.capstone.inventorymanagement.dto;

import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * @author piyush
 *
 */
public final class UpdateDtoIn {
    /**
     * stores role of user.
     */
    private String role;
    /**
     * stores first name.
     */
    @NotEmpty
    private String firstName;
    /**
     * stores last name.
     */
    @NotEmpty
    private String lastName;
   /**
    * store date of birth.
    */
    @NotEmpty
   private String dateOfBirth;
   /**
    * stores password.
    */
   @NotEmpty(message = "Password cannot be empty")
   private String password;
    /**
     * stores designation.
     */
   @NotEmpty
    private String designation;
    /**
     * stores date of joining.
     */
   @NotEmpty
    private String dateOfJoining;
    /**
     * stores user id.
     */
    private Integer userId;
    /**
     * stores date of exit.
     */
    private String dateOfExit;
    /**
     * stores location.
     */
    @NotEmpty
    @NotNull
    private String location;
    /**
     * @return date of exit.
     */
    public String getDateOfExit() {
         return dateOfExit;
    }
    /**
     * @param dateOfExit : date of exit.
     */
    public void setDateOfExit(final String dateOfExit) {
        this.dateOfExit = dateOfExit;
    }
    /**
     * @return location.
     */
    public String getLocation() {
        return location;
    }
    /**
     * @param location : location.
     */
    public void setLocation(final String location) {
        this.location = location;
    }
    /**
     * @return user id.
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * @param userId : gives the user id.
     */
    public  void setUserId(final Integer userId) {
        this.userId = userId;
    }
    /**
    * @return role.
     */
    public String getRole() {
         return role;
    }
    /**
     * @param role : gives role of user.
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
     * @param firstName : first name of user.
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
     * @param lastName : last name of user.
    */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }
    /**
     * @return date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * @param dateOfBirth : date of birth of user.
     */
    public  void setDateOfBirth(final String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
   /**
    * @return password.
     */
   public  String getPassword() {
       return password;
   }
    /**
    * @param password : password of user.
     */
    public  void setPassword(final String password) {
        this.password = password;
    }
    /**
     * @return designation.
     */
    public  String getDesignation() {
        return designation;
    }
    /**
     * @param designation : designation of user.
     */
    public  void setDesignation(final String designation) {
        this.designation = designation;
    }
    /**
     * @return date of joining.
     */
    public String getDateOfJoining() {
        return dateOfJoining;
    }
    /**
     * @param dateOfJoining : date of joining of user.
     */
    public  void setDateOfJoining(final String dateOfJoining) {
         this.dateOfJoining = dateOfJoining;
    }
   /**
     * no agrs constructor of user class.
    */
    public UpdateDtoIn() {
    super();
    }
    /**
     * @param userId : user id.
     * @param role : role of user.
     * @param firstName : first name of user.
     * @param lastName : last name of user.
     * @param dateOfBirth : date of birth of user.
     * @param password : password of user.
     * @param designation : designation of user.
     * @param dateOfJoining : date of joining of user.
     * @param dateOfExit : date of exit of user.
     * @param location : location of user.
     */
    public UpdateDtoIn(final Integer userId,
    final String role,
    final String firstName,
    final String lastName,
    final String dateOfBirth,
    final String password,
    final String designation,
    final String dateOfJoining,
    final String dateOfExit,
    final String location) {
    super();
    this.userId = userId;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.password = password;
    this.designation = designation;
    this.dateOfJoining = dateOfJoining;
    this.dateOfExit = dateOfExit;
    this.location = location;
}
    /**
     * toString method of user.
     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ","
    + ", role=" + role + ","
    + " firstName=" + firstName
    + ", lastName=" + lastName + ","
    + " dateOfBirth=" + dateOfBirth
    + " password=" + password + ","
    + " designation=" + designation + ","
    + " dateOfJoining=" + dateOfJoining + "]";
 }
    /**
     * hashcode method of user class.
     */
    @Override
     public int hashCode() {
        return Objects.hash(dateOfBirth,
        dateOfJoining, designation,
        firstName,
        lastName, password,
         role, userId, dateOfExit, location);
    }
    /**
     * equals method of user.
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
        UpdateDtoIn other = (UpdateDtoIn) obj;
        return Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(dateOfJoining,
                other.dateOfJoining)
                && Objects.equals(designation,
                other.designation)
                && Objects.equals(firstName,
                other.firstName)
                && Objects.equals(lastName,
                other.lastName)
                && Objects.equals(password,
                other.password)
                && Objects.equals(role,
                other.role)
                && Objects.equals(userId,
                other.userId)
                && Objects.equals(dateOfExit,
                        other.dateOfExit)
                && Objects.equals(location,
                        other.location);
    }
}

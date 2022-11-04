package com.capstone.inventorymanagement.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author piyush
 *
 */
@Entity
@Table(name = "user_detail")
public final class User {
    /**
     * stores id and works as primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    /**
     * stores employee id.
    */
    @Column(name = "employee_id", unique = true)
    private String employeeId;
    /**
     * stores role of user.
     */
    @Column(name = "role")
    private String role;
    /**
     * stores first name.
     */
    @Column(name = "first_name")
    private String firstName;
    /**
     * stores last name.
     */
    @Column(name = "last_name")
    private String lastName;
    /**
    * stores email.
     */
   @Column(name = "email", unique = true)
   private String email;
   /**
    * store date of birth.
    */
   @Column(name = "date_of_birth")
   private String dateOfBirth;
   /**
    * stores phone number.
    */
   @Column(name = "phone_number", unique = true)
   private String phoneNumber;
   /**
    * stores password.
    */
    @Column(name = "password")
    private String password;
    /**
     * stores designation.
     */
    @Column(name = "designation")
    private String designation;
    /**
     * stores date of joining.
     */
    @Column(name = "date_of_joining")
    private String dateOfJoining;
    /**
     * stores date of exit.
     */
    @Column(name = "date_of_exit")
    private String dateOfExit;
    /**
     * stores location.
     */
    @Column(name = "location")
    private String location;
    /**
     *  stores created time.
     */
    @Column(name = "created_at")
    private String createdAt;
    /**
     * stores updated time.
     */
    @Column(name = "updated_at")
    private String updatedAt;
    /**
     * first login.
     */
    @Column(name = "first_login")
    private boolean firstLogin;
    /**
     * @return created time.
     */
    public String getCreatedAt() {
        return createdAt;
    }
    /**
     * @param createdAt : created time.
     */
    public void setCreatedAt(final String createdAt) {
        this.createdAt = createdAt;
    }
    /**
     * @return updated time.
     */
    public String getUpdatedAt() {
        return updatedAt;
    }
    /**
     * @param updatedAt : updated time.
     */
    public void setUpdatedAt(final String updatedAt) {
         this.updatedAt = updatedAt;
    }
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
     * @return employee id.
     */
    public String getEmployeeId() {
        return employeeId;
    }
    /**
     * @param employeeId : gives employee id.
     */
    public void setEmployeeId(final String employeeId) {
         this.employeeId = employeeId;
    }
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
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email : email of user.
     */
    public void setEmail(final String email) {
        this.email = email;
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
     * @return phone number.
     */
    public String getPhoneNumber() {
         return phoneNumber;
    }
    /**
     * @param phoneNumber : phone number of user.
     */
   public void setPhoneNumber(final String phoneNumber) {
         this.phoneNumber = phoneNumber;
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
    public User() {
    super();
    }
    /**
     * @param userId : user id.
     * @param employeeId : employee id
     * @param role : role of user.
     * @param firstName : first name of user.
     * @param lastName : last name of user.
     * @param email : email of user.
     * @param dateOfBirth : date of birth of user.
     * @param phoneNumber : phone number of user.
     * @param password : password of user.
     * @param designation : designation of user.
     * @param dateOfJoining : date of joining of user.
     * @param dateOfExit : date of exit of user.
     * @param location : location of user.
     * @param createdAt : created time.
     * @param updatedAt : updated time of user.
     * @param firstLogin : first login.
     */
    public User(final Integer userId,
    final String employeeId,
    final String role,
    final String firstName,
    final String lastName,
    final String email,
    final String dateOfBirth,
    final String phoneNumber,
    final String password,
    final String designation,
    final String dateOfJoining,
    final String dateOfExit,
    final String location,
    final String updatedAt,
    final String createdAt,
    final boolean firstLogin) {
    super();
    this.userId = userId;
    this.employeeId = employeeId;
    this.role = role;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
    this.password = password;
    this.designation = designation;
    this.dateOfJoining = dateOfJoining;
    this.dateOfExit = dateOfExit;
    this.location = location;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.firstLogin = firstLogin;
}
    /**
     * toString method of user.
     */
    @Override
    public String toString() {
        return "User [userId=" + userId + ","
    + " employeeId=" + employeeId
    + ", role=" + role + ","
    + " firstName=" + firstName
    + ", lastName=" + lastName + ","
    + " email=" + email + ","
    + " dateOfBirth=" + dateOfBirth
    + " phoneNumber=" + phoneNumber + ","
    + " password=" + password + ","
    + " designation=" + designation + ","
    + " firstLogin=" + firstLogin
    + " dateOfJoining=" + dateOfJoining + "]";
 }
    @Override
    public int hashCode() {
        return Objects.hash(createdAt, dateOfBirth,
                dateOfExit, dateOfJoining,
                designation, email, employeeId,
                firstLogin, firstName,
                lastName, location, password,
                phoneNumber, role, updatedAt, userId);
    }
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
        User other = (User) obj;
        return Objects.equals(createdAt, other.createdAt)
                && Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(dateOfExit, other.dateOfExit)
                && Objects.equals(dateOfJoining, other.dateOfJoining)
                && Objects.equals(designation, other.designation)
                && Objects.equals(email, other.email)
                && Objects.equals(employeeId, other.employeeId)
                && firstLogin == other.firstLogin
                && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName)
                && Objects.equals(location, other.location)
                && Objects.equals(password, other.password)
                && Objects.equals(phoneNumber, other.phoneNumber)
                && Objects.equals(role, other.role)
                && Objects.equals(updatedAt, other.updatedAt)
                && Objects.equals(userId, other.userId);
    }
}

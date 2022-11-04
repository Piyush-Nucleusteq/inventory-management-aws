package com.capstone.inventorymanagement.dto;

import java.util.Objects;

/**
 * @author piyush
 *
 */
public final class LoginDtoIn {
     /**
     * email.
     */
    private String email;
    /**
     * password.
     */
    private String password;
    /**
     * @return email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * @param email : set email.
     */
    public void setEmail(final String email) {
        this.email = email;
    }
    /**
     * @return password.
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param password : set password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }
    /**
     * @param email email of logined user.
     * @param password : password of logined user.
     */
    public LoginDtoIn(final String email, final String password) {
        super();
        this.email = email;
        this.password = password;
    }
    /**
     * to string method.
     */
    @Override
    public String toString() {
           return "LoginDtoIn [email=" + email + ","
                  + " password=" + password + "]";
    }
    /**
     * Constructor withoout feilds.
     */
    public LoginDtoIn() {
          super();
    }
    /**
     * hash code method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(email, password);
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
        LoginDtoIn other = (LoginDtoIn) obj;
        return Objects.equals(email, other.email)
              && Objects.equals(password, other.password);
    }
}

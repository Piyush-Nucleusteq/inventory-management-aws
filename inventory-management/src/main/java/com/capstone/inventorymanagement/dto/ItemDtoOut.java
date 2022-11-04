package com.capstone.inventorymanagement.dto;

import java.util.Objects;
/**
 * @author piyush
 *
 */
public final class ItemDtoOut {
    /**
     * stores message.
     */
    private String message;
    /**
     * @return message.
     */
    public String getMessage() {
        return message;
    }
    /**
     * @param message : set message.
     */
    public void setMessage(final String message) {
        this.message = message;
    }
    /**
     * to string method.
     */
    @Override
    public String toString() {
        return "ItemDtoOut [message=" + message + "]";
    }
    /**
     * hash code method.
     */
    @Override
    public int hashCode() {
        return Objects.hash(message);
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
        ItemDtoOut other = (ItemDtoOut) obj;
        return Objects.equals(message, other.message);
    }
}

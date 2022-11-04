package com.capstone.inventorymanagement.exception;

/**
 * @author Piyush
 *
 */
public class NotFoundException extends Exception {
    /**
     *  serial id.
     */
    private static final long serialVersionUID = 3183679764162247369L;
    /**
     * @param message of not found exception.
     */
    public NotFoundException(final String message) {
        super(message);
    }
}

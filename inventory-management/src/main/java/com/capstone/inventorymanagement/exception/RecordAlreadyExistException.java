package com.capstone.inventorymanagement.exception;

/**
 * @author Piyush
 *
 */
public class RecordAlreadyExistException extends Exception {
    /**
     * serial version id.
     */
    private static final long serialVersionUID = 5233817019019737233L;
    /**
     * @param message to be passed.
     */
    public RecordAlreadyExistException(final String message) {
        super(message);
    }
}

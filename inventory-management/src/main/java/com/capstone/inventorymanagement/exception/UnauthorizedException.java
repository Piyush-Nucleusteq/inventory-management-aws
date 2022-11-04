package com.capstone.inventorymanagement.exception;
/**
 * @author Piyush
 *
 */
public final class UnauthorizedException extends Exception {
    /**
     * serial id.
     */
    private static final long serialVersionUID = -5777625449713351594L;
    /**
     * @param message of unauthorized exception.
     */
    public UnauthorizedException(final String message) {
        super(message);
    }
}

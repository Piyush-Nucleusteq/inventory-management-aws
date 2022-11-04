package com.capstone.inventorymanagement.exception;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capstone.inventorymanagement.customannotation.Generated;
import com.capstone.inventorymanagement.domain.ErrorResponse;

/**
 * @author global exception handler.
 */
@Generated
@ControllerAdvice
public final class GlobalExceptionHandler {
    /**
     * error code.
     */
    public static final int ERRORCODE = 400;
    /**
     * @param ex exception thrown from services.
     * @return Message - Unauthorized exception.
     */
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorResponse>
    handelInvalidCredentialsException(final UnauthorizedException ex) {
           List<String> messageList = new ArrayList<String>();
           messageList.add(ex.getMessage());
           ErrorResponse errorResponse = new ErrorResponse(HttpStatus
                   .UNAUTHORIZED.value(), messageList);
           return new ResponseEntity<ErrorResponse>(errorResponse,
                   HttpStatus.UNAUTHORIZED);
    }
    /**
     * @param recordAlreadyExistException for existing record
     * @return message
     */
    @ResponseStatus(code = HttpStatus.CONFLICT)
    @ExceptionHandler(RecordAlreadyExistException.class)
    public ResponseEntity<ErrorResponse>
    handelRecordAlreadyExistException(
            final RecordAlreadyExistException recordAlreadyExistException) {
        List<String> messageList = new ArrayList<String>();
        messageList.add(recordAlreadyExistException.getMessage());
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.CONFLICT.value(), messageList);
        return new ResponseEntity<ErrorResponse>(
                errorResponse, HttpStatus.CONFLICT);
    }
    /**
     * @param ex exception thrown from services.
     * @return Message - Not found exception.
     */
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse>
    handleNotFoundException(final NotFoundException ex) {
           List<String> messageList = new ArrayList<String>();
           messageList.add(ex.getMessage());
           ErrorResponse errorResponse = new ErrorResponse(HttpStatus
                   .NOT_FOUND.value(), messageList);
           return new ResponseEntity<ErrorResponse>(errorResponse,
                   HttpStatus.NOT_FOUND);
    }
}

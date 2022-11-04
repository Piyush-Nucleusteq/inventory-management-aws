package com.capstone.inventorymanagement.domain;
import java.util.List;
import java.util.Objects;
/**
 * @author Error Response class.
 *
 */
public class ErrorResponse {
    /**
     * status code.
     */
    private Integer status;
    /**
     * error message.
     */
    private List<String> messages;
    /**
     * @return status code.
     */
    public final Integer getStatus() {
        return status;
    }
    /**
     * @param status code.
     */
    public final void setStatus(final Integer status) {
        this.status = status;
    }
    /**
     * @return message.
     */
    public final List<String> getMessages() {
        return messages;
    }
    /**
     * @param messages of error.
     */
    public final void setMessages(final List<String> messages) {
        this.messages = messages;
    }
    /**
     * @param status code.
     * @param messages of error.
     */
    public ErrorResponse(final Integer status, final List<String> messages) {
        super();
        this.status = status;
        this.messages = messages;
    }
    /**
     * hascode.
     */
    @Override
    public final int hashCode() {
        return Objects.hash(messages, status);
    }
    /**
     * equals.
     */
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ErrorResponse other = (ErrorResponse) obj;
        return Objects.equals(messages, other.messages)
                && Objects.equals(status, other.status);
    }
}

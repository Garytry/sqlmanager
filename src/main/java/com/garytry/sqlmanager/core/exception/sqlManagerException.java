package com.garytry.sqlmanager.core.exception;

/**
 * @Description:
 * @Author gengds
 * @Date 2019/9/13
 * @Version V1.0
 */
public class sqlManagerException extends RuntimeException {
    /**
     * Creates a new FlywayException with this message and this cause.
     *
     * @param message The exception message.
     * @param cause   The exception cause.
     */
    public sqlManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a new FlywayException with this cause. For use in subclasses that override getMessage().
     *
     * @param cause   The exception cause.
     */
    public sqlManagerException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new FlywayException with this message.
     *
     * @param message The exception message.
     */
    public sqlManagerException(String message) {
        super(message);
    }

    /**
     * Creates a new FlywayException. For use in subclasses that override getMessage().
     */
    public sqlManagerException() {
        super();
    }
}
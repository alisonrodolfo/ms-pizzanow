package com.restaurante.custumerservice.exception;

import java.util.Date;

/**
 * The type Error details.
 *
 * @author https ://github.com/alisonrodolfo
 */
public class ErrorDetails {
    /* Created by Alison on 28/02/2022 */

    private Date timestamp;
    private String message;
    private String details;

    /**
     * Instantiates a new Error details.
     *
     * @param timestamp the timestamp
     * @param message   the message
     * @param details   the details
     */
    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets details.
     *
     * @return the details
     */
    public String getDetails() {
        return details;
    }
}

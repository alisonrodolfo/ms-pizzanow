package com.restaurante.orderservice.exception;

import java.util.Date;

/**
 * @author https://github.com/alisonrodolfo
 */
public class ErrorDetails {
    /* Created by Alison on 28/02/2022 */

    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

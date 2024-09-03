package com.spring.app.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ErrorDetails {
    private String status;
    private Date timestamp;
    private String message;
    private String details;
}

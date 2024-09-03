package com.spring.app.exceptions;

import lombok.Data;
import org.springframework.boot.info.JavaInfo;

@Data
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

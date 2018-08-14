/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.handler;

import com.devdojo.springboot.error.ResourceNotFoundDetails;
import com.devdojo.springboot.error.ResourceNotFoundException;
import com.devdojo.springboot.error.ValidationErrorDetails;
import java.util.Date;
import javax.management.RuntimeErrorException;
import jdk.Exported;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

/**
 *
 * @author rodrigo.muniz
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ResourceNotFoundDetails details = new ResourceNotFoundDetails(
                "Resource not found",
                HttpStatus.NOT_FOUND.value(),
                "Details",
                new Date().getTime(),
                ex.getMessage()
        );
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ValidationErrorDetails details = new ValidationErrorDetails(
                ex.getBindingResult().getFieldError().getField(),
                ex.getBindingResult().getFieldError().getDefaultMessage(),
                "Resource not found",
                status.value(),
                "Details",
                new Date().getTime(),
                ex.getMessage()
        );
        return new ResponseEntity<>(details, headers, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ValidationErrorDetails details = new ValidationErrorDetails(
                null,
                null,
                "Internal Exception",
                status.value(),
                ex.getMessage(),
                new Date().getTime(),
                "Developer Message"
        );

        return new ResponseEntity<>(details, headers, status);
    }
}

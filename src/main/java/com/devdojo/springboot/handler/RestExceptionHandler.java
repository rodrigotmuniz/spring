/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.handler;

import com.devdojo.springboot.error.ResourceNotFoundDetails;
import com.devdojo.springboot.error.ResourceNotFoundException;
import java.util.Date;
import jdk.Exported;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author rodrigo.muniz
 */
@ControllerAdvice
public class RestExceptionHandler {

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
}

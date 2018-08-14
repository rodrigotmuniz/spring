/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.error;

/**
 *
 * @author rodrigo.muniz
 */
public class ValidationErrorDetails extends ErrorDetails {
    
    private String field;
    private String fieldMessage;

    public ValidationErrorDetails() {
    }

    public ValidationErrorDetails(
            String field, String fieldMessage, String title, int status, String details, long timestamp, String developerMessage) {
        super(title, status, details, timestamp, developerMessage);
        this.field = field;
        this.fieldMessage = fieldMessage;
    }
    
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }
    
    
    
    
    
}

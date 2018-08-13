/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.error;

/**
 *
 * @author Rodrigo Muniz
 */
public class ErrorMessage {
    
    private String errorMessage;

    public ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    
    
}

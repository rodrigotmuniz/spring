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
public class ResourceNotFoundDetails extends ErrorDetails{

    public ResourceNotFoundDetails() {
    }

    public ResourceNotFoundDetails(String title, int status, String details, long timestamp, String developerMessage) {
        super(title, status, details, timestamp, developerMessage);
    }
    
    
     
}

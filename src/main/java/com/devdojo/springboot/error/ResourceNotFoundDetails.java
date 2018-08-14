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
public class ResourceNotFoundDetails {
    private String title;
    private int status;
    private String details;
    private long timestamp;
    private String developerMessage;

    public ResourceNotFoundDetails() {
    }

    public ResourceNotFoundDetails(String title, int status, String details, long timestamp, String developerMessage) {
        this.title = title;
        this.status = status;
        this.details = details;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }
    
    
}

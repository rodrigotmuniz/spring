/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.handler;

import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.UnknownHttpStatusCodeException;

/**
 *
 * @author rodrigo.muniz
 */
public class RestResponseExceptionHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        System.out.println("Inside hasError");
        HttpStatus statusCode = HttpStatus.resolve(response.getRawStatusCode());
        return (statusCode != null && hasError(statusCode));
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("Inside handleError - Status Code: " + response.getRawStatusCode());
        System.out.println("Inside handleError - Status Code: " + IOUtils.toString(response.getBody(), "UTF-8"));
//        super.handleError(response);
    }
}

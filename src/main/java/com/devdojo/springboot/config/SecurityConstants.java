/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.config;

/**
 *
 * @author Rodrigo Muniz
 */
public class SecurityConstants {
    
    public static final String SECRET = "SecretString";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final Long EXPIRATION_TIME = 86400000L;
    
}

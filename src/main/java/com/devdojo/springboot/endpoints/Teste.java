/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.endpoints;

import com.devdojo.springboot.models.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author rodrigo.muniz
 */
public class Teste {
    
    public void teste() throws Exception {
        throw new Exception();
    }
    
    public static void JsonPropertyTest(@JsonProperty("email") String email) {
        System.out.println(email);
    }
}

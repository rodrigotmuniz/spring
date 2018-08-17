/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.endpoints;

import com.devdojo.springboot.models.Student;
import com.devdojo.springboot.repository.StudentRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rodrigo.muniz
 */
public class Teste {
    
    @Autowired
    private StudentRepository repository;
    
    public void teste() throws Exception {
        throw new Exception();
    }
    
    public static void JsonPropertyTest(@JsonProperty("email") String email) {
        System.out.println(email);
    }
    
    public static void main(String[] args) {
//        Student a = new Student("a", "a@a.com");
//        a.setStudent(new Student("b", "b@b.com"));
//        System.out.println(a.getStudent().getName());
//        teste1(a);
//        System.out.println(a.getStudent().getName());
//        teste2(a);
//        System.out.println(a.getStudent().getName());
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

/**
 *
 * @author Rodrigo Muniz
 */
@Entity
public class Student extends AbstractEntity{
    private String name;

    public Student() {
    }

    public Student(String name, Long id) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
    

    
    
    
}

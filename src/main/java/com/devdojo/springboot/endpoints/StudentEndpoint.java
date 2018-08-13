/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.endpoints;

import com.devdojo.springboot.error.ErrorMessage;
import com.devdojo.springboot.models.Student;
import com.devdojo.springboot.repository.StudentRepository;
import com.devdojo.springboot.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodrigo Muniz
 */
@RestController
@RequestMapping("students")
public class StudentEndpoint { 

    @Autowired
    private DataUtil dataUtil;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<?> listAll() {
          return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    
//    @GetMapping(path = "/{id}")
//    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
//        Student student = studentRepository.findById(id);
//        if (student == null) {
//            return new ResponseEntity<>(new ErrorMessage("Deu ruim"), HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
    
//    @PostMapping
//    public ResponseEntity<?> postStudent(@RequestBody Student student) {
//        List<Student> list = Student.getStudentList();
//        int index = list.size() + 1;
//        student.setId(index);
//        list.add(student);
//        Student.setStudentList(list); 
//        return new ResponseEntity<>(student, HttpStatus.CREATED);   
//    } 
}

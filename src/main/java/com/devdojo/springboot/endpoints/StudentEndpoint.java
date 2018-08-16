/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.endpoints;

import com.devdojo.springboot.error.ErrorMessage;
import com.devdojo.springboot.error.ResourceNotFoundException;
import com.devdojo.springboot.models.Student;
import com.devdojo.springboot.repository.StudentRepository;
import com.devdojo.springboot.utils.DataUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author Rodrigo Muniz
 */
@RestController
@RequestMapping("v1")
public class StudentEndpoint {

    @Autowired
    private DataUtil dataUtil;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("user/students")
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(studentRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("user/students/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
        System.out.println(userDetails);
        Optional<Student> obj = studentRepository.findById(id);
        if (obj.isPresent()) {
            return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Student not found. Id: " + id);

    }

    @GetMapping("user/students/name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(studentRepository.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping("admin/students")
    @Transactional(rollbackFor = Exception.class)
//    @Transactional
    public ResponseEntity<?> save(@RequestBody Student student) throws Exception {
//        studentRepository.save(student);
//        throw new IndexOutOfBoundsException();
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @PutMapping("admin/students")
    public ResponseEntity<?> update(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping("admin/students/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        studentRepository.delete(new Student(id, null, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    
}

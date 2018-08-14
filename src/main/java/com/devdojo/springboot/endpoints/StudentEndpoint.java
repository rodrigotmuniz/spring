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
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("students")
public class StudentEndpoint {

    @Autowired
    private DataUtil dataUtil;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable) {
        return new ResponseEntity<>(studentRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        Optional<Student> obj = studentRepository.findById(id);
        if (obj.isPresent()) {
            return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
        }
        throw new ResourceNotFoundException("Student not found. Id: " + id);

    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<?> getStudentByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(studentRepository.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
    }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
//    @Transactional
    public ResponseEntity<?> save(@Valid @RequestBody Student student) throws Exception {
        studentRepository.save(student);
//        throw new IndexOutOfBoundsException();
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        studentRepository.delete(new Student(id, null, null));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.devdojo.springboot;
//
//import com.devdojo.springboot.models.Student;
//import com.devdojo.springboot.repository.StudentRepository;
//import java.util.List;
//import static org.assertj.core.api.Assertions.*;
//import javax.validation.ConstraintViolationException;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.ExpectedException;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// *
// * @author rodrigo.muniz
// */
////@RunWith(SpringRunner.class)
////@DataJpaTest
////@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class StudentRepositoryTest {
//
////    @Autowired
////    private StudentRepository repository;
////
////    @Rule
////    public ExpectedException thrown = ExpectedException.none();
////
////    @Test
////    public void createWhenNameIsNullShouldThrownConstraintViolationException() {
////        thrown.expect(ConstraintViolationException.class);
////        thrown.expectMessage("Coloque um nome");
////        Student s = repository.save(new Student(null, "valid@email.com"));
////        System.out.println(s.getId());
////    }
////    
////    @Test
////    public void createWhenNameIsEmptyShouldThrownConstraintViolationException() {
////        thrown.expect(ConstraintViolationException.class);
////        thrown.expectMessage("Coloque um nome");
////        Student s = repository.save(new Student("", "valid@email.com"));
////        System.out.println(s.getId());
////    }
////    
////    @Test
////    public void createWhenEmailIsNullShouldThrownConstraintViolationException() {
////        thrown.expect(ConstraintViolationException.class);
////        Student s = repository.save(new Student("Valid Name", null));
////        System.out.println(s.getId());
////    }
////    
////    @Test
////    public void createWhenEmailIsEmptyShouldThrownConstraintViolationException() {
////        thrown.expect(ConstraintViolationException.class);
////        Student s = repository.save(new Student("Valid Name", ""));
////        System.out.println(s.getId());
////    }
////    
////    @Test
////    public void createWhenEmailIsInvalidShouldThrownConstraintViolationException() {
////        thrown.expect(ConstraintViolationException.class);
////        Student s = repository.save(new Student("Valid Name", "email"));
////        System.out.println(s.getId());
////    }
////    
////
////    @Test
////    public void createShouldPersistData() {
////        Student student = new Student("teste", "teste@teste.com");
////        repository.save(student);
////        assertThat(student.getId()).isNotNull();
////        assertThat(student.getName()).isEqualTo("teste");
////        assertThat(student.getEmail()).isEqualTo("teste@teste.com");
////    }
////
////    @Test
////    public void updateShouldChangeAndPersistData() {
////        Student student = new Student("teste", "teste@teste.com");
////        repository.save(student);
////        Long idBeforeUpdate = student.getId();
////        student.setName("updatedName");
////        repository.save(student);
////        assertThat(student.getId()).isEqualTo(idBeforeUpdate);
////        assertThat(student.getName()).isEqualTo("updatedName");
////    }
////
////    @Test
////    public void deleteShouldRemoveData() {
////        Student student = new Student("teste", "teste@teste.com");
////        repository.save(student);
////        repository.delete(student);
////        System.out.println(repository.findById(student.getId()).isPresent());
////
////        assertThat(repository.findById(student.getId()).isPresent()).isFalse();
////    }
////
////    @Test
////    public void testFindByNameIgnoreCaseContaining() {
////        Student student = new Student(" Abc DEF ", "valid@email.com");
////        repository.save(student);
////        Long idSaved = student.getId();
////
////        List<Student> studentList = repository.findByNameIgnoreCaseContaining(" Abc DEF ");
////        assertThat(studentList).isNotNull();
////        assertThat(studentList.size()).isEqualTo(1);
////        assertThat(studentList.get(0).getId()).isEqualTo(idSaved);
////
////        studentList = repository.findByNameIgnoreCaseContaining("Abc");
////        assertThat(studentList).isNotNull();
////        assertThat(studentList.size()).isEqualTo(1);
////        assertThat(studentList.get(0).getId()).isEqualTo(idSaved);
////
////        studentList = repository.findByNameIgnoreCaseContaining("DEF");
////        assertThat(studentList).isNotNull();
////        assertThat(studentList.size()).isEqualTo(1);
////        assertThat(studentList.get(0).getId()).isEqualTo(idSaved);
////
////        studentList = repository.findByNameIgnoreCaseContaining("c D");
////        assertThat(studentList).isNotNull();
////        assertThat(studentList.size()).isEqualTo(1);
////        assertThat(studentList.get(0).getId()).isEqualTo(idSaved);
////    }
//
//}

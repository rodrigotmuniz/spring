///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.devdojo.springboot;
//
//import com.devdojo.springboot.models.Student;
//import com.devdojo.springboot.repository.StudentRepository;
//import static org.assertj.core.api.Assertions.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
///**
// *
// * @author Rodrigo Muniz
// */
////@RunWith(SpringRunner.class)
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
////@AutoConfigureMockMvc
//public class StudentEndpointTest {
//
////    //Works with SpringBootTest
////    @Autowired
////    private TestRestTemplate restTemplate;
////
////    //Works with AutoConfigureMockMvc
////    @Autowired
////    private MockMvc mockMvc;
////
////    @LocalServerPort
////    private int port;
////
////    @MockBean
////    private StudentRepository studentRepository;
////
////    @TestConfiguration
////    static class Configure {
////
////        @Bean
////        public RestTemplateBuilder restTemplateBuilder() {
////            return new RestTemplateBuilder().basicAuthorization("yusuke", "123456");
////        }
////    }
////
////    @Test
////    public void listAllWhenLoginIsIncorrectShouldReturnCode401() {
////        ResponseEntity<Student> responseWithIncorrectUsername = 
////                restTemplate.withBasicAuth("1", "123456").getForEntity("/v1/user/students", Student.class);
////        assertThat(responseWithIncorrectUsername.getStatusCode().value()).isEqualTo(401);
////
////        ResponseEntity<Student> responseWithIncorrectPassword = 
////                restTemplate.withBasicAuth("yusuke", "1").getForEntity("/v1/user/students", Student.class);
////        assertThat(responseWithIncorrectPassword.getStatusCode().value()).isEqualTo(401);
////    }
////
////    @Test
////    public void listAllWhenLoginIsCorrectShouldReturnCode200() {
////        ResponseEntity<Student> responseWithLoginCorrect = 
////                restTemplate.withBasicAuth("yusuke", "123456").getForEntity("/v1/user/students", Student.class);
////        assertThat(responseWithLoginCorrect.getStatusCode().value()).isEqualTo(200);
////    }
////    
////    @Test
////    public void getStudentByIdWhenIdValidShouldReturnCode200() {
//////        ResponseEntity<Student> response = restTemplate.getForEntity("/v1/user/students/{id}", Student.class, 1);
//////        assertThat(response.getStatusCode().value()).isEqualTo(200);
////    }
////    
////    @Test
////    public void getStudentByIdWhenIdNotValidShouldReturnCode404() {
////        ResponseEntity<Student> response = restTemplate.getForEntity("/v1/user/students/{id}", Student.class, 5);
////        assertThat(response.getStatusCode().value()).isEqualTo(404);
////    }
////    
////    @Test
////    public void getStudentByIdWhenIdValid() {
//////        Student savedStudent = 
//////                restTemplate.postForObject("/v1/admin/students", new Student("Valid Name", "valid@email.com"), Student.class);
//////        ResponseEntity<Student> response = restTemplate.getForEntity("/v1/user/students/{id}", Student.class, savedStudent.getId());
//////        assertThat(response.getBody().getName()).isEqualTo(savedStudent.getName());
////    }
//
//}

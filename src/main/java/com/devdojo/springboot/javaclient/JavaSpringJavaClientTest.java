/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.javaclient;

import com.devdojo.springboot.models.PageableResponse;
import com.devdojo.springboot.models.Student;
import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rodrigo.muniz
 */
public class JavaSpringJavaClientTest {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/user/students")
                .basicAuthorization("kuwabara", "123456")
                .build();

//        Student obj = restTemplate.getForObject("/{id}", Student.class, "3");
//        ResponseEntity<Student> entity = restTemplate.getForEntity("/{id}", Student.class, "3");
//        ResponseEntity<List<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null, 
//                new ParameterizedTypeReference<List<Student>>() {});
//        System.out.println(exchange.getBody());
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {
        });
        System.out.println(exchange.getBody().getContent());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.javaclient;

import com.devdojo.springboot.handler.RestResponseExceptionHandler;
import com.devdojo.springboot.models.PageableResponse;
import com.devdojo.springboot.models.Student;
import java.util.List;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author rodrigo.muniz
 */
public class JavaClientDAO {

    private RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/user/students")
            .basicAuthorization("kuwabara", "123456")
            .errorHandler(new RestResponseExceptionHandler())
            .build();

    private RestTemplate restTemplateAdmin = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/admin/students")
            .basicAuthorization("yusuke", "123456")
            .errorHandler(new RestResponseExceptionHandler())
            .build();
    
    public Student findById(long id) {
        return restTemplate.getForObject("/{id}", Student.class, id);
    }
    
    public List<Student> listALl() {
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {
        });
        return exchange.getBody().getContent();
    }
    
    public Student save(Student student) {
        ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/", HttpMethod.POST,
                new HttpEntity(student, createJsonHeader()), new ParameterizedTypeReference<Student>() {
        });
        return exchangePost.getBody();
    }
    
    public void update(Student student) {
        restTemplateAdmin.put("/", student);
    }
    
    public void delete(Long id) {
        restTemplateAdmin.delete("/{id}", id);
    }
    
    private static HttpHeaders createJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}

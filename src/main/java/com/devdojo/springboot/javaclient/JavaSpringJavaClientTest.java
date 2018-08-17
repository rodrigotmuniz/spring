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
public class JavaSpringJavaClientTest {

    public static void main(String[] args) {

        JavaClientDAO dao = new JavaClientDAO();

        Student testFindById = dao.findById(25L);
        System.out.println("findById: " + (testFindById.getId() != null ? "OK" : "BAD"));

        Student testSave = dao.save(new Student(null, "teste", "teste@email.com"));
        System.out.println("save: " + (testSave.getId() != null ? "OK" : "BAD"));

        List<Student> testListAll = dao.listALl();
        System.out.println("testListAll: " + (testListAll.size() == 5 ? "OK" : "BAD"));

        testSave.setName("update");
        dao.update(testSave);
        Student updatedStudent = dao.findById(testSave.getId());
        System.out.println("update: " + (updatedStudent.getName().equals("update") ? "OK" : "BAD"));

        dao.delete(testSave.getId());
        Student deletedStudent = dao.findById(testSave.getId());
        System.out.println("delete: " + (deletedStudent == null ? "OK" : "BAD"));

    }

    private static HttpHeaders createJsonHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}

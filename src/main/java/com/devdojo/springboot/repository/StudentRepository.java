/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.repository;

import com.devdojo.springboot.models.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo Muniz
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>{
    List<Student> findByNameIgnoreCaseContaining(String name);
}

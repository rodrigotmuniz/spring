/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.repository;

import com.devdojo.springboot.models.LocalUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author rodrigo.muniz
 */
public interface UserRepository extends PagingAndSortingRepository<LocalUser, Long>{
    LocalUser findByUsername(String userName);
}

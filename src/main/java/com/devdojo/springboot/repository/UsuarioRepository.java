/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.repository;

import com.devdojo.springboot.models.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rodrigo.muniz
 */
@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>{
    public Usuario findByNome(String nome);
    
}

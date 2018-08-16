/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.service;

import com.devdojo.springboot.models.User;
import com.devdojo.springboot.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author rodrigo.muniz
 */
@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    
    @Autowired
    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> grantedAuthoritiesAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> grantedAuthoritiesUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        
        return new org.springframework.security.core.userdetails.User
        (username, user.getPassword(), user.isAdmin() ? grantedAuthoritiesAdmin : grantedAuthoritiesUser);
    }
    
}

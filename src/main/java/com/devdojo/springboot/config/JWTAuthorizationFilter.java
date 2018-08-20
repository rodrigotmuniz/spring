/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.config;

import static com.devdojo.springboot.config.SecurityConstants.*;
import com.devdojo.springboot.models.LocalUser;
import com.devdojo.springboot.service.CustomUserDetailService;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 *
 * @author Rodrigo Muniz
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private final CustomUserDetailService customUserDetailService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, CustomUserDetailService customUserDetailService) {
        super(authenticationManager);
        this.customUserDetailService = customUserDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        UsernamePasswordAuthenticationToken authenticationToken = getAutheticationToken(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
        
    }
    
    private UsernamePasswordAuthenticationToken getAutheticationToken(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING).replace(TOKEN_PREFIX, "");
        String username = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
        UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
    }

}

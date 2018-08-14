/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devdojo.springboot.adapter;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author rodrigo.muniz
 */
@Configuration
public class SpringBootAdapterBla implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
//        WebMvcConfigurer.super.addArgumentResolvers(resolvers); //To change body of generated methods, choose Tools | Templates.
        PageableHandlerMethodArgumentResolver obj = new PageableHandlerMethodArgumentResolver();
        obj.setFallbackPageable(PageRequest.of(0, 5)); 
        resolvers.add(obj);
    }
    
    
    
}

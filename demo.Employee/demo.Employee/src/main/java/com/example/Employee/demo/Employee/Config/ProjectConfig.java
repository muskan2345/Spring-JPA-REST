package com.example.Employee.demo.Employee.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


    @Configuration
    public class ProjectConfig {
        @Bean
        public ModelMapper mapper() {
            return new ModelMapper();
        }
    }

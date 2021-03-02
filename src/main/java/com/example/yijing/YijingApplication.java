package com.example.yijing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan("com.example.controller")
@MapperScan("com.example.dao")
@ComponentScan("com.example.service")
@ComponentScan("com.example.configuration")
public class YijingApplication{

    public static void main(String[] args) {
        SpringApplication.run(YijingApplication.class, args);
    }

}

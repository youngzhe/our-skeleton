package com.our.ourweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.our.ourweb.controller"})
@MapperScan(basePackages = {"com.our.repository.mapper"})
public class OurWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurWebApplication.class, args);
    }

}

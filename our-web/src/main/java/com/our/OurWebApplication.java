package com.our;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**(scanBasePackages = {"com.our.controller"})*/
@SpringBootApplication
@MapperScan(basePackages = {"com.our.repository.mapper"})
public class OurWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(OurWebApplication.class, args);
    }

}

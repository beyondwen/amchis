package com.amchis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.amchis.mapper")
public class AmchisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmchisApplication.class, args);
    }

}

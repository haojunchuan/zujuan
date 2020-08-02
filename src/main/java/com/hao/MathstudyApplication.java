package com.hao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hao.dao")
public class MathstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MathstudyApplication.class, args);
    }

}

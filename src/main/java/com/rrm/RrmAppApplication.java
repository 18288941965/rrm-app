package com.rrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rrm.**.mapper")
public class RrmAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RrmAppApplication.class, args);
    }

}

package com.example.ooracle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.example.ooracle.mapper")
public class OoracleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OoracleApplication.class, args);
    }
}

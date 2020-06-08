package com.renhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.renhang.core.*.*.mapper")
public class JavaRenHangApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaRenHangApplication.class, args);
    }
}


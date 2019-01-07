package com.zero.qsonline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zero.qsonline.dao")
public class QsonlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(QsonlineApplication.class, args);
    }

}


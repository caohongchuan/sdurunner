package com.caohongchuan.sdurunner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.caohongchuan.sdurunner.mapper")

/**
 * @author caohongchuan
 * @since 1.0
 */
public class SdurunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdurunnerApplication.class, args);
    }

}

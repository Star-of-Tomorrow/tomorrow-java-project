package org.sot.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
@MapperScan(basePackages = "org.sot.project.dao.mapper")
public class TomorrowJavaProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(TomorrowJavaProjectApplication.class, args);
    }
}

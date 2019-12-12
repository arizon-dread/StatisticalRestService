package com.arizon.StatisticalRestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class StatisticalRestServiceApplication extends SpringBootServletInitializer {

    public StatisticalRestServiceApplication() {

    }

    public static void main(String[] args) {
        SpringApplication.run(StatisticalRestServiceApplication.class, args);
    }
}

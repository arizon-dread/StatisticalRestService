package com.arizon.StatisticalRestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@SpringBootApplication
public class StatisticalRestServiceApplication {

    public StatisticalRestServiceApplication() {

    }

    public static void main(String[] args) {
        SpringApplication.run(StatisticalRestServiceApplication.class, args);
    }
}

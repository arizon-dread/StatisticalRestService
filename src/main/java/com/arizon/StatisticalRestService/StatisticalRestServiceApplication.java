package com.arizon.StatisticalRestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class StatisticalRestServiceApplication {

    public StatisticalRestServiceApplication() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("StatisticalRestService-persistence-unit");
        EntityManager entityManager = factory.createEntityManager();
    }

    public static void main(String[] args) {
        SpringApplication.run(StatisticalRestServiceApplication.class, args);
    }
}

package com.arizon.StatisticalRestService.service;

import com.arizon.StatisticalRestService.Repository.EntityTypeRepository;
import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class PersistenceService {

    public PersistenceService() {}

    @Autowired
    EntityManager entityManager;

    @Autowired
    EntityTypeRepository entityTypeRepository;

    @Transactional
    public void persist(StatisticalEntity entity) {
        if (entityTypeRepository.findByUnit(entity.getEntitytype().toString()) == null) {
            entityManager.persist(new EntityType("g"));
        }
        entityManager.persist(entity);
    }

    @Transactional
    public void merge(Object entity) {
        entityManager.merge(entity);
    }


    @Transactional
    public void persist(EntityType entityType) {
        entityManager.persist(entityType);
    }

    @Transactional
    public void merge(EntityType entityType) {
        entityManager.merge(entityType);
    }

    @Transactional
    public void persist(Caller caller) {
        entityManager.persist(caller);
    }

    @Transactional
    public void merge(Caller caller) {
        entityManager.merge(caller);
    }

}

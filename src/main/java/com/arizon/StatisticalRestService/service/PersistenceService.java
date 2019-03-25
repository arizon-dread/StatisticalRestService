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
        entityManager.flush();
        entityManager.close();
    }


    @Transactional
    public void persist(EntityType entityType) {
        entityManager.persist(entityType);
        entityManager.flush();
        entityManager.close();
    }

    @Transactional
    public void merge(EntityType entityType) {
        entityManager.merge(entityType);
        entityManager.flush();
        entityManager.close();
    }

    @Transactional
    public void persist(Caller caller) {
        for (EntityType type : caller.getEntityTypes()) {
            if (!entityTypeRepository.existsById(type.getId())) {
                persist(type);
            }
        }
        entityManager.persist(caller);
        entityManager.flush();
        entityManager.close();
    }

    @Transactional
    public void merge(Caller caller) {
        for (EntityType type : caller.getEntityTypes()) {
            if (!entityTypeRepository.existsById(type.getId())) {
                persist(type);
            }
        }
        entityManager.merge(caller);
        entityManager.flush();
        entityManager.close();
    }



}

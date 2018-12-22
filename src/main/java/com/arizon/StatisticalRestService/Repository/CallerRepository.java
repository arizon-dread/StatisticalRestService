package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.Caller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CallerRepository extends JpaRepository<Caller, Long> {
    Caller findById(UUID id);
    List<Caller> findCallersByEntityType(String entityType);
    Caller findByName(String name);
}

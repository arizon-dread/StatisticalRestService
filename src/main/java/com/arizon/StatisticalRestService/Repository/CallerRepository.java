package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.Caller;
import com.arizon.StatisticalRestService.model.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CallerRepository extends JpaRepository<Caller, Long> {
    Caller findById(long id);
    //List<Caller> findCallersByEntityType(EntityType entityTypes);
    Caller findByCallerName(String callerName);
}

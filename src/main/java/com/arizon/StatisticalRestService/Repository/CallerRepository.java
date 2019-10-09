package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.Caller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CallerRepository extends CrudRepository<Caller, Long> {
    //List<Caller> findByEntityType(EntityType entityTypes);
    Caller findByCallerName(String callerName);

    Optional<Caller> findById(long callerId);
}

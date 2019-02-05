package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.Caller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CallerRepository extends CrudRepository<Caller, Long> {
    //List<Caller> findByEntityType(EntityType entityTypes);
    Caller findByCallerName(String callerName);
}

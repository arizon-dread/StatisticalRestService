package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticalEntityRepository extends CrudRepository<StatisticalEntity, Long> {

    StatisticalEntity findByEntitytype(EntityType entitytypeId);
    //List<StatisticalEntity> findStatisticalEntitiesBetween(Date fromDate, Date toDate);
}

package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticalEntityRepository extends CrudRepository<StatisticalEntity, Long> {

    StatisticalEntity findByEntitytype(EntityType entitytypeId);

    List<StatisticalEntity> findAllByCaller(long callerId);
    //List<StatisticalEntity> findBetween(Date fromDate, Date toDate);
}

package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticalEntityRepository extends JpaRepository<StatisticalEntity, Long> {
    @Override
    StatisticalEntity getOne(Long aLong);
    StatisticalEntity findByEntityType(EntityType entityTypeId);
    List<StatisticalEntity> findStatisticalEntitiesBetween(Date fromDate, Date toDate);
}

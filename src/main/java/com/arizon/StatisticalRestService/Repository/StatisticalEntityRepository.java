package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import com.arizon.StatisticalRestService.model.StatisticalEntity;
import com.arizon.StatisticalRestService.model.StatisticalEntityJson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatisticalEntityRepository extends CrudRepository<StatisticalEntity, Long> {

    StatisticalEntity findByEntitytype(EntityType entitytypeId);

    List<StatisticalEntity> findAllByCaller(long callerId);
    //List<StatisticalEntity> findBetween(Date fromDate, Date toDate);

    @Query("from StatisticalEntity s where (s.timestamp between :from and :to) and (s.caller = (select c From Caller c where c.id = :callerId))")
    List<StatisticalEntity> findByTimestampBetween(@Param("callerId")long callerId, @Param("from")Date from,
                                                   @Param("to") Date to);
}

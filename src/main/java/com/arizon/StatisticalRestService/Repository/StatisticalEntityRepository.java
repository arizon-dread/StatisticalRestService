package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.StatisticalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticalEntityRepository extends JpaRepository<StatisticalEntity, Long> {
}

package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EntityTypeRepository extends CrudRepository<EntityType, Long> {
    EntityType findByUnit(String unit);


}

package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {
    EntityType findByName(String name);

}

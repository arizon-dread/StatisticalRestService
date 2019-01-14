package com.arizon.StatisticalRestService.Repository;

import com.arizon.StatisticalRestService.model.EntityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntityTypeRepository extends JpaRepository<EntityType, Long> {
    EntityType findByName(String name);

}

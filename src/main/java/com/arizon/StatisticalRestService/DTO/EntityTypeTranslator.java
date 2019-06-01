package com.arizon.StatisticalRestService.DTO;

import com.arizon.StatisticalRestService.model.EntityType;
import model.EntityTypeJson;

import java.util.HashSet;
import java.util.Set;

//import com.arizon.StatisticalRestService.model.EntityTypeJson;


public class EntityTypeTranslator {

    public EntityType getEntityTypeFromJson(EntityTypeJson jsonEntity) {
        EntityType entity = new EntityType();
        entity.setUnit(jsonEntity.getUnit());
        return entity;
    }

    public EntityTypeJson getJsonFromDbEntity(EntityType entity) {
        return new EntityTypeJson(entity.getUnit());
    }

    public Set<EntityTypeJson> getJsonEntitySetFromDbSet(Set<EntityType> entities) {
        Set<EntityTypeJson> jsons = new HashSet<EntityTypeJson>();

        for(EntityType entity : entities) {
            jsons.add(new EntityTypeJson(entity.getUnit()));
        }
        return jsons;
    }

    public Set<EntityType> getEntitiesFromJson(Set<EntityTypeJson> jsons) {
        Set<EntityType> entities = new HashSet<EntityType>();
        for(EntityTypeJson json : jsons) {
            entities.add(new EntityType(json.getUnit()));
        }
        return entities;
    }
}

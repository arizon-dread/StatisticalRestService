package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Set;

public class CallerJson {

    @JsonValue
    String callerName;

    @JsonValue
    Set<EntityType> entityTypes;

    @JsonValue
    String callerAddress;

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public Set<EntityType> getEntityTypes() {
        return entityTypes;
    }

    public void setEntityTypes(Set<EntityType> entityTypes) {
        this.entityTypes = entityTypes;
    }

    public String getCallerAddress() {
        return callerAddress;
    }

    public void setCallerAddress(String callerAddress) {
        this.callerAddress = callerAddress;
    }
}

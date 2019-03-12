package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Date;

public class StatisticalEntityJson {

    public StatisticalEntityJson(){}

    @JsonValue
    private EntityType entityType;

    @JsonValue
    private Date timeStamp;

    @JsonValue
    private int occurances;

    @JsonValue
    private double value;

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getOccurances() {
        return occurances;
    }

    public void setOccurances(int occurances) {
        this.occurances = occurances;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

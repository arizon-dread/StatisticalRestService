package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Date;

public class StatisticalEntityJson {
    //TODO: Put JsonModels in their own api project, import it in both this and the web client projects.

    public StatisticalEntityJson(){}

    @JsonValue
    private String entityTypeName;

    @JsonValue
    private Date timeStamp;

    @JsonValue
    private int occurances;

    @JsonValue
    private double value;

    public String getEntityType() {
        return entityTypeName;
    }

    public void setEntityType(String entityTypeName) {
        this.entityTypeName = entityTypeName;
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

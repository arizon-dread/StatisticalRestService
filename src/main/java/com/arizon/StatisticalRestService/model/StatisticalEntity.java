package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by arizon on 12/7/17.
 */
@Entity
@Table(name = "StatisticalEntity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class StatisticalEntity {


    private long id;
    private EntityType entityType;
    private String entityName;
    private Double entityValue;
    private UUID callerId;
    private Date startDate;
    private Date endDate;
    private int occurances;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    @JsonValue
    @ManyToOne(targetEntity = com.arizon.StatisticalRestService.model.EntityType.class)
    //@Column(name = "entityType", nullable = false)
    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    @JsonValue
    @OneToOne(targetEntity = com.arizon.StatisticalRestService.model.EntityType.class)
    //@Column(name = "entityName", nullable = false)
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @JsonValue
    @Column(name = "entityValue", nullable = true)
    public Double getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(Double entityValue) {
        this.entityValue = entityValue;
    }

    @JsonValue
    @Column(name = "callerId", nullable = false)
    public UUID getCallerId() {
        return callerId;
    }

    public void setCallerId(UUID callerId) {
        this.callerId = callerId;
    }

    @JsonValue
    @Column(name = "from", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @JsonValue
    @Column(name = "to", nullable = false)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @JsonValue
    @Column(name = "occurances", nullable = false)
    public int getOccurances() {
        return occurances;
    }

    public void setOccurances(int occurances) {
        this.occurances = occurances;
    }
}

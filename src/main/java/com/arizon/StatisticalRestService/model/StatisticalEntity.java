package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.sql.Date;
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


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @JsonValue
    @ManyToOne(targetEntity = EntityType.class)
    private EntityType entityType;
    //    private String entityName;
//    private Double entityValue;
    @JsonValue
    @ManyToOne
    @JoinColumn(name = "callerId")
    private long callerId;

    @JsonValue
    @Column(name = "from", nullable = false)
    private Date startDate;

    @JsonValue
    @Column(name = "to", nullable = false)
    private Date endDate;

    @JsonValue
    @Column(name = "occurances", nullable = false)
    private int occurances;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

//    @JsonValue
//    @OneToOne(targetEntity = EntityType.class)
//    //@Column(name = "entityName", nullable = false)
//    public String getEntityName() {
//        return entityName;
//    }

//    public void setEntityName(String entityName) {
//        this.entityName = entityName;
//    }

//    @JsonValue
//    @Column(name = "entityValue", nullable = true)
//    public Double getEntityValue() {
//        return entityValue;
//    }
//
//    public void setEntityValue(Double entityValue) {
//        this.entityValue = entityValue;
//    }


    //    @Column(name = "callerId", nullable = false)
    public long getCallerId() {
        return callerId;
    }
    public void setCallerId(long callerId) {
        this.callerId = callerId;
    }


    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public int getOccurances() {
        return occurances;
    }
    public void setOccurances(int occurances) {
        this.occurances = occurances;
    }
}

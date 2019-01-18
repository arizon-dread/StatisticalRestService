package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by arizon on 12/7/17.
 */
@Entity
@Table(name = "StatisticalEntity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class StatisticalEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @JsonValue
    @ManyToOne
    @JoinColumn(name = "EntityTypeId")
    private EntityType entityType;

    @JsonValue
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caller")
    private Caller caller;

    @JsonValue
    @Column(name = "timestamp", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    /*@JsonValue
    @Column(name = "to", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;*/

    @JsonValue
    @Column(name = "occurances", nullable = false)
    private int occurances;

    public StatisticalEntity(){}

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public EntityType getEntityType() {
        return entityType;
    }
    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Caller getCaller() {
        return caller;
    }
    public void setCallerId(Caller caller) {
        this.caller = caller;
    }


    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /*public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }*/


    public int getOccurances() {
        return occurances;
    }
    public void setOccurances(int occurances) {
        this.occurances = occurances;
    }
}

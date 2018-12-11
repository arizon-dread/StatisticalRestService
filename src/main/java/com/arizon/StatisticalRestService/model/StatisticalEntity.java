package com.arizon.StatisticalRestService.model;

import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by arizon on 12/7/17.
 */
@Entity
@Table(name="StatisticalEntity", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class StatisticalEntity{


    private long id;
    private String entityType;
    private String entityName;
    private String clientName;
    private String clientOrgnr;
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
    @Column(name = "type", nullable = false)
    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @JsonValue
    @Column(name = "name", nullable = false)
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    @JsonValue
    @Column(name = "client")
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @JsonValue
    @Column(name = "orgnr", nullable = false)
    public String getClientOrgnr() {
        return clientOrgnr;
    }

    public void setClientOrgnr(String clientOrgnr) {
        this.clientOrgnr = clientOrgnr;
    }

    @JsonValue
    @Column(name= "from", nullable = false)
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

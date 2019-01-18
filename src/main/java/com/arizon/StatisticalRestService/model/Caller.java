package com.arizon.StatisticalRestService.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 *
 * Created by arizon on 12/7/17.
 */

@Entity
@Table(name="Caller", uniqueConstraints = {
        @UniqueConstraint(columnNames = "HMACid")
})
public class Caller implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    //@OneToMany(mappedBy = "statisticalEntity.callerId")
    private long callerId;

    @Column(name = "callerName")
    private String callerName;

    @Column(name = "HMACid")
    private String hMACid;

    @ElementCollection
    @OneToMany
    @Column(name = "allowed entityTypes", nullable = false)
    private List<EntityType> entityTypes;

    @Column(name ="allowedAddress", nullable = false)
    private String callerAddress;

    public Caller() {}
    public long getCallerId() {
        return callerId;
    }
    public void setCallerId(long callerId) {
        this.callerId = callerId;
    }

    public String getCallerName() {
        return callerName;
    }
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }


    public String gethMACid() {
        return hMACid;
    }
    public void sethMACid(String hMACid) {
        this.hMACid = hMACid;
    }


    public List<EntityType> getEntityTypes() {
        return entityTypes;
    }

    public void setEntityTypes(EntityType entityType) {
        this.entityTypes.add(entityType);
    }
    public void setentityTypes(List<EntityType> entityTypes) {
        this.entityTypes = entityTypes;
    }

    public String getCallerAddress() {
        return callerAddress;
    }

    public void setCallerAddress(String callerAddresses) {
        this.callerAddress = callerAddress;
    }
}

package com.arizon.StatisticalRestService.model;

import javax.persistence.*;
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
public class Caller {

    private long callerId;
    private String callerName;
    private String hMACid;
    private List<EntityType> entityTypes;
    private String callerAddress;





    @Id
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    public long getCallerId() {
        return callerId;
    }

    public void setCallerId(long callerId) {
        this.callerId = callerId;
    }
    @Column(name = "name")
    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }
    @Column(name = "HMACid")
    public String gethMACid() {
        return hMACid;
    }

    public void sethMACid(String hMACid) {
        this.hMACid = hMACid;
    }

    @ElementCollection
    @Column(name = "allowed entityTypes", nullable = false)
    public List<EntityType> getEntityTypes() {
        return entityTypes;
    }

    public void setEntityTypes(EntityType entityType) {
        this.entityTypes.add(entityType);
    }
    public void setentityTypes(List<EntityType> entityTypes) {
        this.entityTypes = entityTypes;
    }

    @Column(name ="allowed addresses", nullable = false)
    public String getCallerAddress() {
        return callerAddress;
    }

    public void setCallerAddress(String callerAddresses) {
        this.callerAddress = callerAddress;
    }
}

package com.arizon.StatisticalRestService.model;

import javax.persistence.*;

/**
 *
 * Created by arizon on 12/7/17.
 */

@Entity
@Table(name="Caller", uniqueConstraints = {
        @UniqueConstraint(columnNames = "HMACid")
})
public class Caller {

    private String hMACid;
    private String entityType;
    private String callerAddress;

    @Id
    @Column(name = "HMACid", nullable = false, unique = true, updatable = false)
    public String gethMACid() {
        return hMACid;
    }

    public void sethMACid(String hMACid) {
        this.hMACid = hMACid;
    }

    @Column(name = "allowed entityTypes", nullable = false)
    public String getEntityTypes() {
        return entityType;
    }

    public void setEntityTypes(String entityType) {
        this.entityType = entityType;
    }

    @Column(name ="allowed addresses", nullable = false)
    public String getCallerAddresse() {
        return callerAddress;
    }

    public void setCallerAddresses(String callerAddresses) {
        this.callerAddress = callerAddress;
    }
}

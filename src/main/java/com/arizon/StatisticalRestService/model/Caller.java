package com.arizon.StatisticalRestService.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * Created by arizon on 12/7/17.
 */

@Entity
@Table(name="Caller", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class Caller implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String callerName;

    @OneToMany(cascade = CascadeType.PERSIST)
    private Set<EntityType> entitytypes;

    @Column(name ="allowedAddress", nullable = false)
    private String callerAddress;

    public Caller() {}
    public long getCallerId() {
        return id;
    }
    public void setCallerId(long id) {
        this.id = id;
    }

    public String getCallerName() {
        return callerName;
    }
    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }


    public Set<EntityType> getEntitytypes() {
        return entitytypes;
    }

    public void setEntitytypes(EntityType entityType) {
        this.entitytypes.add(entityType);
    }
    public void setentityTypes(Set<EntityType> entityTypes) {
        this.entitytypes = entityTypes;
    }

    public String getCallerAddress() {
        return callerAddress;
    }

    public void setCallerAddress(String callerAddresses) {
        this.callerAddress = callerAddress;
    }
}

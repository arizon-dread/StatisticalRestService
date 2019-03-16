package com.arizon.StatisticalRestService.model;

import javax.persistence.*;

import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "EntityType", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class EntityType implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    //@Column(unit = "unit")
    //@OneToOne(targetEntity = com.arizon.StatisticalRestService.model.StatisticalEntity.class, mappedBy = "entityType")
    private String unit;


    public EntityType(){}
    public EntityType(String unit){
        this.setUnit(unit);
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

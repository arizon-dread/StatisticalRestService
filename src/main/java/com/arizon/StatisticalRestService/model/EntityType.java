package com.arizon.StatisticalRestService.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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

    //@Column(name = "name")
    //@OneToOne(targetEntity = com.arizon.StatisticalRestService.model.StatisticalEntity.class, mappedBy = "entityType")
    private String name;

    public EntityType(){}

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

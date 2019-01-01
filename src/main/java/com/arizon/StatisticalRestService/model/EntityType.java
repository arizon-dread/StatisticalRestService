package com.arizon.StatisticalRestService.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "EntityType", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class EntityType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "name")
    //@OneToOne(targetEntity = com.arizon.StatisticalRestService.model.StatisticalEntity.class, mappedBy = "entityType")
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

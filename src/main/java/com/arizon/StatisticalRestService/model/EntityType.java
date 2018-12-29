package com.arizon.StatisticalRestService.model;

import javax.persistence.*;

@Entity
@Table(name = "EntityType", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")
})
public class EntityType {

    private long id;
    private String name;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //@Column(name = "name")
    @OneToOne(targetEntity = com.arizon.StatisticalRestService.model.StatisticalEntity.class, mappedBy = "entityName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

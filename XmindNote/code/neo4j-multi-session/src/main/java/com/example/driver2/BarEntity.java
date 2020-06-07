package com.example.driver2;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author admin
 */
@NodeEntity(label = "Bar")
public class BarEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public BarEntity(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

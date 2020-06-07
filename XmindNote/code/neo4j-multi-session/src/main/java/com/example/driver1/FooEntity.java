package com.example.driver1;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author admin
 */
@NodeEntity(label = "Foo")
public class FooEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public FooEntity(String name){
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

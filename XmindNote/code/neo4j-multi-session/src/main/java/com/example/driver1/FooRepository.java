package com.example.driver1;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author admin
 */
public interface FooRepository extends Neo4jRepository<FooEntity, Long> {
}

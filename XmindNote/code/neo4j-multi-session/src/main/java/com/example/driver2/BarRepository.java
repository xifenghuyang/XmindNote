package com.example.driver2;

import org.springframework.data.neo4j.repository.Neo4jRepository;

/**
 * @author admin
 */
public interface BarRepository extends Neo4jRepository<BarEntity, Long> {
}

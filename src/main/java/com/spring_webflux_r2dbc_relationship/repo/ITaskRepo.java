package com.spring_webflux_r2dbc_relationship.repo;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ITaskRepo extends ReactiveCrudRepository<Task, Integer> {

    @Query("CREATE SCHEMA IF NOT EXISTS :id")
    Mono<Void> newClientSchema(String id);

    @Query("CREATE TABLE " +
            ":id.tasks " +
            "(id SERIAL PRIMARY KEY, lastname VARCHAR(255), completed boolean)")
    Mono<Void> newClientSchemaTable(String id);


}

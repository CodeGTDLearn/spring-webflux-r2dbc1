package com.spring_webflux_r2dbc_relationship.repo;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepo extends ReactiveCrudRepository<Task, Integer> {

}

//    @Modifying
//    @Query("CREATE SCHEMA IF NOT EXISTS :user")
//    Mono<Void> newSchema(String user);

//    @Query("CREATE TABLE " +
//            ":user.tasks " +
//            "(user SERIAL PRIMARY KEY, lastname VARCHAR(255), completed boolean)")
//    Mono<Void> newSchemaTable(String user);

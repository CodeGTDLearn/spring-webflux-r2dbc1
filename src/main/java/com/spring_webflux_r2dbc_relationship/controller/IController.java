package com.spring_webflux_r2dbc_relationship.controller;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IController {
    Flux<Task> findAllRepositories();

    Flux<Task> getTaskBySchema(String schema);

    Flux<Task> getTaskByDb( String db);

    Mono<Void> createSchema(String schema);

    Mono<Void> createDb(String db);

    Flux<Object> createScriptSchema(String schema,String table);

    Flux<Object> createScriptDb(String db,String schema,String table);

}

package com.spring_webflux_r2dbc_relationship.controller;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQ)
@RestController
public class Controller implements IController {

    @Autowired
    private ITaskService service;

    @Override
    @GetMapping(MAP)
    public Flux<Task> findAllRepositories() {
        return service.findAll();
    }

    @Override
    @GetMapping(MAP + PATH_SCHEMA)
    public Flux<Task> getTaskBySchema(@PathVariable("schema") String schema) {
        return service.getTaskBySchema(schema);
    }

    @Override
    @GetMapping(MAP + PATH_DB)
    public Flux<Task> getTaskByDb(@PathVariable("db") String db) {
        return service.getTaskBySchema(db);
    }

    @Override
    @PostMapping(MAP + PATH_SCHEMA)
    public Mono<Void> createSchema(@PathVariable("schema") String schema) {
        return service.createSchema(schema);
    }

    @Override
    @PostMapping(MAP + PATH_SCR_SCHEMA)
    public Flux<Object> createScriptSchema(
            @PathVariable("schema") String schema,
            @PathVariable("table") String table) {
        return service.createScriptSchema(schema,table);
    }

    @Override
    @PostMapping(MAP + PATH_DB)
    public Mono<Void> createDb(@PathVariable("db") String db) {
        return service.createDb(db);
    }

    @Override
    @PostMapping(MAP + PATH_SCR_DB)
    public Flux<Object> createScriptDb(
            @PathVariable("db") String db,
            @PathVariable("schema") String schema,
            @PathVariable("table") String table) {
        return service.createScriptDb(db,schema,table);
    }


}
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
    public Flux<Task> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping(MAP + PATH_SCHEMA)
    public Flux<Task> getTaskBySchema(@PathVariable("schema") String schema) {
        return service.getTaskBySchema(schema);
    }

    @Override
    @PostMapping(MAP + PATH_SCHEMA)
    public Mono<Void> createSchema(@PathVariable("schema") String schema) {
        return service.createSchema(schema);
    }


}
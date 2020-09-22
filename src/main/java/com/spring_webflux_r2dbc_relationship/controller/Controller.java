package com.spring_webflux_r2dbc_relationship.controller;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.service.ITaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQMAP)
@RestController
public class Controller implements IController {

    @Autowired
    ITaskService service;

    @Override
    @GetMapping(GET)
    public Flux<Task> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping(GET + PATH_VAR)
    public Mono<Void> newUser(@PathVariable String id) {
        return service.newUser(id);
    }

}

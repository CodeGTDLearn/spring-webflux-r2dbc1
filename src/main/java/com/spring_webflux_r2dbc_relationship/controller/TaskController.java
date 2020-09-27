package com.spring_webflux_r2dbc_relationship.controller;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQ)
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping(MAP)
    public Flux<Task> findAll() {
        return taskService.findAll();
    }
}
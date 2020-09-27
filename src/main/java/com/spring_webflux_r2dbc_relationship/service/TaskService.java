package com.spring_webflux_r2dbc_relationship.service;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.repo.ITaskRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class TaskService {
    @Autowired
    private ITaskRepo repo;

    public Flux<Task> findAll() {
        return repo.findAll();
    }

}
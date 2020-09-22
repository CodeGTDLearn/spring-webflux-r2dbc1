package com.spring_webflux_r2dbc_relationship.service;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.repo.ITaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepo repo;

    public Flux<Task> findAll() {
        return repo.findAll();
    }

    @Override
    public Mono<Void> newUser(String id) {

        repo.newClientSchema(id);
        repo.newClientSchemaTable(id);

        return null;
    }
}

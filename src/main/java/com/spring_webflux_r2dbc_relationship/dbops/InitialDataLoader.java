package com.spring_webflux_r2dbc_relationship.dbops;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.repo.ITaskRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class InitialDataLoader {

    @Autowired
    private ITaskRepo repo;

    @PostConstruct
    private void loadDataMass() {
//        repo.deleteAll()
//            .thenMany(
//                    Flux.just("Task 1","Task 2","Task 3")
//                        .map(Task::new)
//                        .flatMap(repo::save))
//            .subscribe();
    }
}

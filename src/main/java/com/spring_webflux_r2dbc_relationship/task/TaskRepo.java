package com.spring_webflux_r2dbc_relationship.task;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends ReactiveCrudRepository<Task, Integer> {

}

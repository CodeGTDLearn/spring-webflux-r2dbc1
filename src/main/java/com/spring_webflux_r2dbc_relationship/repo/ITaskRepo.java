package com.spring_webflux_r2dbc_relationship.repo;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepo extends ReactiveCrudRepository<Task, Integer> {

}

package com.spring_webflux_r2dbc_relationship.repo;

import com.spring_webflux_r2dbc_relationship.entity.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IStudentRepo extends ReactiveCrudRepository<Student, Long> {

    Mono<Student> findByFirstname(String firstName);

}

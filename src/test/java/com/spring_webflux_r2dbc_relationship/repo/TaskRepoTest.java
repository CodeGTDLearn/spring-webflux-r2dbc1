package com.spring_webflux_r2dbc_relationship.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class TaskRepoTest {
//    @Autowired
//    ITaskRepo repo;
//
//    @Test
//    public void readsAllEntitiesCorrectly() {
//
//        repo.findAll()
//            .as(StepVerifier::create)
//            .expectNextCount(1)
//            .verifyComplete();
//    }
//
//    @Test
//    public void readsEntitiesByNameCorrectly() {
//
//        repo.findByFirstname("Hello World")
//            .as(StepVerifier::create)
//            .expectNextCount(1)
//            .verifyComplete();
//    }

}
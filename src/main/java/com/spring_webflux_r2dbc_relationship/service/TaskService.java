package com.spring_webflux_r2dbc_relationship.service;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.repo.ITaskRepo;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TaskService implements ITaskService {
    @Autowired
    private ITaskRepo repo;

    @Autowired
    PostgresqlConnectionConfiguration.Builder connectionConfig;

    public Flux<Task> findAll() {
        return repo.findAll();
    }

    public Flux<Task> getTaskBySchema(String schema) {

        // configure connfactory with schema set on the builder
        PostgresqlConnectionFactory connectionFactory =
                new PostgresqlConnectionFactory(
                        connectionConfig
                                .schema(schema)
                                .build()
                );

        DatabaseClient ddl = DatabaseClient.create(connectionFactory);

        String sql = "select * from tasks";

        return ddl.execute(sql)
                  .as(Task.class)
                  .fetch()
                  .all();
    }


    /*
    **********************************************
    * Spring Data R2dbc does not support JPA
    * In order to Spring Data makes DDL it should
    * works with JPA.
    * R2DBC
    *      DDL: In order to make DDL in Spring Data R2dbc
    *      is necessary to use R2dbc.DataBaseClient.
    *      DML: Can ben done with
    *       Spring Data R2dbc - R2dbcREpositories
    * ********************************************
     */
    public Mono<Void> createSchema(String schema) {

        // configure connfactory with schema set on the builder
        PostgresqlConnectionFactory connectionFactory =
                new PostgresqlConnectionFactory(
                        connectionConfig.build()
                );

        DatabaseClient ddl = DatabaseClient.create(connectionFactory);

        String sql = "CREATE SCHEMA IF NOT EXISTS " + "\"" + schema + "\"";

        return ddl.execute(sql)
                  .then();
    }

}


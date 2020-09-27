package com.spring_webflux_r2dbc_relationship.repo;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.spring_webflux_r2dbc_relationship.dbops.DbScripts.*;


@Slf4j
@Component
public class RepoDbClient {

    @Autowired
    PostgresqlConnectionConfiguration.Builder connConfig;

    private PostgresqlConnectionFactory connFactory
            (PostgresqlConnectionConfiguration.Builder connectionConfig) {
        return new PostgresqlConnectionFactory(
                connectionConfig.build()
        );
    }

    public Flux<Task> getTasksBySchema(String schema) {

        // configure connfactory with schema set on the builder
        PostgresqlConnectionFactory connFactory =
                connFactory
                        (
                                connConfig.schema(schema)
                        );

        DatabaseClient ddl = DatabaseClient.create(connFactory);

        return ddl.execute(SQL_GET_TASK_BY_SCHEMA)
                  .as(Task.class)
                  .fetch()
                  .all();
    }

    public Flux<Task> getTasksByDb(String db) {

        connConfig.database(db);
        //        connConfig.schema(db);

        PostgresqlConnectionFactory connFactory = connFactory(connConfig);

        DatabaseClient ddl = DatabaseClient.create(connFactory);

        return ddl.execute(SQL_GET_TASK_BY_SCHEMA)
                  .as(Task.class)
                  .fetch()
                  .all();
    }

    public Mono<Void> createSchema(String schema) {

        // configure connfactory with schema set on the builder
        PostgresqlConnectionFactory
                connectionFactory = connFactory(connConfig);

        DatabaseClient ddl = DatabaseClient.create(connectionFactory);

        return ddl
                .execute(sqlCreateSchema(schema))
                .then();
    }

    public Mono<Void> createDb(String db) {

        PostgresqlConnectionFactory
                connectionFactory = connFactory(connConfig);

        DatabaseClient ddl = DatabaseClient.create(connectionFactory);

        return ddl
                .execute(sqlCreateDb(db))
                .then();
    }

    public Flux<Object> scriptsCreateSchemma(String schema,String table) {
        return Mono.from(
                connFactory(connConfig).create())
                   .flatMapMany(
                           connection ->
                                   Flux.from(connection
                                                     .createBatch()
                                                     .add(sqlCreateSchema(schema))
                                                     .add(sqlCreateTable(schema,table))
                                                     .add(populateTable(schema,table))
                                                     .execute()
                                            ));
    }

    public Flux<Object> scriptsCreateDb(String db,String schema,String table) {

        return createDb(db).thenMany(
                Mono.from(
                        connFactory(connConfig.database(db)).create())
                    .flatMapMany(
                            connection ->
                                    Flux.from(connection
                                                      .createBatch()
                                                      .add(sqlCreateSchemaDb(db,schema))
                                                      .add(sqlCreateTable(schema,table))
                                                      .add(populateTable(schema,table))
                                                      .execute()
                                             )));

        //        connConfig.database(db);

        //        return Mono.from(
        //                connFactory(connConfig).create())
        //                   .flatMapMany(
        //                           connection ->
        //                                   Flux.from(connection
        //                                                     .createBatch()
        //                                                     .add(sqlCreateSchemaDb(db,schema))
        //                                                     .add(sqlCreateTable(schema,table))
        //                                                     .add(populateTable(schema,table))
        //                                                     .execute()
        //                                            ));


    }
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



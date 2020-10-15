package com.spring_webflux_r2dbc_relationship.ddl;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.spring_webflux_r2dbc_relationship.ddl.Scripts.*;


@Slf4j
@Component
public class ProcRepo {

    @Autowired
    PostgresqlConnectionConfiguration.Builder connConfig;

    private PostgresqlConnectionFactory conFactory
            (PostgresqlConnectionConfiguration.Builder config) {
        return new PostgresqlConnectionFactory(config.build());
    }

    private Mono<Void> createDb(String db) {
        PostgresqlConnectionFactory conFact = conFactory(connConfig);

        DatabaseClient ddl = DatabaseClient.create(conFact);

        return ddl
                .execute(sqlCreateDb(db))
                .then();
    }

    public Flux<Object> createDbByDb(String db,String table) {
        return createDb(db).thenMany(
                Mono.from(conFactory(connConfig.database(db)).create())
                    .flatMapMany(
                            connection ->
                                    Flux.from(connection
                                                      .createBatch()
                                                      .add(sqlCreateSchema(db))
                                                      .add(sqlCreateTable(db,table))
                                                      .add(sqlPopulateTable(db,table))
                                                      .execute()
                                             )));
    }


    public Flux<Object> createSchemmaByDb(String db,String schema,String table) {
        return Mono.from(
                conFactory(connConfig.database(db)).create())
                   .flatMapMany(
                           connection ->
                                   Flux.from(connection
                                                     .createBatch()
                                                     .add(sqlCreateSchema(db))
                                                     .add(sqlCreateTable(db,table))
                                                     .add(sqlPopulateTable(db,table))
                                                     .execute()
                                            ));
    }
}

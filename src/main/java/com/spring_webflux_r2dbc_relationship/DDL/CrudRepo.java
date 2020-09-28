package com.spring_webflux_r2dbc_relationship.DDL;

import com.spring_webflux_r2dbc_relationship.task.Task;
import com.spring_webflux_r2dbc_relationship.task.TaskRepo;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import static com.spring_webflux_r2dbc_relationship.DDL.Scripts.SQL_GET_TASK;


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
@Slf4j
@Component
public class CrudRepo {

    @Autowired
    PostgresqlConnectionConfiguration.Builder connConfig;

    @Autowired
    TaskRepo r2dbcRepo;

    public Flux<Task> getTasksBySchema(String schema) {

        // configure connfactory with schema set on the builder
        PostgresqlConnectionFactory connFactory =
                connFactory
                        (
                                connConfig.schema(schema)
                        );

        DatabaseClient ddl = DatabaseClient.create(connFactory);

        return ddl.execute(SQL_GET_TASK)
                  .as(Task.class)
                  .fetch()
                  .all();
    }

    public Flux<Task> getTasksByDb_DbClient(String db) {

        connConfig.database(db);
        connConfig.schema(db);

        PostgresqlConnectionFactory connFactory = connFactory(connConfig);

        DatabaseClient ddl = DatabaseClient.create(connFactory);

        return ddl.execute(SQL_GET_TASK)
                  .as(Task.class)
                  .fetch()
                  .all();
    }

    private PostgresqlConnectionFactory connFactory
            (PostgresqlConnectionConfiguration.Builder connectionConfig) {
        return new PostgresqlConnectionFactory(
                connectionConfig.build()
        );
    }

}






package com.spring_webflux_r2dbc_relationship.DDL;

import com.spring_webflux_r2dbc_relationship.task.Task;
import com.spring_webflux_r2dbc_relationship.task.TaskRepo;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class CrudService {
    @Autowired
    private CrudRepo crudRepo;

    @Autowired
    private TaskRepo r2dbcRepo;

    @Autowired
    private PostgresqlConnectionConfiguration.Builder connConfig;

    @Autowired
    private PostgresqlConnectionFactory connFactory;

    @Autowired
    private Connection conn;

    public Flux<Task> getTasksBySchema(String schema) {
        return crudRepo.getTasksBySchema(schema);
    }

    public Flux<Task> getTasksByDb_DbClient(String Db) {
        return crudRepo.getTasksByDb_DbClient(Db);
    }

    public Flux<Task> getTasksByDb_R2dbcRepo(String db) {
        connConfig.database(db).build();
        connConfig.schema(db).build();

        connFactory.create();

        return r2dbcRepo.findAll();
    }


}

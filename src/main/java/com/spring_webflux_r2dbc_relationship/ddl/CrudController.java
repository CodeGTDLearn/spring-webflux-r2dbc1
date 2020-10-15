package com.spring_webflux_r2dbc_relationship.ddl;

import com.spring_webflux_r2dbc_relationship.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQ)
@RestController
public class CrudController {

    @Autowired
    private CrudService ddlProcService;

    @GetMapping(MAP + PATH_DDL_CRUD_SCHEMA)
    public Flux<Task> getTaskBySchema(@PathVariable("schema") String schema) {
        return ddlProcService.getTasksBySchema(schema);
    }

    @GetMapping(MAP + PATH_DDL_CRUD_DB_DBC)
    public Flux<Task> getTasksByDb_DbClient(@PathVariable("db") String db) {
        return ddlProcService.getTasksByDb_DbClient(db);
    }

    @GetMapping(MAP + PATH_DDL_CRUD_DB_REP)
    public Flux<Task> getTasksByDb_R2dbcRepo(@PathVariable("db") String db) {
        return ddlProcService.getTasksByDb_R2dbcRepo(db);
    }


}
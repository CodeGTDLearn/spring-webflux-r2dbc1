package com.spring_webflux_r2dbc_relationship.controllerDDL;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.serviceDDL.DDLCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQ)
@RestController
public class DDLCrudController {

    @Autowired
    private DDLCrudService ddlProcService;

    @GetMapping(MAP + PATH_DDL_CRUD_SCHEMA)
    public Flux<Task> getTaskBySchema(@PathVariable("schema") String schema) {
        return ddlProcService.getTasksBySchema(schema);
    }

    @GetMapping(MAP + PATH_DDL_CRUD_DB)
    public Flux<Task> getTaskByDb(@PathVariable("db") String db) {
        return ddlProcService.getTasksBySchema(db);
    }


}
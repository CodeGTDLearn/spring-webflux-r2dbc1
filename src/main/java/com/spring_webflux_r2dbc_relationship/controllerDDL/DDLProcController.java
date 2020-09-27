package com.spring_webflux_r2dbc_relationship.controllerDDL;

import com.spring_webflux_r2dbc_relationship.serviceDDL.DDLProcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQ)
@RestController
public class DDLProcController {

    @Autowired
    private DDLProcService ddlProcService;

    @PostMapping(MAP + PATH_DDL_PROC_SCHEMA)
    public Flux<Object> createBySchemma(
            @PathVariable("db") String db,
            @PathVariable("schema") String schema,
            @PathVariable("table") String table) {

        //todo: create one exception, when the user does not insert the DB
        return ddlProcService.createBySchemma(db,schema,table);
    }

    @PostMapping(MAP + PATH_DDL_PROC_DB)
    public Flux<Object> createByDb(
            @PathVariable("db") String db,
            @PathVariable("schema") String schema,
            @PathVariable("table") String table) {
        return ddlProcService.createByDb(db,schema,table);
    }


}
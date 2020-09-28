package com.spring_webflux_r2dbc_relationship.DDL;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import static com.spring_webflux_r2dbc_relationship.config.Routes.*;

@Slf4j
@RequestMapping(REQ)
@RestController
public class ProcController {

    @Autowired
    private ProcService procService;

    @PostMapping(MAP + PATH_DDL_PROC_SCHEMA)
    public Flux<Object> createDbBySchemma(
            @PathVariable("db") String db,
            @PathVariable("schema") String schema,
            @PathVariable("table") String table) {
        return procService.createDbBySchemma(db,schema,table);
    }

    @PostMapping(MAP + PATH_DDL_PROC_DB)
    public Flux<Object> createDbByDb(
            @PathVariable("db") String db,
            @PathVariable("schema") String schema,
            @PathVariable("table") String table) {
        return procService.createDbByDb(db,schema,table);
    }
}
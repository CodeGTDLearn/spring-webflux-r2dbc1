package com.spring_webflux_r2dbc_relationship.DDL;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class ProcService {

    @Autowired
    private ProcRepo ddl;

    public Flux<Object> createDbBySchemma(String db,String schema,String table) {
        return ddl.createSchemmaByDb(db,schema,table);
    }

    public Flux<Object> createDbByDb(String db,String schema,String table) {
        return ddl.createDbByDb(db,schema,table);
    }
}

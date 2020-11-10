package com.spring_webflux_r2dbc_relationship.ddl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class ProcService {

    @Autowired
    private com.spring_webflux_r2dbc_relationship.ddl.ProcRepo procRepo;

    public Flux<Object> createDbBySchemma(String db,String schema,String table) {
        return procRepo.createSchemmaByDb(db,schema,table);
    }

    public Flux<Object> createDbByDb(String db,String table) {
        return procRepo.createDbByDb(db,table);
    }
}

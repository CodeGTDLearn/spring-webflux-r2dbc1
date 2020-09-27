package com.spring_webflux_r2dbc_relationship.serviceDDL;

import com.spring_webflux_r2dbc_relationship.repoDDL.DDLProcRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class DDLProcService {

    @Autowired
    private DDLProcRepo ddl;

    public Flux<Object> createBySchemma(String db,String schema,String table) {
        return ddl.createBySchemma(db,schema,table);
    }

    public Flux<Object> createByDb(String db,String schema,String table) {
        return ddl.createByDb(db,schema,table);
    }
}

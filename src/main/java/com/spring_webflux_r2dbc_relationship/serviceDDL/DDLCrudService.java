package com.spring_webflux_r2dbc_relationship.serviceDDL;

import com.spring_webflux_r2dbc_relationship.entity.Task;
import com.spring_webflux_r2dbc_relationship.repoDDL.DDLCrudRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class DDLCrudService {
    @Autowired
    private DDLCrudRepo ddlCrudRepo;


    public Flux<Task> getTasksBySchema(String schema) {
        return ddlCrudRepo.getTasksBySchema(schema);
    }

    public Flux<Task> getTasksByDb(String Db) {
        return ddlCrudRepo.getTasksByDb(Db);
    }
}

package com.spring_webflux_r2dbc_relationship.conceptProof;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.r2dbc.core.DatabaseClient;
import reactor.test.StepVerifier;

public class ConceptProofH2 {

    private static final Log log = LogFactory.getLog(ConceptProofH2.class);

    public static void main(String[] args) {

        String dbUrl = "r2dbc:h2:mem:///test?options=DB_CLOSE_DELAY=-1;" +
                "DB_CLOSE_ON_EXIT=FALSE";

        ConnectionFactory connectionFactory = ConnectionFactories.get(dbUrl);


        DatabaseClient client = DatabaseClient.create(connectionFactory);

        client.execute("CREATE TABLE person" +
                               "(id VARCHAR(255) PRIMARY KEY," +
                               "name VARCHAR(255)," +
                               "age INT)")
              .fetch()
              .rowsUpdated()
              .as(StepVerifier::create)
              .expectNextCount(1)
              .verifyComplete();

        client.insert()
              .into(Person.class)
              .using(new Person("joe","Joe",34))
              .then()
              .as(StepVerifier::create)
              .verifyComplete();

        client.select()
              .from(Person.class)
              .fetch()
              .first()
              .doOnNext(it -> log.info(it))
              .as(StepVerifier::create)
              .expectNextCount(1)
              .verifyComplete();
    }

}

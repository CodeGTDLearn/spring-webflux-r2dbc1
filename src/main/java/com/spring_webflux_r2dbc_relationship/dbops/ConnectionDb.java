package com.spring_webflux_r2dbc_relationship.dbops;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.core.ReactiveDataAccessStrategy;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.support.R2dbcExceptionTranslator;
import reactor.test.StepVerifier;

@Slf4j
@Configuration
@EnableR2dbcRepositories
public class ConnectionDb extends AbstractR2dbcConfiguration {

    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration
                        .builder()
                        .host("db-r2dbc")
                        .port(5432)
                        .username("root")
                        .password("root")
                        .database("db-test")
                        .build());
    }

//    @Bean
//    public PostgresqlConnectionConfiguration.Builder postgresqlConnectionConfiguration() {
//        return PostgresqlConnectionConfiguration
//                .builder()
//                .host("db-r2dbc")
//                .port(5432)
//                .username("root")
//                .password("root")
//                .database("db-test");
//    }

//    @Bean
//    @Override
//    public PostgresqlConnectionFactory connectionFactory() {
//        return new PostgresqlConnectionFactory(
//                postgresqlConnectionConfiguration()
//                        .build());
//    }
}



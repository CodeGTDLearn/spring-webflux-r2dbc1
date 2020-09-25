package com.spring_webflux_r2dbc_relationship.dbops;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Slf4j
@Configuration
@EnableR2dbcRepositories
public class ConnectionDb extends AbstractR2dbcConfiguration {

    /*
     **********************************************
     * Spring Data R2dbc does not support JPA
     * In order to Spring Data makes DDL it should
     * works with JPA.
     * R2DBC
     *      DDL: In order to make DDL in Spring Data R2dbc
     *      is necessary to use R2dbc.DataBaseClient.
     *      DML: Can ben done with
     *       Spring Data R2dbc - R2dbcREpositories
     * ********************************************
     */
    @Bean
    public PostgresqlConnectionConfiguration.Builder connectionConfig() {
        return PostgresqlConnectionConfiguration
                .builder()
                .host("db-r2dbc")
                .port(5432)
                .username("root")
                .password("root")
                .database("db-test");
    }


    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        return
                new PostgresqlConnectionFactory(
                        connectionConfig().build()
                );
    }
}


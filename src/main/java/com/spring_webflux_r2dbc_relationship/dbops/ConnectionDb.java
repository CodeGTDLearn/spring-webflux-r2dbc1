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
     * Spring Data JDBC:
     *      DDL: does not support JPA.
     *
     * R2DBC
     *      DDL:
     *          -does no support JPA
     *          -To achieve DDL, uses R2dbc.DataBaseClient
     *
     *      DML:
     *          -it uses R2dbcREpositories
     *          -R2dbcRepositories is different than
     *          R2dbc.DataBaseClient
     * ********************************************
     */
    @Bean
    public PostgresqlConnectionConfiguration.Builder connectionConfig() {
        return PostgresqlConnectionConfiguration
                .builder()
                .host("db-r2dbc")
                .port(5432)
                .username("root")
                .password("root");
//                .database("db-test");
    }


    @Bean
    public PostgresqlConnectionFactory connectionFactory() {
        return
                new PostgresqlConnectionFactory(
                        connectionConfig().build()
                );
    }
}


package com.spring_webflux_r2dbc_relationship.dbops;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DDLScripts {

    public static final String SQL_GET_TASK_BY_SCHEMA = "select * from tasks";

    public static String sqlCreateDb(String db) {
        return "create database \"" + db + "\"";
    }

    public static String sqlCreateSchema(String schema) {
        return "CREATE SCHEMA IF NOT EXISTS \"" + schema + "\"";
    }

    public static String sqlCreateTable(String schema,String table) {
        String createTable =
                "create table " +
                        "\"" + schema + "\"." + table +
                        " (" +
                        "id serial not null constraint tasks_pk primary key, " +
                        "lastname varchar not null); ";

        String alterTable =
                "alter table \"" +
                        schema + "\"." + table +
                        " owner to root; ";

        return createTable + alterTable;
    }

    public static String sqlPopulateTable(String schema,String table) {

        return "insert into \"" +
                schema + "\"." + table +
                " values (1, 'schema-table-" + schema + "')";
    }
}



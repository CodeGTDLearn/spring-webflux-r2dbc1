package com.spring_webflux_r2dbc_relationship.dbops;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DbScripts {

    public static final String SQL_GET_TASK_BY_SCHEMA = "select * from tasks";

    public static String sqlCreateDb(String db) {


        String createDb = "create database \"" + db + "\"";

        return createDb;
    }

    public static String sqlCreateSchema(String schema) {
        return "CREATE SCHEMA IF NOT EXISTS \"" + schema + "\"";
    }

    public static String sqlCreateSchemaDb(String db,String schema) {
        return "CREATE SCHEMA IF NOT EXISTS \"" + db + "\".\"" + schema + "\"";
    }

    public static String sqlCreateTable(String schema,String table) {
        String createTable =
                "create table " +
                        "\"" + schema + "\"." + table +
                        " (" +
                        "id serial not null constraint tasks_pk primary key, " +
                        "lastname varchar not null); ";

        String alterTable = "alter table \"" + schema + "\"." + table + " owner to root; ";

        return createTable + alterTable;
    }


    public static String populateTable(String schema,String table) {
        String populateTable =
                "insert into \"" + schema + "\"." + table + " values (1, 'schema-table-" + schema + "')";

        return populateTable;
    }
}



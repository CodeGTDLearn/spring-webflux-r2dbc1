package com.spring_webflux_r2dbc_relationship.DDL;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;

import static java.lang.String.format;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Scripts {

    public static final String SQL_GET_TASK = "select * from tasks";

    public static String sqlCreateDb(String db) {
        String sql = "create database %1$s;";
        String[] sql1OrderedParams = quotify(new String[]{db});
        String finalSql = format(sql,(Object[]) sql1OrderedParams);
        return finalSql;
    }

    public static String sqlCreateSchema(String schema) {
        String sql = "create schema if not exists %1$s;";
        String[] sql1OrderedParams = quotify(new String[]{schema});
        return format(sql,(Object[])  sql1OrderedParams);
    }

    public static String sqlCreateTable(String schema,String table) {

        String sql1 = "create table %1$s.%2$s " +
                "(id serial not null constraint tasks_pk primary key, " +
                "lastname varchar not null); ";
        String[] sql1OrderedParams = quotify(new String[]{schema,table});
        String sql1Final = format(sql1,(Object[])  sql1OrderedParams);

        String sql2 = "alter table %1$s.%2$s owner to root; ";
        String[] sql2OrderedParams = quotify(new String[]{schema,table});
        String sql2Final = format(sql2,(Object[])  sql2OrderedParams);

        return sql1Final + sql2Final;
    }

    public static String sqlPopulateTable(String schema,String table) {

        String sql = "insert into %1$s.%2$s values (1, 'schema-table-%3$s');";
        String[] sql1OrderedParams = quotify(new String[]{schema,table,schema});
        return format(sql,(Object[]) sql1OrderedParams);
    }

    private static String[] quotify(String[] stringArray) {

        String[] returnArray = new String[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            returnArray[i] = "\"" + stringArray[i] + "\"";
        }
        return returnArray;
    }
}



package com.spring_webflux_r2dbc_relationship.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Routes {
    public static final String REQ ="/api";
    public static final String MAP ="/tasks";
    public static final String PATH_DDL_CRUD_DB_DBC ="/database/dbclient/{db}";
    public static final String PATH_DDL_CRUD_DB_REP ="/database/confactory/{db}";
    public static final String PATH_DDL_CRUD_SCHEMA ="/schema/{schema}";
    public static final String PATH_DDL_PROC_DB ="/database/{db}/{schema}/{table}";
    public static final String PATH_DDL_PROC_SCHEMA ="/schema/{db}/{schema}/{table}";
}

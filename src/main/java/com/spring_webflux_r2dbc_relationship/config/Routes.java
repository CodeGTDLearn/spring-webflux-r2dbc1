package com.spring_webflux_r2dbc_relationship.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Routes {
    public static final String REQ ="/api";
    public static final String MAP ="/tasks";
    public static final String PATH_SCHEMA ="/{schema}";
    public static final String PATH_DB ="/database/{db}";
    public static final String PATH_SCR_SCHEMA ="/{schema}/{table}";
    public static final String PATH_SCR_DB ="/database/{db}/{schema}/{table}";
}

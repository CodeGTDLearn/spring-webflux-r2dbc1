package com.spring_webflux_r2dbc_relationship.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table
public class Student {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
}

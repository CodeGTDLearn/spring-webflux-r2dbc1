package com.spring_webflux_r2dbc_relationship.entity;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@RequiredArgsConstructor
@Table("tasks")
public class Task {
    @Id
    private Integer id;

    @NonNull
    private String lastname;

    private boolean completed;
}

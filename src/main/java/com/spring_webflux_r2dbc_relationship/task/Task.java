package com.spring_webflux_r2dbc_relationship.task;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@RequiredArgsConstructor
@Table("tasks")
public class Task {
    @Id
    private Integer id;

    @NonNull
    private String lastname;
}

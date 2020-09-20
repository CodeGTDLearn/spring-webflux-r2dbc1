package com.spring_webflux_r2dbc_relationship.conceptProof;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Person {
    private String id;
    private String name;
    private int age;
}

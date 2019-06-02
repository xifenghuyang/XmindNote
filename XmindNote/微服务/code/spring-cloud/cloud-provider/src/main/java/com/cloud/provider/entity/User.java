package com.cloud.provider.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long id;
    private String username;
    private String name;
    private Integer age;
    private Double balance;
}

package com.microservice.cloud.microservicesimpleprovideruser.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;
    @Column
    private String name;
    @Column
    private Short age;
    @Column
    private BigDecimal balance;
}

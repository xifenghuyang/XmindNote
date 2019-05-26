package com.microservice.cloud.microservicesimpleconsumermovie.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User {
    private Long id;

    private String username;
    private String name;
    private Short age;
    private BigDecimal balance;
}

package com.saidtokmak.authorization.entity;

import jakarta.persistence.Entity;

@Entity
public class Privilege extends BaseEntity {

    private String name;
    private String code;
}

package com.goaltracker.authorization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Role extends BaseEntity {

    private String name;
    private String code;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Permission> permission;
}

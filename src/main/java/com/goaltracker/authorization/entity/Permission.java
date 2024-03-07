package com.goaltracker.authorization.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Permission extends BaseEntity {

    private String name;
    private String code;

}

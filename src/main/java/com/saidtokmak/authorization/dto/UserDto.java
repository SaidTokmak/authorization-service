package com.saidtokmak.authorization.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserDto {
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Date createdTime;
}

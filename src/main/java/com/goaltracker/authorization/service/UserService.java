package com.goaltracker.authorization.service;

import com.goaltracker.authorization.dto.CreateUpdateUserRequest;
import com.goaltracker.authorization.dto.UserDto;
import com.goaltracker.authorization.entity.User;

public interface UserService {

    UserDto register(CreateUpdateUserRequest request);
}

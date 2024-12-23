package com.saidtokmak.authorization.service;

import com.saidtokmak.authorization.dto.CreateUpdateUserRequest;
import com.saidtokmak.authorization.dto.LoginRequest;
import com.saidtokmak.authorization.dto.UserDto;
import com.saidtokmak.authorization.entity.User;

public interface UserService {

    UserDto register(CreateUpdateUserRequest request);
    User search(LoginRequest request);
    User getUserByEmail(String email);
}

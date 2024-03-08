package com.goaltracker.authorization.service.impl;

import com.goaltracker.authorization.dto.CreateUpdateUserRequest;
import com.goaltracker.authorization.dto.UserDto;
import com.goaltracker.authorization.entity.User;
import com.goaltracker.authorization.exception.UserAlreadyExistException;
import com.goaltracker.authorization.repository.UserRepository;
import com.goaltracker.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto register(CreateUpdateUserRequest request) {
        User userByEmail = userRepository.findByEmail(request.getEmail());

        if (Objects.nonNull(userByEmail)) {
            throw new UserAlreadyExistException("User already exist!");
        }

        User savedUser = userRepository.save(User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(request.getPassword()).build());

        return UserDto.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .createdTime(savedUser.getCreatedAt()).build();
    }
}

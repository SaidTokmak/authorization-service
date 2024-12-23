package com.saidtokmak.authorization.service.impl;

import com.saidtokmak.authorization.dto.CreateUpdateUserRequest;
import com.saidtokmak.authorization.dto.LoginRequest;
import com.saidtokmak.authorization.dto.UserDto;
import com.saidtokmak.authorization.entity.Role;
import com.saidtokmak.authorization.entity.User;
import com.saidtokmak.authorization.exception.UserAlreadyExistException;
import com.saidtokmak.authorization.repository.UserRepository;
import com.saidtokmak.authorization.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .roles(new HashSet<Role>(Collections.singletonList(Role.ROLE_USER))).build());

        return UserDto.builder()
                .id(savedUser.getId())
                .email(savedUser.getEmail())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .createdTime(savedUser.getCreatedAt()).build();
    }

    @Override
    public User search(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (Objects.equals(user.getPassword(), request.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}

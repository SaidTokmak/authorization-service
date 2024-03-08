package com.goaltracker.authorization.exception;

public class UserAlreadyExistException extends RuntimeException {
    String message;

    public UserAlreadyExistException(String message) {
        super(message);
    }
}

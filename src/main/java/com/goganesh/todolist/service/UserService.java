package com.goganesh.todolist.service;

import com.goganesh.todolist.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByLogin(String login);
}

package com.johnny.security1.dao;

import com.johnny.security1.entity.User;

import java.util.Optional;

public interface UserDao {

    Optional<User> selectUserByUsername(String username);
}

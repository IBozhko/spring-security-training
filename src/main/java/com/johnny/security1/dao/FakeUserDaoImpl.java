package com.johnny.security1.dao;

import com.google.common.collect.Lists;
import com.johnny.security1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.johnny.security1.security.UserRoleEnum.*;

@Repository("fake")
public class FakeUserDaoImpl implements UserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> selectUserByUsername(String username) {
        return getUsers()
                .stream()
                .filter(user -> username.equals(user.getUsername()))
                .findFirst();
    }

    private List<User> getUsers(){
        List<User> users = Lists.newArrayList(
                new User(
                        "albert",
                        passwordEncoder.encode("password"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "ann",
                        passwordEncoder.encode("password"),
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "bob",
                        passwordEncoder.encode("password"),
                        STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return users;
    }
}

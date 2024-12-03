package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();

    User getUser(long id);

    User deleteUser(long id);

    void createUser(User user, Set<Role> roles) throws AuthenticationException;

    void updateUser(User user, Set<Role> roles) throws AuthenticationException;

    User findByUsername(String username);
}

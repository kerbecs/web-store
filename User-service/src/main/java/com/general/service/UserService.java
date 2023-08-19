package com.general.service;


import com.general.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByUsername(String username);

    User save(User user);

    void deleteById(Long id);
}

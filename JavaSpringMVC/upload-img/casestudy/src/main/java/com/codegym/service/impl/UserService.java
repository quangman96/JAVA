package com.codegym.service.impl;

import com.codegym.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Iterable<User> findAll();
    User  findbyId(Long id);
    void save(User user);
    void remove(Long id);
}

package com.codegym.cms.repository;

import com.codegym.cms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String userName);
}

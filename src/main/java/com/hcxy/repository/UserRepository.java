package com.hcxy.repository;

import com.hcxy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sjming
 * @time 2017-08-30 23:56
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findByUsername(String username);
}

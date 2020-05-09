package com.wfx.projects.springboot.security_jwt.repository;

import com.wfx.projects.springboot.security_jwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gwei
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

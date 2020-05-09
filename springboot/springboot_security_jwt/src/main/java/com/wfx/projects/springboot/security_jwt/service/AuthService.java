package com.wfx.projects.springboot.security_jwt.service;

import com.wfx.projects.springboot.security_jwt.model.entity.User;

/**
 * @author Gwei
 */
public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
}

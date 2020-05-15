package com.wfx.projects.springcloud.userservice.service;

import com.wfx.projects.springcloud.userservice.pojo.User;

import java.util.List;

/**
 * @author Gwei
 */
public interface UserService {

    void insert(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> listUsersByIds(List<Long> ids);
}

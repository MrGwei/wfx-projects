package com.wfx.projects.springcloud.userservice.pojo;

import lombok.Data;

/**
 * @author Gwei
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

}

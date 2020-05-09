package com.wfx.projects.springboot.security_jwt.controller;

import com.wfx.projects.springboot.security_jwt.model.entity.User;
import com.wfx.projects.springboot.security_jwt.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

/**
 * @author Gwei
 */
@RestController
public class JwtAuthController {

    @Autowired
    private AuthService authService;

    // 登录
    @RequestMapping(value = "/authentication/login", method = RequestMethod.POST)
    public String createToken(String username,
                              String password)
            throws AuthenticationException {
        return authService.login(username, password); // 登录成功会返回JWT Token给用户
    }

    /**
     * 注册
     * {"username":"admin", "password":"admin", "roles":[{"name":"ROLE_ADMIN"},{"name":"ROLE_NORMAL"}]}
     * $2a$10$hcPWkI0qYGpt/rk8ShphhODTVUW9UiGvuG55b0UWjNHWohYq/9RxS
     *
     * {"username":"wfx", "password":"wfx", "roles":[{"name":"ROLE_NORMAL"}]}
     * $2a$10$H6R6kiQaJ4WPuLcXGuYQXOLCa/CYvILQctKSOrBKUATa6uodVvDT6
     * @param addedUser
     * @return
     * @throws AuthenticationException
     */
    @RequestMapping(value = "/authentication/register", method = RequestMethod.POST)
    public User register(@RequestBody User addedUser) throws AuthenticationException {
        return authService.register(addedUser);
    }

}

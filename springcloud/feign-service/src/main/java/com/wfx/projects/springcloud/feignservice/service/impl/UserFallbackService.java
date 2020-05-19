package com.wfx.projects.springcloud.feignservice.service.impl;

import com.wfx.projects.springcloud.feignservice.pojo.Result;
import com.wfx.projects.springcloud.feignservice.pojo.User;
import com.wfx.projects.springcloud.feignservice.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 对接口中的每个实现方法进行了服务降级逻辑的实现。
 * @author Gwei
 */
@Component
public class UserFallbackService implements UserService {

    @Override
    public Result insert(User user) {
        return new Result("调用失败，服务被降级",500);
    }

    @Override
    public Result<User> getUser(Long id) {
        return new Result("调用失败，服务被降级",500);
    }

    @Override
    public Result<List<User>> listUsersByIds(List<Long> ids) {
        return new Result("调用失败，服务被降级",500);
    }

    @Override
    public Result<User> getByUsername(String username) {
        return new Result("调用失败，服务被降级",500);
    }

    @Override
    public Result update(User user) {
        return new Result("调用失败，服务被降级",500);
    }

    @Override
    public Result delete(Long id) {
        return new Result("调用失败，服务被降级",500);
    }

}

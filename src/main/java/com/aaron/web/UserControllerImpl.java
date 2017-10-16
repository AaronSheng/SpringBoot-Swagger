package com.aaron.web;

import com.aaron.api.UserController;
import com.aaron.pojo.Result;
import com.aaron.pojo.User;
import com.aaron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Aaron Sheng on 2017/10/15.
 */
@Component
public class UserControllerImpl implements UserController {
    @Autowired
    private UserService userService;

    @Override
    public Result<User> get(Long userId) {
        return new Result<User>(userService.get(userId));
    }

    @Override
    public Result<Boolean> delete(Long userId) {
        userService.delete(userId);
        return new Result<Boolean>(true);
    }

    @Override
    public Result<Boolean> update(Long userId, String name) {
        userService.update(userId, name);
        return new Result<Boolean>(true);
    }
}

package com.aaron.web;

import com.aaron.pojo.Result;
import com.aaron.pojo.User;
import com.aaron.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaron Sheng on 2017/10/8.
 */
@Api(tags = "USER_USERS", description = "用户-用户管理")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("获取用户信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Result<User> get(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable Long userId) {
        return new Result<User>(userService.get(userId));
    }

    @ApiOperation("删除用户信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable Long userId) {
        userService.delete(userId);
        return new Result<Boolean>(true);
    }

    @ApiOperation("修改用户信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public Result<Boolean> update(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable Long userId,
            @ApiParam(value = "用户名称", required = true)
            String name) {
        userService.update(userId, name);
        return new Result<Boolean>(true);
    }
}

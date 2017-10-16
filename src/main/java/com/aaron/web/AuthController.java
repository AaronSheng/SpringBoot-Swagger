package com.aaron.web;

import com.aaron.pojo.Auth;
import com.aaron.pojo.Result;
import com.aaron.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aaron Sheng on 2017/10/14.
 */
@Api(tags = "AUTH_AUTH", description = "授权-授权管理")
@RestController
@RequestMapping("/auths")
public class AuthController {
    @Autowired
    private AuthService authService;

    @ApiOperation("获取授权信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public Result<Auth> get(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable Long userId)  {
        return new Result<Auth>(authService.get(userId));
    }

    @ApiOperation("删除授权信息")
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(
            @ApiParam(value = "用户ID", required = true)
            @PathVariable Long userId) {
        authService.delete(userId);
        return new Result<Boolean>(true);
    }
}

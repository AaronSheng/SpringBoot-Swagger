package com.aaron.web;

import com.aaron.api.AuthController;
import com.aaron.pojo.Auth;
import com.aaron.pojo.Result;
import com.aaron.service.AuthService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Aaron Sheng on 2017/10/15.
 */
@Component
public class AuthControllerImpl implements AuthController {
    @Autowired
    private AuthService authService;

    @Override
    public Result<Auth> get(Long userId) {
        return new Result<Auth>(authService.get(userId));
    }

    @Override
    public Result<Boolean> delete(Long userId) {
        authService.delete(userId);
        return new Result<Boolean>(true);
    }
}

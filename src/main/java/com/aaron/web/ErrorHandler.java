package com.aaron.web;

import com.aaron.exception.BadRequestException;
import com.aaron.exception.NotFoundException;
import com.aaron.pojo.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Aaron Sheng on 2017/10/14.
 */
@ControllerAdvice
@ResponseBody
public class ErrorHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> handleBadRequestException(BadRequestException e) {
        return new Result<Void>(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Result<Void> handleNotFoundException(NotFoundException e) {
        return new Result<Void>(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Void> handleException(Exception e) {
        return new Result<Void>(500, e.getMessage());
    }
}

package com.aaron.exception;

/**
 * Created by Aaron Sheng on 2017/10/15.
 */
public class NotFoundException extends RuntimeException {
    private Integer status;
    private String message;

    public NotFoundException(String message) {
        this.status = 404;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

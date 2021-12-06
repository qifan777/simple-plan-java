package com.jcheng.system.exception;

import cn.dev33.satoken.exception.NotLoginException;
import com.jcheng.common.constants.HttpStatus;
import com.jcheng.common.domain.R;
import com.jcheng.common.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public R<String> businessException(CustomException e) {
        if (e.getCode() == null) {
            return R.fail(e.getMessage());
        }
        return R.fail(e.getCode().intValue(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<String> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.fail(e.getMessage());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public R<String> validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return R.fail(message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<String> validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return R.fail(message);
    }

    @ExceptionHandler(NotLoginException.class)
    public R<String> notLogin(NotLoginException e) {
        log.error(e.getMessage(), e);
        return R.fail(HttpStatus.FORBIDDEN, e.getMessage());
    }
}

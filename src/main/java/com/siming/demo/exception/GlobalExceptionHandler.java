package com.siming.demo.exception;

import com.siming.demo.response.BaseException;
import com.siming.demo.response.ErrorEnum;
import com.siming.demo.response.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public Result bizExceptionHandler(BaseException e){
        logger.error("business error. the cause is：{}",e.getErrorMsg());
        return Result.error(e);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.debug("invalid parameter: {}", ex.getMessage());
        return Result.error(ErrorEnum.BAD_REQUEST);
    }

    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public Result exceptionHandler(Exception e){
        logger.error("unknown error. the cause is: {}",e.getMessage());
        return Result.error(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}

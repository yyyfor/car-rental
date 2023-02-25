package com.siming.demo.response;

import lombok.Builder;
import lombok.Data;

import static com.siming.demo.constant.Constant.SUCCESS_CODE;
import static com.siming.demo.constant.Constant.SUCCESS_MESSAGE;

@Builder
@Data
public class Result<T> {
    //status code
    private int code;
    //message
    private String msg;
    //data
    private T data;
    public Result() {

    }
    //constructor
    public Result(Integer code, String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //base exception result
    public static Result error(BaseException de){
        return Result.builder()
                .code(de.getErrorCode())
                .msg(de.getErrorMsg())
                .build();
    }
    //error enum result
    public static Result error(ErrorEnum errorEnum){
        return Result.builder()
                .code(errorEnum.getErrorCode())
                .msg(errorEnum.getErrorMsg())
                .build();
    }

    public static <T> Result success(T data) {
        return Result.builder()
                .code(SUCCESS_CODE)
                .msg(SUCCESS_MESSAGE)
                .data(data)
                .build();
    }

    public static Result success() {
        return Result.builder()
                .code(SUCCESS_CODE)
                .msg(SUCCESS_MESSAGE)
                .build();
    }

    public static Result fail() {
        return Result.builder()
                .code(ErrorEnum.INTERNAL_SERVER_ERROR.getErrorCode())
                .msg(ErrorEnum.INTERNAL_SERVER_ERROR.getErrorMsg())
                .build();
    }

    public static Result result(boolean success) {
        return success ? Result.success() : Result.fail();
    }

}

package com.siming.demo.response;

public class BaseException extends RuntimeException{

    protected int errorCode;
    protected String errorMsg;

    public BaseException() {

    }

    public BaseException(ErrorEnum errorEnum) {
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = errorEnum.getErrorMsg();
    }

    public BaseException(ErrorEnum errorEnum, String msg) {
        this.errorCode = errorEnum.getErrorCode();
        this.errorMsg = msg;
    }
    public BaseException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}

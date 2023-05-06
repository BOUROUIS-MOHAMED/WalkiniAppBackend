package com.walkini.models;
import java.util.Objects;


public class Response {

    private  Object Object;
    private  String Message;
    private  Integer ErrorCode;
    private  boolean ThereIsAnError ;
    private  ErrorResponseType ErrorType=ErrorResponseType.Nothing;

    public Response(Object object, String message, Integer errorCode, boolean thereIsAnError, ErrorResponseType errorType) {
        Object=object;
        Message = message;
        ErrorCode = errorCode;
        ThereIsAnError = thereIsAnError;
        ErrorType = errorType;
    }
    public Response(String message, Integer errorCode, boolean thereIsAnError, ErrorResponseType errorType) {

        Message = message;
        ErrorCode = errorCode;
        ThereIsAnError = thereIsAnError;
        ErrorType = errorType;
    }

    public Response() {
    }

    public java.lang.Object getObject() {
        return Object;
    }

    public void setObject(java.lang.Object object) {
        Object = object;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        ErrorCode = errorCode;
    }

    public boolean isThereIsAnError() {
        return ThereIsAnError;
    }

    public void setThereIsAnError(boolean thereIsAnError) {
        ThereIsAnError = thereIsAnError;
    }

    public String getErrorType() {
        return ErrorType.toString();
    }

    public void setErrorType(ErrorResponseType errorType) {
        ErrorType = errorType;
    }

    @Override
    public String toString() {
        return "Response{" +
                "Message='" + Message + '\'' +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", ThereIsAnError=" + ThereIsAnError +
                ", ErrorType='" + ErrorType + '\'' +
                '}';
    }
}


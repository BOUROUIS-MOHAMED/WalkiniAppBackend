package com.walkini.models;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public class ResponseModel {

    private  Object Object=null;
    private  String Message="";
    private  Integer returnedInteger=null;
    private  String returnedString=null;
    private  Boolean returnedBoolean=null;
    private MultipartFile returnedMultipartFile=null;
    private List returnedList=List.of();
    private  String ErrorCode="000000";
    private  Boolean ThereIsAnError=true;
    private  ErrorResponseType ErrorType=ErrorResponseType.Nothing;

    public ResponseModel() {
    }

    public ResponseModel(java.lang.Object object, String message, Integer returnedInteger, String returnedString,Boolean returnedBoolean, MultipartFile returnedMultipartFile, List returnedList, String errorCode, Boolean thereIsAnError, ErrorResponseType errorType) {
        Object = object;
        Message = message;
        this.returnedInteger = returnedInteger;
        this.returnedString = returnedString;
        this.returnedMultipartFile = returnedMultipartFile;
        this.returnedList = returnedList;
        this.returnedBoolean=returnedBoolean;
        ErrorCode = errorCode;
        ThereIsAnError = thereIsAnError;
        ErrorType = errorType;
    }

    public java.lang.Object getObject() {
        return Object;
    }

    public void setObject(java.lang.Object object) {
        Object = object;
    }

    public Boolean getReturnedBoolean() {
        return returnedBoolean;
    }

    public void setReturnedBoolean(Boolean returnedBoolean) {
        this.returnedBoolean = returnedBoolean;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getReturnedInteger() {
        return returnedInteger;
    }

    public void setReturnedInteger(Integer returnedInteger) {
        this.returnedInteger = returnedInteger;
    }

    public String getReturnedString() {
        return returnedString;
    }

    public void setReturnedString(String returnedString) {
        this.returnedString = returnedString;
    }

    public MultipartFile getReturnedMultipartFile() {
        return returnedMultipartFile;
    }

    public void setReturnedMultipartFile(MultipartFile returnedMultipartFile) {
        this.returnedMultipartFile = returnedMultipartFile;
    }

    public List getReturnedList() {
        return returnedList;
    }

    public void setReturnedList(List returnedList) {
        this.returnedList = returnedList;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public Boolean getThereIsAnError() {
        return ThereIsAnError;
    }

    public void setThereIsAnError(Boolean thereIsAnError) {
        ThereIsAnError = thereIsAnError;
    }

    public ErrorResponseType getErrorType() {
        return ErrorType;
    }

    public void setErrorType(ErrorResponseType errorType) {
        ErrorType = errorType;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "Object=" + Object +
                ", Message='" + Message + '\'' +
                ", returnedInteger=" + returnedInteger +
                ", returnedString='" + returnedString + '\'' +
                ", returnedBoolean=" + returnedBoolean +
                ", returnedMultipartFile=" + returnedMultipartFile +
                ", returnedList=" + returnedList +
                ", ErrorCode='" + ErrorCode + '\'' +
                ", ThereIsAnError=" + ThereIsAnError +
                ", ErrorType=" + ErrorType +
                '}';
    }
}


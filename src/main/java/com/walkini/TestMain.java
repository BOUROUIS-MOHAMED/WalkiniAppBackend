// Java Program to Illustrate Object to JSON Conversion

package com.walkini;

// Importing required classes

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walkini.models.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


// Class
public class TestMain {

    // Main driver method
    public static void main(String[] a) {
/*
ResponseModel response=new ResponseModel();
Integer id=6;
        String str= "5---9---11---19---13";
        List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
        if (!myList.contains(id.toString())){
            myList.add(id.toString());
            String s=(String.join("---",myList));
            response.setMessage("the ["+ str +"] boost joined with the boost id="+ id +" to the list Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(myList);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(myList);
            response.setReturnedString(s);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("this user already had this boost");
            response.setErrorType(ErrorResponseType.DataAlreadyExist);
            response.setReturnedBoolean(false);
            response.setObject(myList);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(myList);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }


        System.out.println(response.toString());
    }
    ResponseModel response=new ResponseModel();

    public ResponseModel TestsetBoostToUser(Integer id,Integer userId) {


        String str= "5---9---11---19---13";
        List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));

        myList.add(id.toString());
        String s=(String.join("---",myList));
        response.setMessage("the ["+ str +"] boost joined with the boost id="+ id +" to the list Successfully");
        response.setErrorType(ErrorResponseType.Nothing);
        response.setReturnedBoolean(true);
        response.setObject(myList);
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setReturnedInteger(null);
        response.setReturnedList(myList);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);



        System.out.println(response);
        return response;
    }*/
        LocalDateTime restoredDate=LocalDateTime.parse(LocalDateTime.now().toString());
        LocalDateTime userDate=LocalDateTime.parse("2023-05-17T00:56:35.479778");
        System.out.println("restored date="+restoredDate);
        System.out.println("userDate date="+userDate);
        System.out.println("is the user need to download data ?"+restoredDate.isAfter(userDate));
        System.out.println("is the userDate before the app date  ?"+restoredDate.isBefore(userDate));

}}




// Method
// Getting the data to be inserted
// into the object


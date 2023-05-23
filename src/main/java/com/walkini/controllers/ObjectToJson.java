// Java Program to Illustrate Object to JSON Conversion

package com.walkini.controllers;

// Importing required classes

import com.fasterxml.jackson.databind.ObjectMapper;
import com.walkini.models.*;

import java.io.IOException;


// Class
public class ObjectToJson {

    // Main driver method
    public static void main(String[] a) {
        // Creating object of Organisation
        NotificationModel org = new NotificationModel();

        // Insert the data into the object


        // Creating Object of ObjectMapper define in Jackson
        // Api
        ObjectMapper Obj = new ObjectMapper();

        // Try block to check for exceptions
        try {

            // Getting organisation object as a json string
            String jsonStr = Obj.writeValueAsString(org);

            // Displaying JSON String on console
            System.out.println(jsonStr);
        }

        // Catch block to handle exceptions
        catch (IOException e) {

            // Display exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }};


    // Method
    // Getting the data to be inserted
    // into the object


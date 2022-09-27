package com.clevershuttle.carmanagement.exception;

public class CarDetailsNotFoundException extends RuntimeException{

    public CarDetailsNotFoundException(String message){
        super(message);
    }
}

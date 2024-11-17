package com.managementsystem.employeemanagement.exceptionhandling;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}

package com.parkirin.exception;

public class EntityExcistException extends RuntimeException{

    public EntityExcistException() {
        super("Data is excist");
    }

    public EntityExcistException(String message) {
        super(message);
    }
}

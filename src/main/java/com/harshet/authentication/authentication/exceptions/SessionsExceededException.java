package com.harshet.authentication.authentication.exceptions;

public class SessionsExceededException extends RuntimeException {
    public SessionsExceededException(String exception){
        super(exception);
    }
}

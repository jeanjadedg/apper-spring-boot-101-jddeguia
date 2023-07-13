package com.apper.theblogservice.exception;

public class EmailAlreadyRegisteredException extends Exception {
    public EmailAlreadyRegisteredException(String s) {
        super(s);
    }
}
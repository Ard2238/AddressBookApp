package com.spring.addressbook.exceptions;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String message){
        super(message);
    }
}

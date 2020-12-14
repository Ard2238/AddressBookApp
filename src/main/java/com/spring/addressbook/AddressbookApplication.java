package com.spring.addressbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressbookApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Application");
        SpringApplication.run(AddressbookApplication.class, args);
    }

}

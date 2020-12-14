package com.spring.addressbook;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class AddressbookApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to the Address Book Application");
        ApplicationContext context = SpringApplication.run(AddressbookApplication.class, args);
        log.info("Employee Payroll Application started in {} environment", context.getEnvironment().getProperty("environment"));
    }

}

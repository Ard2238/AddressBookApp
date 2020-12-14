package com.spring.addressbook.dto;

import javax.validation.constraints.Pattern;

public class ContactDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Invalid Full Name")
    public String fullName;
    public String address, city, state;
    public int zipcode;
    public long phone;

    public ContactDTO(String fullName, String address, String city, String state, int zipcode, long phone) {
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", phone=" + phone +
                '}';
    }
}

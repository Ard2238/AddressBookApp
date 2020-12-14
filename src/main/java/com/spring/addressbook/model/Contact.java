package com.spring.addressbook.model;

import com.spring.addressbook.dto.ContactDTO;
import lombok.Data;

@Data
public class Contact {
    public String fullName, address, city, state;
    int zipcode, contactId;
    long phone;

    public Contact(ContactDTO contactDTO, int contactId) {
        this.fullName = contactDTO.fullName;
        this.address = contactDTO.address;
        this.city = contactDTO.city;
        this.state = contactDTO.state;
        this.zipcode = contactDTO.zipcode;
        this.contactId = contactId;
        this.phone = contactDTO.phone;
    }
}

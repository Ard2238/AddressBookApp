package com.spring.addressbook.services;

import com.spring.addressbook.dto.ContactDTO;
import com.spring.addressbook.model.Contact;

import java.util.List;

public interface IAddressBookService {
    List<Contact> getContactDetails();
    Contact getContactDetailsById(int conId);
    Contact createContactDetails(ContactDTO contactDTO);
    Contact updateContactDetails(ContactDTO contactDTO);
    void deleteContactDetails(int conId);
}

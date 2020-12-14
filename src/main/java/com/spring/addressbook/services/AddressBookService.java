package com.spring.addressbook.services;

import com.spring.addressbook.dto.ContactDTO;
import com.spring.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {
    @Override
    public List<Contact> getContactDetails() {
        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact(new ContactDTO("Abhishek Das", "DLF", "GGN", "HR", 122002, 987654321), 1));
        return contactList;
    }

    @Override
    public Contact getContactDetailsById(int conId) {
        Contact contact = null;
        contact = new Contact(new ContactDTO("Abhishek Das", "DLF", "GGN", "HR", 122002, 987654321), 1);
        return contact;
    }

    @Override
    public Contact createContactDetails(ContactDTO contactDTO) {
        Contact contact = null;
        contact = new Contact(contactDTO, 1);
        return contact;
    }

    @Override
    public Contact updateContactDetails(ContactDTO contactDTO) {
        Contact contact = null;
        contact = new Contact(contactDTO, 1);
        return contact;
    }

    @Override
    public void deleteContactDetails(int conId) {

    }
}

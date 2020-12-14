package com.spring.addressbook.services;

import com.spring.addressbook.dto.ContactDTO;
import com.spring.addressbook.exceptions.ContactNotFoundException;
import com.spring.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    private List<Contact> contactList = new ArrayList<>();
    @Override
    public List<Contact> getContactDetails() {
        return contactList;
    }

    @Override
    public Contact getContactDetailsById(int conId) {
        return contactList.stream().filter(contact -> contact.getContactId() == conId)
                .findFirst().orElseThrow(()-> new ContactNotFoundException("Contact Not Found"));
    }

    @Override
    public Contact createContactDetails(ContactDTO contactDTO) {
        Contact contact = null;
        contact = new Contact(contactDTO, contactList.size()+1);
        contactList.add(contact);
        return contact;
    }

    @Override
    public Contact updateContactDetails(int conId, ContactDTO contactDTO) {
        Contact contact = this.getContactDetailsById(conId);
        contact.setFullName(contactDTO.fullName);
        contact.setAddress(contactDTO.address);
        contact.setCity(contactDTO.city);
        contact.setState(contactDTO.state);
        contact.setZipcode(contactDTO.zipcode);
        contact.setPhone(contactDTO.phone);
        contactList.set(conId-1, contact);
        return contact;
    }

    @Override
    public void deleteContactDetails(int conId) {
        contactList.remove(conId-1);
    }
}

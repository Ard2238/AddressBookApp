package com.spring.addressbook.controllers;

import com.spring.addressbook.dto.ContactDTO;
import com.spring.addressbook.dto.ResponseDTO;
import com.spring.addressbook.model.Contact;
import com.spring.addressbook.services.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adbookservice")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDTO> getContactDetails(){
        List<Contact> contactList = null;
        contactList = addressBookService.getContactDetails();
        ResponseDTO responseDTO = new ResponseDTO("Successfully completed GET Request", contactList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{conId}")
    public ResponseEntity<ResponseDTO> getContactDetailsById(@PathVariable("conId") int conId){
        Contact contact = null;
        contact = addressBookService.getContactDetailsById(conId);
        ResponseDTO responseDTO = new ResponseDTO("Success: Get Call By Id", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactDetails(@RequestBody ContactDTO contactDTO){
        Contact contact = null;
        contact = addressBookService.createContactDetails(contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Contact", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{conId}")
    public ResponseEntity<ResponseDTO> updateContactDetails(@PathVariable("conId") int conId, @RequestBody ContactDTO contactDTO){
        Contact contact = null;
        contact = addressBookService.updateContactDetails(conId,contactDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Contact Successfully", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{conId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("conId") int conId){
        addressBookService.deleteContactDetails(conId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + conId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}

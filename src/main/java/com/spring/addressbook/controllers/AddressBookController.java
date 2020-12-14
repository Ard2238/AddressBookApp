package com.spring.addressbook.controllers;

import com.spring.addressbook.dto.ContactDTO;
import com.spring.addressbook.dto.ResponseDTO;
import com.spring.addressbook.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adbookservice")
public class AddressBookController {

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<ResponseDTO> getContactDetails(){
        Contact contact = null;
        contact = new Contact(new ContactDTO("Abhishek Das", "DLF", "GGN", "HR", 122002, 987654321), 1);
        ResponseDTO responseDTO = new ResponseDTO("Successfully completed GET Request", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{conId}")
    public ResponseEntity<ResponseDTO> getContactDetailsById(@PathVariable("conId") int conId){
        Contact contact = null;
        contact = new Contact(new ContactDTO("Abhishek Das", "DLF", "GGN", "HR", 122002, 987654321), 1);
        ResponseDTO responseDTO = new ResponseDTO("Success: Get Call By Id", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addContactDetails(@RequestBody ContactDTO contactDTO){
        Contact contact = null;
        contact = new Contact(contactDTO, 1);
        ResponseDTO responseDTO = new ResponseDTO("Created Contact", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{conId}")
    public ResponseEntity<ResponseDTO> updateContactDetails(@PathVariable("conId") int conId, @RequestBody ContactDTO contactDTO){
        Contact contact = null;
        contact = new Contact(contactDTO, conId);
        ResponseDTO responseDTO = new ResponseDTO("Updated Contact Successfully", contact);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{conId}")
    public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("conId") int conId){
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + conId);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}

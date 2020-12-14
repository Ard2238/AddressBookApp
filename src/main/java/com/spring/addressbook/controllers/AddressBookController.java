package com.spring.addressbook.controllers;

import com.spring.addressbook.dto.ContactDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adbookservice")
public class AddressBookController {

    @RequestMapping(value = {"", "/", "get"})
    public ResponseEntity<String> getContactDetails(){
        return new ResponseEntity<String>("Successfully completed GET Request", HttpStatus.OK);
    }

    @GetMapping("/get/{conId}")
    public ResponseEntity<String> getContactDetailsById(@PathVariable("conId") int conId){
        return new ResponseEntity<String>("Success: Get Call By Id", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addContactDetails(@RequestBody ContactDTO contactDTO){
        return new ResponseEntity<String>("Created Contact for " + contactDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{conId}")
    public ResponseEntity<String> updateContactDetails(@PathVariable("conId") int conId, @RequestBody ContactDTO contactDTO){
        return new ResponseEntity<String>("Update Contact Details Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{conId}")
    public ResponseEntity<String> deleteContact(@PathVariable("conId") int conId){
        return new ResponseEntity<String>("Deleted Contact Successfully", HttpStatus.OK);
    }

}

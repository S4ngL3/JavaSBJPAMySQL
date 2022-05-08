package com.example.demo.api;

import java.util.List;

import com.example.demo.model.OperationModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ContactModel;
import com.example.demo.service.ContactService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ContactController {
    public static Logger logger = LoggerFactory.getLogger(ContactController.class);
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public ResponseEntity<List<ContactModel>> listAllContact(){
        List<ContactModel> listContact= contactService.getAllContacts();
        if(listContact.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ContactModel>>(listContact, HttpStatus.OK);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public ContactModel saveContact(@Valid @RequestBody ContactModel model) {
        return contactService.createContact(model);
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public ContactModel findContact(@PathVariable("id") long id) {
        ContactModel model= contactService.getById(id);
        return model;
    }

    @RequestMapping(value = "/contact", method = RequestMethod.PUT)
    public ResponseEntity<ContactModel> updateContact(@Valid @RequestBody ContactModel model) {
        return ResponseEntity.ok(contactService.updateContact(model));
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<OperationModel> deleteContact(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok(contactService.deleteContact(id));
    }
}


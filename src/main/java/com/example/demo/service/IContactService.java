package com.example.demo.service;

import com.example.demo.entity.Contact;
import com.example.demo.model.ContactModel;
import com.example.demo.model.OperationModel;

import java.util.List;

public interface IContactService {
    List<ContactModel> getAllContacts();
    ContactModel getById(long id);
    ContactModel createContact(ContactModel model);
    ContactModel updateContact(ContactModel model);
    OperationModel deleteContact(long id);
}

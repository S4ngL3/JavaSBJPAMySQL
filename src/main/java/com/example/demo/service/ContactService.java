package com.example.demo.service;

import com.example.demo.entity.Contact;
import com.example.demo.model.ContactModel;
import com.example.demo.model.OperationModel;
import com.example.demo.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService implements IContactService {
    private final ContactRepository _contactRepository;
    public ContactService(ContactRepository contactRepository){
        super();
        this._contactRepository = contactRepository;
    }
    @Override
    public List<ContactModel> getAllContacts(){
        List<Contact> contacts = _contactRepository.findAll();
        List<ContactModel> contactModels = new ArrayList<>();
        contacts.forEach(c -> {
            ContactModel cm = new ContactModel();
            cm.setId(c.getId());
            cm.setName(c.getName());
            cm.setAge(c.getAge());
            cm.setDob(c.getDob());
            cm.setEmail(c.getEmail());
            contactModels.add(cm);
        });

        return  contactModels;
    }

    @Override
    public ContactModel getById(long id) {
        ContactModel model = new ContactModel();
        try {
            Contact c = _contactRepository.getById(id);
            model.setResult(1);
            model.setMessage("Success");
            model.fromEntity(c);
        }
        catch (Exception ex){
            model.setResult(-1);
            model.setMessage("Failed with error: " + ex.getMessage());
        }
        return model;
    }

    @Override
    public ContactModel createContact(ContactModel model) {
        Contact contact = new Contact();
        contact.fromModel(model);
        contact = _contactRepository.save(contact);
        model.setId(contact.getId());
        return model;
    }
    public ContactModel updateContact(ContactModel model){
        ContactModel res = new ContactModel();
        Contact contact = _contactRepository.getById(model.getId());
        contact.setName(model.getName());
        contact.setAge(model.getAge());
        contact.setDob(model.getDob());
        contact.setEmail(model.getEmail());
        contact = _contactRepository.save(contact);
        res.fromEntity(contact);
        return res;
    }

    @Override
    public OperationModel deleteContact(long id) {
        ContactModel res = new ContactModel();
        res.setResult(1);
        res.setMessage("Success");
        try {
            _contactRepository.deleteById(id);
        }
        catch (Exception ex){
            res.setResult(-1);
            res.setMessage("Errors: " + ex.getMessage() + " when delet Contact with id = " + id);
        }
        return res;
    }
}


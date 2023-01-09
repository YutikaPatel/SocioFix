package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@RestController
public class ContactController {

	@Autowired
	ContactRepository contactRepository;
	
	@PostMapping("/saveContact")
	public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
		System.out.println("in controller");
		//System.out.println(contact.firstName+ " "+ contact.lastName) ;
		return ResponseEntity.ok(contactRepository.save(contact));
		

	}
	
	
	@GetMapping("/fetchContactList")
	public ResponseEntity<List<Contact>> getAllContacts() {

		return ResponseEntity.ok(contactRepository.findAll());

	}
	
}

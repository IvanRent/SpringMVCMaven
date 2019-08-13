package org.contact.service;

import java.util.List;

import org.contact.dao.ContactDao;
import org.contact.modelo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ContactServiceImpl implements ContactService{
@Autowired
	private ContactDao dao;

	@Transactional
	public void addContact(Contact contact) {
		dao.addContact(contact);
		
	}

	@Transactional
	public List<Contact> listContact() {
		
		return dao.listContact();
	}

	@Transactional
	public Contact getContactById(Integer id) {
		
		return dao.getContactById(id);
	}

	@Transactional
	public void deleteContact(Integer id) {
	dao.deleteContact(id);
		
	}

}

package org.contact.service;

import java.util.List;

import org.contact.modelo.Contact;

public interface ContactService 
{
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public Contact getContactById(Integer id);
	public void deleteContact(Integer id);
}

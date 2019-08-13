package org.contact.dao;

import java.util.List;

import org.contact.modelo.Contact;

public interface ContactDao 
{
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public Contact getContactById(Integer id);
	public void deleteContact(Integer id);
}

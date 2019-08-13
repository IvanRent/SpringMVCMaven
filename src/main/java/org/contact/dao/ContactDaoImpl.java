package org.contact.dao;

import java.util.List;

import org.contact.modelo.Contact;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ContactDaoImpl implements ContactDao
{
@Autowired
private SessionFactory sessionFactory;


	@Override
	public void addContact(Contact contact) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(contact);
		} catch (HibernateException e) {
		System.out.println("Exception add: "+ e.getMessage());
		}		
	}
	@SuppressWarnings("unckecked")
	@Override
	public List<Contact> listContact() {
		List<Contact> list= null;
		try {
			list = (List<Contact>)
					sessionFactory.getCurrentSession().createQuery("from Contact").list();
		} catch (HibernateException e) {
			System.out.println("Exception list: "+e.getMessage());
		}
		return list;
	}

	@Override
	public Contact getContactById(Integer id) {
	Contact contact= null;
	try {
		contact =(Contact)
				sessionFactory.getCurrentSession().get(Contact.class, id);
	} catch (HibernateException e) {
		System.out.println("Exception: " + e.getMessage());
	}
		return contact;
	}

	@Override
	public void deleteContact(Integer id) {
		Contact contact = null;
		try {
			contact = (Contact)
					sessionFactory.getCurrentSession().load(Contact.class, id);
			if(contact!= null)
			{
				sessionFactory.getCurrentSession().delete(contact);
			}
		} catch (HibernateException e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
	}

	
}

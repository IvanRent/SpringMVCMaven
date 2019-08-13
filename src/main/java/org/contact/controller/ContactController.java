package org.contact.controller;

import java.util.Map;

import org.contact.modelo.Contact;
import org.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//Map, model: son tipos de collections;
//@ModelAttribute: obtiene el valor del objeto, getModel()
//BindingResult: obtiene filas y columnas de la tabla..
//@PathVariable: recupera un valor o dato de memoria.
@Controller
public class ContactController 
{
	 @Autowired
	 private ContactService service;
	 
	 
	 @RequestMapping(value="/index")
	 public String listContact(Map<String,Object> map)
	 {
		 map.put("contact", new Contact());		 
		 map.put("contactList", service.listContact());
		 return "contactForm";
	 }
	 
	 @RequestMapping(value="/contact/add", method=RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result)
	 {
		 service.addContact(contact);
		 return "redirect:/index";
	 }
	 
	 @RequestMapping(value="/delete/{id}")
	public String deleteContact(@PathVariable("id") Integer id)
	 {
		 service.deleteContact(id);
		 return "redirect:/index";
	 }
	 
	 
	 //Ya no lleva el metodo post
	 @RequestMapping(value="/edit/{id}")
	public String editContact(@PathVariable("id") int id, Model model)
	 {
		model.addAttribute("contact", service.getContactById(id));
		model.addAttribute("contactList", service.listContact());
		 return "contactForm";
	 }
}

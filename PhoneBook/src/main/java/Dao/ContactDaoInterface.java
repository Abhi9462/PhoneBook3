package Dao;

import java.util.ArrayList;

import Model.Contact;

public interface ContactDaoInterface {
public boolean createContact(Contact contact);
public Contact searchContact(int id);
public ArrayList<Contact> contactList(int id);
public boolean deleteContact(int id);
public boolean updateContact(Contact contact);
}

package oblig5a.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public interface AddressBook extends Serializable, Iterable<ContactDetails> {

	/**
	   * Add a new contact to the address book.
	   *
	   * @param contact The contact to be added.
	   */
	void addContact(ContactDetails contact);

	/**
	   * Remove the contact with the given phonenumber from the address book.
	   * The phone number should be one that is currently in use.
	   *
	   * @param phoneNumber The phone number to the contact to remove
	   */
	void removeContact(String phoneNumber);

	/**
	   * Returns all the contacts as a collection.
	   *
	   * @return all the contacts as a collection.
	   */
	Collection<ContactDetails> getAllContacts();

	Iterator<ContactDetails> iterator();
	
	/**
	 * This will dispose of any resources used for handling AddressBook.
	 */
	default void dispose() {}

}
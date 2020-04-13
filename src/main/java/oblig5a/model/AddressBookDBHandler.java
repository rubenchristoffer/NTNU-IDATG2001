package oblig5a.model;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class AddressBookDBHandler implements AddressBook {

	private static final long serialVersionUID = 2602386062822230303L;

	private final EntityManagerFactory emf;

	public AddressBookDBHandler(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addContact(ContactDetails contact) {
		EntityManager em = getEM();

		try {
			em.getTransaction().begin();
			em.persist(contact);
			em.getTransaction().commit();
		} finally {
			closeEMIfPossible(em);
		}
	}

	@Override
	public void removeContact(String phoneNumber) {
		EntityManager em = getEM();

		try {
			ContactDetails contact = findContact(phoneNumber);

			em.getTransaction().begin();
			em.remove(em.merge(contact));
			em.getTransaction().commit();
		} finally {
			closeEMIfPossible(em);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<ContactDetails> getAllContacts() {
		EntityManager em = getEM();

		try {
			Query query = em.createQuery("SELECT cd FROM ContactDetails cd");

			return query.getResultList();
		} finally {
			closeEMIfPossible(em);
		}
	}

	@Override
	public Iterator<ContactDetails> iterator() {
		return getAllContacts().iterator();
	}

	@Override
	public void dispose() {
		emf.close();
	}

	private ContactDetails findContact(String phoneNumber) {
		EntityManager em = getEM();

		try {
			return em.find(ContactDetails.class, phoneNumber);
		} finally {
			closeEMIfPossible(em);
		}
	}

	private void closeEMIfPossible(EntityManager em) {
		if (em != null && em.isOpen())
			em.close();
	}

	private EntityManager getEM() {
		return emf.createEntityManager();
	}

}

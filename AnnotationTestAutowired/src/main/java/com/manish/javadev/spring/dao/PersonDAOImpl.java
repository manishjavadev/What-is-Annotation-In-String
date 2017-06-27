package com.manish.javadev.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manish.javadev.spring.model.Person;

/**
 * @author Manish
 * 
 */
@Repository
public class PersonDAOImpl implements PersonDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(PersonDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addPerson(Person p) {
		Session session = this.sessionFactory.openSession();
		session.persist(p);
		session.flush();
		session.close();
		logger.info("Person saved successfully, Person Details=" + p);
	}

	public void updatePerson(Person p) {
		Session session = this.sessionFactory.openSession();
		session.update(p);
		session.flush();
		session.close();
		logger.info("Person updated successfully, Person Details=" + p);
	}

	@SuppressWarnings("unchecked")
	public List<Person> listPersons() {
		Session session = this.sessionFactory.openSession();
		List<Person> personsList = session.createQuery("from Person").list();
		for (Person p : personsList) {
			logger.info("Person List::" + p);
		}
		session.close();
		return personsList;
	}

	public Person getPersonById(int id) {
		Session session = this.sessionFactory.openSession();
		Person p = (Person) session.load(Person.class, id);

		logger.info("Person loaded successfully, Person details=" + p);
		session.close();
		return p;
	}

	public void removePerson(int id) {
		Session session = this.sessionFactory.openSession();
		Person p = (Person) session.load(Person.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		session.flush();
		session.close();
		logger.info("Person deleted successfully, person details=" + p);
	}

}

package com.manish.javadev.spring.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.spring.dao.PersonDAO;
import com.manish.javadev.spring.model.Person;

@Component("personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	@Qualifier("personDAO1")
	private PersonDAO personDAO;

	public void addPerson(Person person) {
		this.personDAO.addPerson(person);
	}

	public void updatePerson(Person person) {
		this.personDAO.updatePerson(person);
	}

	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Transactional
	public Person getPersonById(int id) {
		return this.personDAO.getPersonById(id);
	}

	@Transactional
	public void removePerson(int id) {
		this.personDAO.removePerson(id);
	}
}

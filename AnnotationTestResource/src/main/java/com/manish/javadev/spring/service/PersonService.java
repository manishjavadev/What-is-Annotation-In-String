package com.manish.javadev.spring.service;

import java.util.List;

import com.manish.javadev.spring.model.Person;

/**
 * @author Manish
 * 
 */
public interface PersonService {

	public void addPerson(Person person);

	public void updatePerson(Person person);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);

}

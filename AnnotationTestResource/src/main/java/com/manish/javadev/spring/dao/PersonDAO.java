package com.manish.javadev.spring.dao;

import java.util.List;

import com.manish.javadev.spring.model.Person;

/**
 * @author Manish
 * 
 */
public interface PersonDAO {

	public void addPerson(Person p);

	public void updatePerson(Person p);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);
}

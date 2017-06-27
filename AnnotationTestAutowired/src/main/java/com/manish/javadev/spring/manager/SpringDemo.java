package com.manish.javadev.spring.manager;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manish.javadev.spring.model.Person;
import com.manish.javadev.spring.service.PersonService;

/**
 * @author Manish
 * 
 */
public class SpringDemo {
	public static void main(String[] args) {

		// getting ApplcationContext reference
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		System.out.println("CTX = " + ctx);

		PersonService personService = (PersonService) ctx
				.getBean("personService");

		Person person = new Person("Manish", "India");
		personService.addPerson(person);

		person = new Person("Deepak", "India");
		personService.addPerson(person);

		person = new Person("Meher", "India");
		personService.addPerson(person);

		person = new Person("Shubham", "India");
		personService.addPerson(person);

		// "Here Load Person" AND Update Person";
		Person person1 = personService.getPersonById(2);
		System.out.println(person1);

		person1.setCountry("USA");
		personService.updatePerson(person1);
		System.out.println(person1);

		// "Here Get  All Person";
		List<Person> personList = personService.listPersons();
		for (Person pers : personList) {
			System.out.println(pers);
		}

		// "Here Remove Person By ID";
		personService.removePerson(1);

		System.out.println("Done");
	}
}

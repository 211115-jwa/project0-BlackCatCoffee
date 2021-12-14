package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Person;
import com.revature.data.postgres.PersonPostgres;

public class PersonDAOTest {
	private PersonDAO personDao = new PersonPostgres();
	
	@Test
	public void createPersonTestNotEqual() {
		Person newPerson = new Person();
		int generatedId = personDao.create(newPerson);
		assertNotEquals(0,generatedId);
	}
	
	@Test
	public void createPersonTest() {
		Person newPerson = new Person();
		
	}
}

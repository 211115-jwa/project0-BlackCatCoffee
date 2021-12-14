package com.revature.data.postgres;

import java.util.Set;

import com.revature.beans.Person;
import com.revature.data.PersonDAO;

public class PersonPostgres implements PersonDAO {

	@Override
	public int create(Person dataToAdd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Person getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person dataToUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person dataToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

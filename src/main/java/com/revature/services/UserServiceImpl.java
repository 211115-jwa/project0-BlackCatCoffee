package com.revature.services;

import java.util.Set;

import com.revature.beans.Bike;
import com.revature.beans.Person;
import com.revature.data.BikeDAO;
import com.revature.data.postgres.BikePostgres;

public class UserServiceImpl implements UserService {
	private BikeDAO bikeDao = new BikePostgres();
/*
	@Override
	public Person register(Person newUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person logIn(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person updateUser(Person userToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public int addNewBike(Bike newBike) {
		return bikeDao.create(newBike);
	}

	@Override
	public Bike updateBike(Bike bikeToEdit) {
		Bike bikeFromDatabase = bikeDao.getById(bikeToEdit.getId());
		if (bikeFromDatabase != null) {
			bikeDao.update(bikeToEdit);
			return bikeDao.getById(bikeToEdit.getId());
		}
		return null;
	}

	@Override
	public Bike getBikeById(int id) {
		return bikeDao.getById(id);
	}

	@Override
	public Set<Bike> viewAvailableBikes() {
		return bikeDao.getAll();
	}

	@Override
	public Set<Bike> getByBikeManufacturer(String manufacturer) {
		return bikeDao.getByBikeManufacturer(manufacturer);
		
	}

	@Override
	public Set<Bike> getByBikeModel(String bikeModel) {
		return bikeDao.getByBikeModel(bikeModel);
	}

	

}

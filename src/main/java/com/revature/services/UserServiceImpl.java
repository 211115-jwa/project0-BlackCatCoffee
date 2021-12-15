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
	public Bike addNewBike(Bike newBike) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bike updateBike(Bike BikeToEdit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bike getBikeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bike> viewAvailableBikes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bike> getByBikeManufacturer(String Manufacturer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bike> getByBikeModel(String bikeModel) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

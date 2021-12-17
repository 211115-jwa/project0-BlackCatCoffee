package com.revature.services;

import java.util.Set;

import com.revature.beans.Bike;
import com.revature.beans.Person;


public interface UserService {
/*
	public Person register(Person newUser);
	public Person logIn(String username, String password);
	public Person updateUser(Person userToUpdate);
*/
	public int addNewBike(Bike newBike);
	public Bike updateBike(Bike BikeToEdit);
	public Bike getBikeById(int id);
	public Set<Bike> viewAvailableBikes();
	public Set<Bike> getByBikeManufacturer(String Manufacturer);
	public Set<Bike> getByBikeModel(String bikeModel);
}
/*
As a user, I can view all bicycles.
GET /bicycles
As a user, I can add a new bicycle.
POST /bicycles
As a user, I can update a bicycle.
PUT /bicycles/{id}
As a user, I can view bicycles by ID.
GET /bicycles/{id}

As a user, I can search bicycles by brand/model.
GET /bicycles?brand=
GET /bicycles?model=
*/

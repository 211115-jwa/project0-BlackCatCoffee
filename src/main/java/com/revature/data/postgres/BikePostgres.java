package com.revature.data.postgres;

import java.util.Set;

import com.revature.beans.Bike;
import com.revature.data.BikeDAO;

public class BikePostgres implements BikeDAO{

	@Override
	public int create(Bike dataToAdd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Bike getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Bike> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Bike dataToUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Bike dataToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Bike> getBybikeType(String bikeType) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.revature.data;

import java.util.Set;

import com.revature.beans.Bike;

public interface BikeDAO extends GenericDAO<Bike>{
	public Set<Bike> getByBikeManufacturer(String Manufacturer);
	public Set<Bike> getByBikeModel(String bikeModel);
}

package com.revature.data;

import java.util.Set;

import com.revature.beans.Bike;

public interface BikeDAO extends GenericDAO<Bike>{
	public Set<Bike> getBybikeType(String bikeType);
}

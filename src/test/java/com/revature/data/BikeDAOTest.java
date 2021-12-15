package com.revature.data;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.revature.beans.Bike;
import com.revature.data.postgres.BikePostgres;

public class BikeDAOTest {
	private BikeDAO bikeDao = new BikePostgres();
	
	@Test
	public void createNewBike() {
		Bike newBike = new Bike();
		int generatedId = bikeDao.create(newBike);
		assertNotEquals(0,generatedId);
	}
}

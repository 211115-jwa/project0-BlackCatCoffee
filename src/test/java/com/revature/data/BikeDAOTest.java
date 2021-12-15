package com.revature.data;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test
	public void getByIdWhenIdExistsTest(int id) {
		int idInput = 1;
		Bike idOutput = bikeDao.getById(idInput);
		assertEquals(idInput, idOutput.getById());
	}
}

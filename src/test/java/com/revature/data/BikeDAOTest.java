package com.revature.data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

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
	public void getByIdWhenIdExistsTest() {
		int idInput = 1;
		Bike idOutput = bikeDao.getById(idInput);
		assertEquals(1, idOutput.getId());
	}
	
	@Test
	public void getByIdWhenIdDoesNotExistTest() {
		int idInput = 847;
		Bike idOutput = bikeDao.getById(idInput);
		assertNull(idOutput);
	}
	
	@Test
	public void getAllBikesWithDataTest() {
		Set<Bike> bikeOutput = bikeDao.getAll();
		assertNotNull(bikeOutput);
		}
	
	@Test
	public void updateBikeTest() {
		Bike bikeToUpdate = bikeDao.getById(1);
		bikeToUpdate.setBikeType("road");
		bikeDao.update(bikeToUpdate);
		assertEquals("road",bikeDao.getById(1).getBikeType());
	}
	
	
	
	@Test
	public void deleteBikeTest() {
		Bike idInput = new Bike();
		Bike bikeOutput = bikeDao.getById(idInput.getId());
		bikeDao.delete(bikeOutput);
		assertNull(bikeOutput);
	}

	
	@Test
	public void getManufacturerNotNull() {
		Set<Bike> byManufacturer = bikeDao.getByBikeManufacturer("cannondale");
		assertNotNull(byManufacturer);
	}
	
	
	@Test
	public void getModelNotNull() {
		Set<Bike> byModel = bikeDao.getByBikeModel("f95");
		assertNotNull(byModel);
	}
	
}

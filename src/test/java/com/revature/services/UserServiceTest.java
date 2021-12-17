package com.revature.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.revature.beans.Bike;
import com.revature.data.BikeDAO;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	private BikeDAO bikeDao;
	
	@InjectMocks
	private UserService userServ = new UserServiceImpl();
	
	private static Set<Bike> mockAvailableBikes;
	
	@BeforeAll
	public static void mockAvailableBikesSetup() {
		mockAvailableBikes = new HashSet<>();
		
		for(int i=1; i<=5; i++) {
			Bike bike = new Bike();
			bike.setId(i);
			if (i<3)
				bike.setManufacturer("felt");
			mockAvailableBikes.add(bike);
		}
		
	}
	@Test
	public void addNewBikeSuccessfully() {
		Bike bike = new Bike();
		when(bikeDao.create(bike)).thenReturn(10);
		 int newId = userServ.addNewBike(bike);
		 assertNotEquals(0, newId);
	}
	
	@Test
	public void addNewBikeWentWrong() {
		Bike bike = new Bike();
		when(bikeDao.create(bike)).thenReturn(0);
		int newId = userServ.addNewBike(bike);
		assertEquals(0, newId);
	}
	
	@Test
	public void editBikeSuccessfully() {
		Bike EditedBike = new Bike();
		EditedBike.setId(2);
		EditedBike.setPrice(10);
		
		when(bikeDao.getById(2)).thenReturn(EditedBike);
		doNothing().when(bikeDao).update(Mockito.any(Bike.class));
		
		Bike actualBike = userServ.updateBike(EditedBike);
		
		assertEquals(EditedBike, actualBike);
	}
	
	@Test
	public void editBikeSomethingWrong() {
		Bike fakeBike = new Bike();
		fakeBike.setId(8);
		
		when(bikeDao.getById(8)).thenReturn(fakeBike);
		doNothing().when(bikeDao).update(Mockito.any(Bike.class));
		
		Bike editedBike = new Bike();
		editedBike.setId(8);
		editedBike.setFrameWeight(10);
		
		Bike actualBike = userServ.updateBike(editedBike);
		
		assertNotEquals(editedBike, actualBike);
	}
	
	@Test
	public void viewAvailableBikesTest() {
		when(bikeDao.getAll()).thenReturn(mockAvailableBikes);
		
		Set<Bike> actualBikes = userServ.viewAvailableBikes();
		
		assertEquals(mockAvailableBikes, actualBikes);
	}
	
	@Test
	public void viewManufactureTest() {
		when(bikeDao.getByBikeManufacturer("felt")).thenReturn(mockAvailableBikes);
		
		Set<Bike> actualBikes = userServ.getByBikeManufacturer("felt");
		
		assertEquals(mockAvailableBikes, actualBikes);
	}
	@Test
	public void viewModelTest() {
		when(bikeDao.getByBikeModel("f95")).thenReturn(mockAvailableBikes);
		
		Set<Bike> actualBikes = userServ.getByBikeModel("f95");
		
		assertEquals(mockAvailableBikes, actualBikes);
	}
}

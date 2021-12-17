package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

// this static import is for the path and get/post/put methods
import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;


import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;
import com.revature.beans.Bike;
import com.revature.beans.Person;


import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

import io.javalin.Javalin;

public class BikeShopApp {
	private static UserService userServ = new UserServiceImpl();

	public static void main(String[] args) {
		Javalin app = Javalin.create();

		app.start();

		app.routes(() -> {
			// localhost:8080/bikes
			path("/bikes", () -> {
				get(ctx -> {
					Set<Bike> bikes = userServ.viewAvailableBikes();
					if (bikes != null) {
						ctx.json(bikes);
					} else {
						ctx.result("no bikes available");
					}
				});
				post(ctx -> {
					Bike newBike = ctx.bodyAsClass(Bike.class);
					if (newBike != null) {
						userServ.addNewBike(newBike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				path("/{id}", () -> {
					
					get(ctx -> {
						try {
							int bikeId = Integer.parseInt(ctx.pathParam("id"));
							Bike bike = userServ.getBikeById(bikeId);
							if (bike != null)
								ctx.json(bike);
							else
								ctx.status(404);
						}catch (NumberFormatException e) {
							ctx.status(400);
						}
							
					});
					put(ctx -> {
						try {
							int bikeId = Integer.parseInt(ctx.pathParam("id"));
							Bike bikeToEdit = ctx.bodyAsClass(Bike.class);
							if (bikeToEdit != null && bikeToEdit.getId() == bikeId) {
								bikeToEdit = userServ.updateBike(bikeToEdit);
								if (bikeToEdit != null) 
									ctx.json(bikeToEdit);
								else {
									ctx.status(404);
									ctx.result("No bike matches that Id");
								}
							}else 
								ctx.status(HttpCode.CONFLICT);
						 }catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("bike Id must be a numerical value.");
						}
					});
				});
				path("/bikes?manufacturer=", () -> {
					get(ctx -> {
						// checking if they did /pets?species=
						String bikeManufacturer = ctx.queryParam("manufacturer");
						// when using .equals with a String literal, put the
						// String literal first because it prevents null pointer
						// exceptions
						if (bikeManufacturer != null && !"".equals(bikeManufacturer)) {
							Set<Bike> bikesFound = userServ.getByBikeManufacturer(bikeManufacturer);
							ctx.json(bikesFound);
						} else {
							// if they didn't put ?species
							Set<Bike> bikesfound = userServ.viewAvailableBikes();
							ctx.json(bikesfound);
						}
					});
				});
				path("/bikes?Model=", () -> {
					get(ctx -> {
						// checking if they did /pets?species=
						String bikeModel = ctx.queryParam("bikeModel");
						// when using .equals with a String literal, put the
						// String literal first because it prevents null pointer
						// exceptions
						if (bikeModel != null && !"".equals(bikeModel)) {
							Set<Bike> bikesFound = userServ.getByBikeModel(bikeModel);
							ctx.json(bikesFound);
						} else {
							// if they didn't put ?species
							Set<Bike> bikesFound = userServ.viewAvailableBikes();
							ctx.json(bikesFound);
						}
					});
				});
			});
		});
}}

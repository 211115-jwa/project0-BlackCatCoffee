package com.revature.app;

import io.javalin.Javalin;

public class BikeShopApp {

	public static void main(String[] args) {
		Javalin app = Javalin.create();

		app.start();

		app.routes(() -> {
			// localhost:8080/bikes
			path("/bikes", () -> {
				get(ctx -> {
					String bikeTypeSearch = ctx.queryParam("bikeType");

					if (bikeTypeSearch != null && !"".equals(bikeTypeSearch)) {
						set<Bike> bikesFound = userServ.searchAvailableBikesByType(bikeTypeSearch);
						ctx.json(bikesFound);
					} else {
						Set<Bike> availableBikes = userServ.viewAvailablePets();
						ctx.json(availableBikes);
					}
				});
				post(ctx -> {
					Bike newBike = ctx.bodyAsClass(Bike.class);
					if (newBike != null) {
						empServ.addNewBike(newBike);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
			});
			path("/sold/{id}", () -> {
				put(ctx -> {
					try {
						int bikeId = Integer.parseInt(ctx.pathparam("id"));
						Person newOwner = ctx.bodyAsClass(Person.class);

						newOwner = userServ.soldBike(frameSerialNumber, newOwner);
						ctx.json(newOwner);
					} catch (numberFormatException e) {
						ctx.status(400);
						ctx.result("Bike Frame ID must be a numerical value");
					}
				});

			});
		});
		path("/{id", () -> {

			get(ctx -> {
				try {
					int bikeId = Integer.parseInt(ctx.pathParam("id"));
					Bike bike = empServ.getbikeById(frameSerialNumber);
					if (bike != null)
						ctx.json(bike);
					else
						ctx.status(404);
				} catch (NumberFormatException e) {
					ctx.status(400);
					ctx.result("bike serial number must be a numeric value");
				}
			});

			put(ctx -> {
				try {
					int bikeId = Integer.parseInt(ctx.pathParam("frameSerialNumber"));
					bike bikeToEdit = ctx.bodyAsClass(Bike.class);
					if (bikeToEdit != null && bikeToEdit.getIFrameSerialNumber() == frameSerialNumber) {
						bikeToEdit = empServ.editBike(BikeToEdit);
						if (bikeToEdit != null)
							ctx.json(bikeToEdit);
						else
							ctx.status(404);
					} else {
						ctx.status(HttpCode.CONFLICT);
					}
				} catch (NumberFormatException e) {
					ctx.status(400);
					ctx.result("bike serial number must be a numeric value");
				}
			});
		});
	}
}

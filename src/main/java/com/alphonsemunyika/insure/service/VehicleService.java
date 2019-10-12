package com.alphonsemunyika.insure.service;

import java.util.List;

import com.alphonsemunyika.insure.model.Vehicle;

public interface VehicleService {

	long save(Vehicle vehicle);
	void delete(long vehicleId);
	Vehicle get(long vehicleId);
	void update(long vehicleId,Vehicle vehicle);
	List<Vehicle> list();
}

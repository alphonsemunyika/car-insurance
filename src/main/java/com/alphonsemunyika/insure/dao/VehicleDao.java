package com.alphonsemunyika.insure.dao;

import java.util.List;

import com.alphonsemunyika.insure.model.Vehicle;

public interface VehicleDao {
	long save(Vehicle vehicle);
	void delete(long vehicleId);
	void update(long vehicleId,Vehicle vehicle);
	Vehicle get(long VehicleId);
	List<Vehicle> list();
}

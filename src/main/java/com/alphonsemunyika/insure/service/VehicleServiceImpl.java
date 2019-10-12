package com.alphonsemunyika.insure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphonsemunyika.insure.dao.VehicleDao;
import com.alphonsemunyika.insure.model.Vehicle;
@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleDao vehicleDao;
	
	@Override
	@Transactional
	public long save(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	@Override
	@Transactional
	public void delete(long vehicleId) {
		vehicleDao.delete(vehicleId);
	}

	@Override
	@Transactional
	public Vehicle get(long vehicleId) {
		return vehicleDao.get(vehicleId);
	}

	@Override
	@Transactional
	public void update(long vehicleId, Vehicle vehicle) {

		 vehicleDao.update(vehicleId, vehicle);
	}

	@Override
	@Transactional
	public List<Vehicle> list() {
		return vehicleDao.list();
	}

}

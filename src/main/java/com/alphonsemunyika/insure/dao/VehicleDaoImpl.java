package com.alphonsemunyika.insure.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alphonsemunyika.insure.model.Vehicle;
@Repository
public class VehicleDaoImpl implements VehicleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public long save(Vehicle vehicle) {
		sessionFactory.getCurrentSession().save(vehicle);
		return vehicle.getVehicleId();
	}

	@Override
	public void delete(long vehicleId) {
		Session session =sessionFactory.getCurrentSession();
		Vehicle vehicle=(Vehicle) session.byId(Vehicle.class).load(vehicleId);
		session.delete(vehicle);
		session.flush();
	}


	@Override
	public void update(long vehicleId, Vehicle vehicle) {
		Session session=sessionFactory.getCurrentSession();
		Vehicle oldVehicle=(Vehicle)session.byId(Vehicle.class).load(vehicleId);
		oldVehicle.setVehicleMake(vehicle.getVehicleMake());
		oldVehicle.setVehicleModel(vehicle.getVehicleModel());
		oldVehicle.setVehicleYear(vehicle.getVehicleYear());
		session.flush();
	}

	@Override
	public Vehicle get(long vehicleId) {
		Vehicle vehicle=(Vehicle)sessionFactory.getCurrentSession().get(Vehicle.class, vehicleId);
		return vehicle;
	}


	@Override
	public List<Vehicle> list() {

		return sessionFactory.getCurrentSession().createQuery("from Vehicle").list();
	}

}

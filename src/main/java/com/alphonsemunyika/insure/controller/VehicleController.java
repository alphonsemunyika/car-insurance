package com.alphonsemunyika.insure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alphonsemunyika.insure.model.Insured;
import com.alphonsemunyika.insure.model.Vehicle;
import com.alphonsemunyika.insure.service.InsuredService;
import com.alphonsemunyika.insure.service.VehicleService;

@RestController
public class VehicleController {
	@Autowired
	VehicleService vehicleService;
	
	@GetMapping("/api/vehicle")
	public ResponseEntity<List<Vehicle>> list(){
	
		List<Vehicle> list=vehicleService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/api/vehicle")
	public ResponseEntity<?> save(@RequestBody Vehicle vehicle){
		long id=vehicleService.save(vehicle);
		return ResponseEntity.ok().body("added new vehicle with id: "+id);
	}
	
	@GetMapping("/api/vehicle/{id}")
	public ResponseEntity<Vehicle> get(@PathVariable("id")long id){
		return ResponseEntity.ok().body(vehicleService.get(id));
	}	
	
	//update a single record
	@PutMapping("/api/vehicle/{id}")
	public ResponseEntity<?>update(@PathVariable("id")long id , @RequestBody Vehicle vehicle){
		vehicleService.update(id, vehicle);
		return ResponseEntity.ok().body("Vehicle has been updated");
	}
	
	@DeleteMapping("/api/vehicle/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		vehicleService.delete(id);
		return ResponseEntity.ok().body("Client has been deleted");
		
	}
}

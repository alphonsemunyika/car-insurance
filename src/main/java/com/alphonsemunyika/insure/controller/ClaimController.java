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

import com.alphonsemunyika.insure.model.Claim;
import com.alphonsemunyika.insure.service.ClaimService;

@RestController
public class ClaimController {
	@Autowired
	ClaimService claimService;
	
	@GetMapping("/api/claim")
	public ResponseEntity<List<Claim>> list(){
	
		List<Claim> list=claimService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/api/claim")
	public ResponseEntity<?> save(@RequestBody Claim claim){
		long id=claimService.save(claim);
		return ResponseEntity.ok().body("added new claim with id: "+id);
	}
	
	@GetMapping("/api/claim/{id}")
	public ResponseEntity<Claim> get(@PathVariable("id")long id){
		return ResponseEntity.ok().body(claimService.get(id));
	}	
	
	//update a single record
	@PutMapping("/api/vehicle/{id}")
	public ResponseEntity<?>update(@PathVariable("id")long id , @RequestBody Claim claim){
		claimService.update(id, claim);
		return ResponseEntity.ok().body("claim has been updated");
	}
	
	@DeleteMapping("/api/vehicle/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		claimService.delete(id);
		return ResponseEntity.ok().body("Claim has been deleted");
		
	}
}

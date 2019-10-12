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
import com.alphonsemunyika.insure.service.InsuredService;

@RestController
public class InsuredController {

	@Autowired
	InsuredService insuredService;
	
	@GetMapping("/api/insured")
	public ResponseEntity<List<Insured>> list(){
	
		List<Insured> list=insuredService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/api/insured")
	public ResponseEntity<?> save(@RequestBody Insured insured){
		String id=insuredService.save(insured);
		return ResponseEntity.ok().body("added new client with id: "+id);
	}
	
	@GetMapping("/api/insured/{id}")
	public ResponseEntity<Insured> get(@PathVariable("id")String id){
		return ResponseEntity.ok().body(insuredService.get(id));
	}	
	
	//update a single record
	@PutMapping("/api/insured/{id}")
	public ResponseEntity<?>update(@PathVariable("id")String insuredId, @RequestBody Insured insured){
		insuredService.update(insuredId, insured);
		return ResponseEntity.ok().body("Client has been updated");
	}
	
	@DeleteMapping("/api/insured/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")String insuredId){
		insuredService.delete(insuredId);
		return ResponseEntity.ok().body("Client has been deleted");
		
	}
}

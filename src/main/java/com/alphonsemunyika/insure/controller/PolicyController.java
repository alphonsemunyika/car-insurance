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
import com.alphonsemunyika.insure.model.Policy;
import com.alphonsemunyika.insure.service.PolicyService;

@RestController
public class PolicyController {
	@Autowired
	PolicyService policyService;
	
	@GetMapping("/api/policy")
	public ResponseEntity<List<Policy>> list(){
	
		List<Policy> list=policyService.list();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping("/api/policy")
	public ResponseEntity<?> save(@RequestBody Policy policy){
		long id=policyService.save(policy);
		return ResponseEntity.ok().body("added new policy with id: "+id);
	}
	
	@GetMapping("/api/policy/{id}")
	public ResponseEntity<Policy> get(@PathVariable("id")long id){
		return ResponseEntity.ok().body(policyService.get(id));
	}	
	
	//update a single record
	@PutMapping("/api/policy/{id}")
	public ResponseEntity<?>update(@PathVariable("id")long id , @RequestBody Policy policy){
		policyService.update(id, policy);
		return ResponseEntity.ok().body("policy has been updated");
	}
	
	@DeleteMapping("/api/policy/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")long id){
		policyService.delete(id);
		return ResponseEntity.ok().body("policy has been deleted");
		
	}
}

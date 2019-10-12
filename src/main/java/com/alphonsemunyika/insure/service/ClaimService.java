package com.alphonsemunyika.insure.service;

import java.util.List;

import com.alphonsemunyika.insure.model.Claim;

public interface ClaimService {
	void delete(long id);
	Claim get(long id);
	void update(long id ,Claim claim);
	List<Claim> list();
	long save(Claim claim);
}

package com.alphonsemunyika.insure.service;

import java.util.List;

import com.alphonsemunyika.insure.model.Insured;

public interface InsuredService {
	String save(Insured insured);
	void delete(String insuredId);
	void deleteByName(String insuredName);
	void update(String insuredId,Insured insured);
	Insured get(String insuredId);
	Insured getByName(String insuredName);
	List<Insured> list();
}

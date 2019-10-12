package com.alphonsemunyika.insure.dao;

import java.util.List;

import com.alphonsemunyika.insure.model.Insured;

public interface InsuredDao {

	 String save(Insured insured);
	void delete(String insuredId);
	void update(String insuredId,Insured insured);
	Insured get(String insuredId);
	List<Insured> list();
}

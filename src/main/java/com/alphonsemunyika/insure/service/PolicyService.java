package com.alphonsemunyika.insure.service;

import java.util.List;

import com.alphonsemunyika.insure.model.Policy;

public interface PolicyService {
	void delete(long id);
	Policy get(long id);
	void update(long id ,Policy policy);
	List<Policy> list();
	long save(Policy policy);
}

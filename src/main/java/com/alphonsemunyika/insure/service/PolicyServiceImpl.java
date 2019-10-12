package com.alphonsemunyika.insure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphonsemunyika.insure.dao.PolicyDao;
import com.alphonsemunyika.insure.model.Policy;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	PolicyDao policyDao;
	
	@Override
	@Transactional
	public void delete(long id) {
		policyDao.delete(id);
	}

	@Override
	@Transactional
	public Policy get(long id) {
		return policyDao.get(id);
	}

	@Override
	@Transactional
	public void update(long id, Policy policy) {
		policyDao.update(id, policy);
	}

	@Override
	@Transactional
	public List<Policy> list() {
		return policyDao.list();
	}

	@Override
	@Transactional
	public long save(Policy policy) {
		return policyDao.save(policy);
	}

}

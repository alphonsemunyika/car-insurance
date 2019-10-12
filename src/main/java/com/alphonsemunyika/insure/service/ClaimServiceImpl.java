package com.alphonsemunyika.insure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphonsemunyika.insure.dao.ClaimDao;
import com.alphonsemunyika.insure.model.Claim;
@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimDao claimDao;
	
	@Override
	@Transactional
	public void delete(long id) {
		claimDao.delete(id);
	}

	@Override
	@Transactional
	public Claim get(long id) {
		return claimDao.get(id);
	}

	@Override
	@Transactional
	public void update(long id, Claim claim) {
		claimDao.update(id, claim);
	}

	@Override
	@Transactional
	public List<Claim> list() {
		return claimDao.list();
	}

	@Override
	@Transactional
	public long save(Claim claim) {
		return claimDao.save(claim);
	}

}

package com.alphonsemunyika.insure.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphonsemunyika.insure.dao.InsuredDao;
import com.alphonsemunyika.insure.dao.InsuredDaoImpl;
import com.alphonsemunyika.insure.model.Insured;

@Service
public class InsuredServiceImpl implements InsuredService {

	@Autowired
	InsuredDao insuredDao;
	
	@Override
	@Transactional
	public String save(Insured insured) {
		
	insured.setJoinDate(new Date());
		return insuredDao.save(insured);
	}

	@Override
	@Transactional
	public void delete(String insuredId) {

		insuredDao.delete(insuredId);
	}

	@Override
	public void deleteByName(String insuredName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void update(String insuredId, Insured insured) {
	
		insuredDao.update(insuredId, insured);
	}

	@Override
	@Transactional
	public Insured get(String insuredId) {
		return insuredDao.get(insuredId);
	}

	@Override
	public Insured getByName(String insuredName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Insured> list() {

		return insuredDao.list();
	}

}

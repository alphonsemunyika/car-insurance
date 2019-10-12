package com.alphonsemunyika.insure.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.alphonsemunyika.insure.model.Insured;


@Repository

public class InsuredDaoImpl implements InsuredDao {

	@Autowired
	SessionFactory sessionFactory;


	@Override
	public List<Insured> list() {
			
		return sessionFactory.getCurrentSession().createQuery("from Insured").list();

	}

	@Override
	public String save(Insured insured) {

		 sessionFactory.getCurrentSession().save(insured);	
		 return insured.getInsuredId();
	}

	@Override
	public void delete(String insuredId) {

		Session session=sessionFactory.getCurrentSession();
		Insured insured=(Insured)session.byId(Insured.class).load(insuredId);
		session.delete(insured);
		session.flush();
	}

	@Override
	public void update(String insuredId, Insured insured) {
		Session session=sessionFactory.getCurrentSession();
		Insured oldInsured=(Insured)session.byId(Insured.class).load(insuredId);
		oldInsured.setAddress(insured.getAddress());
		oldInsured.setJoinDate(insured.getJoinDate());
		oldInsured.setClaimList(insured.getClaimList());
		oldInsured.setInsuredName(insured.getInsuredName());
		oldInsured.setPolicyList(insured.getPolicyList());
		oldInsured.setTelephone(insured.getTelephone());
		
		session.flush();
	}

	@Override
	public Insured get(String insuredId) {
		return (Insured)sessionFactory.getCurrentSession().get(Insured.class, insuredId);
	}

	
}

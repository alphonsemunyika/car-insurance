package com.alphonsemunyika.insure.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alphonsemunyika.insure.model.Policy;

@Repository
public class PolicyDaoImpl implements PolicyDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void delete(long id) {
		Session session=sessionFactory.getCurrentSession();
		Policy policy=(Policy)session.byId(Policy.class).load(id);
		session.delete(policy);
		session.flush();
	}

	@Override
	public Policy get(long id) {
		return (Policy)sessionFactory.getCurrentSession().get(Policy.class, id);
	}

	@Override
	public void update(long id, Policy policy) {

		Session session=sessionFactory.getCurrentSession();
		Policy oldPolicy=(Policy)session.byId(Policy.class).load(id);
		oldPolicy.setCommenceDate(policy.getCommenceDate());
		oldPolicy.setFleet(policy.getFleet());
		oldPolicy.setInsured(policy.getInsured());
		oldPolicy.setPeriod(policy.getPeriod());
		oldPolicy.setRenewalDate(policy.getRenewalDate());
		oldPolicy.setStatus(policy.getStatus());
		oldPolicy.setType(policy.getType());
		session.flush();
	}

	@Override
	public List<Policy> list() {
		List<Policy> policyList=sessionFactory.getCurrentSession().createQuery("from Policy").list();
		return policyList;
	}

	@Override
	public long save(Policy policy) {
		sessionFactory.getCurrentSession().save(policy);
		return policy.getPolicyNumber();
	}

}

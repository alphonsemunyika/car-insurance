package com.alphonsemunyika.insure.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alphonsemunyika.insure.model.Claim;

@Repository
public class ClaimDaoImpl implements ClaimDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void delete(long id) {
		Session session=sessionFactory.getCurrentSession();
		Claim claim=(Claim)session.byId(Claim.class).load(id);
		session.delete(claim);
		session.flush();
		
	}

	@Override
	public Claim get(long id) {
		return (Claim)sessionFactory.getCurrentSession().get(Claim.class, id);
	}

	@Override
	public void update(long id, Claim claim) {
		Session session=sessionFactory.getCurrentSession();
		Claim oldClaim=(Claim)session.byId(Claim.class).load(id);
		oldClaim.setAmount(claim.getAmount());
		oldClaim.setClaimDate(claim.getClaimDate());
		oldClaim.setDescription(claim.getDescription());
		oldClaim.setPolicy(claim.getPolicy());
		oldClaim.setInsured(claim.getInsured());
		oldClaim.setStatus(claim.getStatus());
		session.flush();
	}

	@Override
	public List<Claim> list() {
		 List<Claim> claimList=sessionFactory.getCurrentSession().createQuery("from Claim").list();
		 return claimList;
	}

	@Override
	public long save(Claim claim) {
		sessionFactory.getCurrentSession().save(claim);
		return claim.getClaimNumber();
	}

}

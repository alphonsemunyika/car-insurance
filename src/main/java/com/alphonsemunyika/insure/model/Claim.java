package com.alphonsemunyika.insure.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alphonsemunyika.insure.model.types.ClaimStatus;

@Entity
@Table(name="CLAIM")
public class Claim {

	@Id
	@GeneratedValue
	@Column(name="CLAIM_NUMBER")
	private long claimNumber;
	@Column(name="CLAIM_DATE")
	private Date claimDate;
	@ManyToOne(fetch=FetchType.LAZY)
	Policy policy;
	@ManyToOne(fetch=FetchType.LAZY)
	Insured insured;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="AMOUNT")
	private double amount;
	@Enumerated(EnumType.STRING)
	private ClaimStatus status;
	public long getClaimNumber() {
		return claimNumber;
	}
	
	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	public void setClaimNumber(long claimNumber) {
		this.claimNumber = claimNumber;
	}
	public Date getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public ClaimStatus getStatus() {
		return status;
	}
	public void setStatus(ClaimStatus status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (claimNumber ^ (claimNumber >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Claim other = (Claim) obj;
		if (claimNumber != other.claimNumber)
			return false;
		return true;
	}
	
	
}

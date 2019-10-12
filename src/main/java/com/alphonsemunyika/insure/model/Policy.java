package com.alphonsemunyika.insure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.alphonsemunyika.insure.model.types.PolicyPeriod;
import com.alphonsemunyika.insure.model.types.PolicyStatus;
import com.alphonsemunyika.insure.model.types.PolicyType;

@Entity
@Table(name="POLICY")
public class Policy {
	@Id
	@GeneratedValue
	@Column(name="POLICY_NUMBER")
	private long policyNumber;
	
	@ManyToOne
	private Insured insured;
	
	@Column(name="COMMENCE_DATE")
	private Date commenceDate;
	
	@Column(name="RENEWAL_DATE")
	private Date renewalDate;
	
	@Column(name="POLICY_STATUS")
	@Enumerated(EnumType.STRING)
	private PolicyStatus status;
	
	@Column(name="POLICY_TYPE")
	@Enumerated(EnumType.STRING)
	private PolicyType type;
	
	@Column(name="POLICY_PERIOD")
	@Enumerated(EnumType.STRING)
	private PolicyPeriod period;
	
	@ElementCollection
	@JoinTable	(name="POLICY_CLAIM_MAPPING",joinColumns=@JoinColumn(name="policy_number"))
	private Collection<Claim> claimList=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="POLICY_VEHICLE_MAPPING",
	joinColumns= {@JoinColumn(name="POLICY_NUMBER",referencedColumnName="POLICY_NUMBER")},
			inverseJoinColumns={@JoinColumn(name="VEHICLE_ID",referencedColumnName="VEHICLE_ID")})
	@MapKeyColumn(name="VEHICLE_REG")
	private Map<String,Vehicle > fleet;

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}


	public Date getCommenceDate() {
		return commenceDate;
	}

	public void setCommenceDate(Date commenceDate) {
		this.commenceDate = commenceDate;
	}

	public Date getRenewalDate() {
		return renewalDate;
	}

	public void setRenewalDate(Date renewalDate) {
		this.renewalDate = renewalDate;
	}

	public PolicyStatus getStatus() {
		return status;
	}

	public void setStatus(PolicyStatus status) {
		this.status = status;
	}

	public PolicyType getType() {
		return type;
	}

	public void setType(PolicyType type) {
		this.type = type;
	}

	public PolicyPeriod getPeriod() {
		return period;
	}

	public void setPeriod(PolicyPeriod period) {
		this.period = period;
	}

	public Map<String, Vehicle> getFleet() {
		return fleet;
	}

	public void setFleet(Map<String, Vehicle> fleet) {
		this.fleet = fleet;
	}

	public Insured getInsured() {
		return insured;
	}

	public void setInsured(Insured insured) {
		this.insured = insured;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (policyNumber ^ (policyNumber >>> 32));
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
		Policy other = (Policy) obj;
		if (policyNumber != other.policyNumber)
			return false;
		return true;
	}

	
}

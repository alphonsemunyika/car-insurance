package com.alphonsemunyika.insure.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name="INSURED")
public class Insured {
	@Id
	@Column(name="INSURED_ID")
	private String insuredId;
	
	@Column(name="INSURED_NAME")
	private String insuredName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="TELEPHONE")
	private String telephone;
	
	@Column(name="JOIN_DATE")
	private Date joinDate;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="INSURED_POLICY",joinColumns=@JoinColumn(name="INSURED_ID"))
	private Collection<Policy> policyList=new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="INSURED_CLAIM",joinColumns=@JoinColumn(name="INSURED_ID"))
	private Collection<Claim> claimList= new ArrayList<>();

	public String getInsuredId() {
		return insuredId;
	}

	public void setInsuredId(String insuredId) {
		this.insuredId = insuredId;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Collection<Policy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(Collection<Policy> policyList) {
		this.policyList = policyList;
	}

	public Collection<Claim> getClaimList() {
		return claimList;
	}

	public void setClaimList(Collection<Claim> claimList) {
		this.claimList = claimList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((claimList == null) ? 0 : claimList.hashCode());
		result = prime * result + ((insuredId == null) ? 0 : insuredId.hashCode());
		result = prime * result + ((insuredName == null) ? 0 : insuredName.hashCode());
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((policyList == null) ? 0 : policyList.hashCode());
		result = prime * result + ((telephone == null) ? 0 : telephone.hashCode());
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
		Insured other = (Insured) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (claimList == null) {
			if (other.claimList != null)
				return false;
		} else if (!claimList.equals(other.claimList))
			return false;
		if (insuredId == null) {
			if (other.insuredId != null)
				return false;
		} else if (!insuredId.equals(other.insuredId))
			return false;
		if (insuredName == null) {
			if (other.insuredName != null)
				return false;
		} else if (!insuredName.equals(other.insuredName))
			return false;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (policyList == null) {
			if (other.policyList != null)
				return false;
		} else if (!policyList.equals(other.policyList))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		return true;
	}



	
}

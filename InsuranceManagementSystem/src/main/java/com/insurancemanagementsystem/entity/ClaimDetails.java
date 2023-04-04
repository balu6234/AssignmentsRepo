package com.insurancemanagementsystem.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClaimDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int insuranceId;
	@Column(name="Description")
	private String insuranceDescription;
	@Column(name="claimDate")
	private String claimDate;
	@Column(name="claimStatus")
	private String claimStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="policyNumber")
	private InsurancePolicy insurancePolicy;

}

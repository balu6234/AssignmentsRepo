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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsurancePolicy {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int policyNumber;
	@Column(name="policyType")
	private String policyType;
	@Column(name="CoverageAmount")
	private int insuranceCoverage;
	@Column(name="insurancePremium")
	private int Premium;
	@Column(name="StartDate")
	private int insuranceStartDate;
	@Column(name="EndDate")
	private int insuranceEndDate;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="clientId")
	private ClientDetails clientDetails;

}

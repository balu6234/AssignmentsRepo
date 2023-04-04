package com.insurancemanagementsystem.service;

import java.util.List;

import com.insurancemanagementsystem.entity.ClaimDetails;
import com.insurancemanagementsystem.validation.ClaimDTO;

public interface ClaimDetailsService {
	ClaimDetails SaveClaim(ClaimDTO claimDTO);
	ClaimDetails updateClaim(ClaimDetails claim, int insuranceId);
	String deletClaimById(int id);
	List<ClaimDetails> getAll();
	ClaimDetails getinsuranceClaimById(int id);

}

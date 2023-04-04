package com.insurancemanagementsystem.serviceImpl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancemanagementsystem.entity.ClaimDetails;
import com.insurancemanagementsystem.repositories.ClaimDetailsRepository;
import com.insurancemanagementsystem.service.ClaimDetailsService;
import com.insurancemanagementsystem.validation.ClaimDTO;

@Service
public class ClaimDetailsImpl implements ClaimDetailsService {
	@Autowired
	ClaimDetailsRepository claimDetailsRepository;
	
	public ClaimDetails SaveClaim(ClaimDTO claimDTO) {
		ClaimDetails claimdetails=ClaimDetails.builder()
				.insuranceDescription(claimDTO.getInsuranceDescription())
				.claimDate(claimDTO.getClaimDate())
				.claimStatus(claimDTO.getClaimStatus()).insurancePolicy(claimDTO.getInsurancePolicy())
				.build();
		return claimDetailsRepository.save(claimdetails);
	}

	@Override
	public ClaimDetails updateClaim(ClaimDetails params, int insuranceId) {
		ClaimDetails claim = claimDetailsRepository.findById(insuranceId).get();
		claim.setInsurancePolicy(params.getInsurancePolicy());
		claim.setInsuranceDescription(params.getInsuranceDescription());
		claim.setClaimDate(params.getClaimDate());
		claim.setClaimStatus(params.getClaimStatus());
		return claimDetailsRepository.save(claim);
	}

	@Override
	public String deletClaimById(int id) {
		claimDetailsRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public List<ClaimDetails> getAll() {
		return claimDetailsRepository.findAll();
	}

	@Override
	public ClaimDetails getinsuranceClaimById(int id) {
		return claimDetailsRepository.findById(id).get();
	}

}

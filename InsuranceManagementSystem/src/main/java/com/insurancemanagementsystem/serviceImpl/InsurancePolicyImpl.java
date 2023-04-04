package com.insurancemanagementsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancemanagementsystem.entity.InsurancePolicy;
import com.insurancemanagementsystem.repositories.InsurancePolicyRepository;
import com.insurancemanagementsystem.service.InsurancePolicyService;
import com.insurancemanagementsystem.validation.InsuranceDTO;

@Service
public class InsurancePolicyImpl implements InsurancePolicyService {
  @Autowired
  InsurancePolicyRepository insurancePolicyRepository;
  
	@Override
	public InsurancePolicy saveInsurancePolicy(InsuranceDTO insuranceDTO) {
		InsurancePolicy insurancePolicy =InsurancePolicy.builder()
				.policyType(insuranceDTO.getPolicyType()).Premium(insuranceDTO.getPremium())
				.insuranceStartDate(insuranceDTO.getInsuranceStartDate())
				.insuranceEndDate(insuranceDTO.getInsuranceEndDate())
				.insuranceCoverage(insuranceDTO.getInsuranceCoverage())
				.clientDetails(insuranceDTO.getClientDetails())
				.build();
		return insurancePolicyRepository.save(insurancePolicy);
	}

	

	@Override
	public String deleteInsurancePolicyById(int policyNumber) {
		insurancePolicyRepository.deleteById(policyNumber);
		return "Deleted Successfully";
	}

	@Override
	public InsurancePolicy getInsurancePolicyById(int policyNumber) {
		return insurancePolicyRepository.findById(policyNumber).get();
	}

	@Override
	public List<InsurancePolicy> getAll() {
		return insurancePolicyRepository.findAll();
	}



	@Override
	public InsurancePolicy updateInsurance(InsurancePolicy params, int policyNumber) {
		InsurancePolicy insurance=insurancePolicyRepository.findById(policyNumber).get();
		insurance.setPolicyType(params.getPolicyType());
		insurance.setPremium(params.getPremium());
		insurance.setInsuranceStartDate(params.getInsuranceStartDate());
		insurance.setInsuranceEndDate(params.getInsuranceEndDate());
		insurance.setInsuranceCoverage(params.getInsuranceCoverage());
		return insurance;
		
	}


}

package com.insurancemanagementsystem.service;

import java.util.List;

import com.insurancemanagementsystem.entity.InsurancePolicy;
import com.insurancemanagementsystem.validation.InsuranceDTO;

public interface InsurancePolicyService {
   InsurancePolicy saveInsurancePolicy(InsuranceDTO insuranceDTO);
   String deleteInsurancePolicyById(int policyNumber);
   InsurancePolicy getInsurancePolicyById(int policyNumber);
   List<InsurancePolicy> getAll();
   InsurancePolicy updateInsurance(InsurancePolicy insurancepolicy,int policyNumber);
}

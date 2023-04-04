package com.insurancemanagementsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurancemanagementsystem.entity.InsurancePolicy;
import com.insurancemanagementsystem.exception.InsuranceDetailsNotFoundException;
import com.insurancemanagementsystem.serviceImpl.InsurancePolicyImpl;
import com.insurancemanagementsystem.validation.InsuranceDTO;


@RestController
public class InsurancePolicyController {
	@Autowired
	InsurancePolicyImpl insurancePolicyImpl;
	@PostMapping("/addinsurance")
	public ResponseEntity<InsurancePolicy> addClaim(@RequestBody @Valid InsuranceDTO insuranceDTO)
	{
		try {
			 InsurancePolicy insurancePolicy= insurancePolicyImpl.saveInsurancePolicy(insuranceDTO);
			 if(insurancePolicy!=null)
			 {
				 return new ResponseEntity<InsurancePolicy>(insurancePolicy,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex) 
		{
			throw new InsuranceDetailsNotFoundException("unable to add insurance");
		}
		return new ResponseEntity<InsurancePolicy>(HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("/insurancepolicy/{policyNumber}") ResponseEntity<InsurancePolicy> getinsurancePolicyById(@PathVariable("policyNumber")int policyNumber)
	{
		try {
			InsurancePolicy insurancePolicy = insurancePolicyImpl.getInsurancePolicyById(policyNumber);
			if(insurancePolicy!=null) {
				return new ResponseEntity<InsurancePolicy>(insurancePolicy,HttpStatus.FOUND);
			}
		}
		catch(Exception ex) {
			throw new InsuranceDetailsNotFoundException("NO Insurance Details WITH THIS Number"+policyNumber+"Found");
		}
		return new ResponseEntity<InsurancePolicy>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/insurance/update/{policyNumber}")
	public ResponseEntity<InsurancePolicy> updateInsuranceById(@RequestBody InsurancePolicy insurance,@PathVariable int policyNumber)
	{
		try {
			InsurancePolicy insurancePolicy = insurancePolicyImpl.updateInsurance(insurance, policyNumber);
			if(insurancePolicy!=null) {
				return new ResponseEntity<InsurancePolicy>(insurancePolicy,HttpStatus.ACCEPTED);
			}
		}
		catch(Exception ex) {
			throw new InsuranceDetailsNotFoundException("Unable To Update Insurance details");
		}
		return new ResponseEntity<InsurancePolicy>(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/deleteinsurance/{policyNumber}")
	public ResponseEntity<String> deleteInsurancePolicyById(@PathVariable("policyNumber")int policyNumber)
	{
		try{
		      String insurancePolicy = insurancePolicyImpl.deleteInsurancePolicyById(policyNumber);
		      if(insurancePolicy!=null) {
		    	  return new ResponseEntity<String>(insurancePolicy,HttpStatus.ACCEPTED);
		      }
		}
		catch(Exception ex)
		{
			throw new InsuranceDetailsNotFoundException("Unable To Delete Insurance Details");
		}
	
	    return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
     }
	@GetMapping("/allinsurancepolicies")
	public ResponseEntity<List<InsurancePolicy>> getAll()
	  {
		  return new ResponseEntity<>(insurancePolicyImpl.getAll(),HttpStatus.OK);
	  }

}



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

import com.insurancemanagementsystem.entity.ClaimDetails;
import com.insurancemanagementsystem.exception.ClaimDetailsNotFoundException;
import com.insurancemanagementsystem.serviceImpl.ClaimDetailsImpl;
import com.insurancemanagementsystem.validation.ClaimDTO;

@RestController
public class ClaimDetailsController {
	@Autowired
	ClaimDetailsImpl claimDetailsImpl;
	@PostMapping("/addclaim")
	public ResponseEntity<ClaimDetails> addClaim(@RequestBody @Valid ClaimDTO claimDTO)
	{
		try {
			 ClaimDetails claimDetails= claimDetailsImpl.SaveClaim(claimDTO);
			 if(claimDetails!=null)
			 {
				 return new ResponseEntity<ClaimDetails>(claimDetails,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex) 
		{
			throw new ClaimDetailsNotFoundException("unable to add");
		}
		return new ResponseEntity<ClaimDetails>(HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("/claim/{insuranceId}") ResponseEntity<ClaimDetails> getClaimDetailsById(@PathVariable("insuranceId")int insuranceId)
	{
		try {
			ClaimDetails claimDetails = claimDetailsImpl.getinsuranceClaimById(insuranceId);
			if(claimDetails!=null) {
				return new ResponseEntity<ClaimDetails>(claimDetails,HttpStatus.FOUND);
			}
		}
		catch(Exception ex) {
			throw new ClaimDetailsNotFoundException("NO ClaimerDetails WITH THIS ID"+insuranceId+"Found");
		}
		return new ResponseEntity<ClaimDetails>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/claim/update/{insuranceId}")
	public ResponseEntity<ClaimDetails> updateClaimById(@RequestBody ClaimDetails claim,@PathVariable int insuranceId)
	{
		try {
			ClaimDetails claimDetails = claimDetailsImpl.updateClaim(claim, insuranceId);
			if(claimDetails!=null) {
				return new ResponseEntity<ClaimDetails>(claimDetails,HttpStatus.ACCEPTED);
			}
		}
		catch(Exception ex) {
			throw new ClaimDetailsNotFoundException("Unable To Update");
		}
		return new ResponseEntity<ClaimDetails>(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/deleteclaim/{insuranceId}")
	public ResponseEntity<String> deleteClaimById(@PathVariable("insuranceId")int insuranceId)
	{
		try{
		      String claimDetails = claimDetailsImpl.deletClaimById(insuranceId);
		      if(claimDetails!=null) {
		    	  return new ResponseEntity<String>(claimDetails,HttpStatus.ACCEPTED);
		      }
		}
		catch(Exception ex)
		{
			throw new ClaimDetailsNotFoundException("Unable To Delete");
		}
	
	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
}
	@GetMapping("/allclaimes")
	public ResponseEntity<List<ClaimDetails>> getAll()
	  {
		  return new ResponseEntity<>(claimDetailsImpl.getAll(),HttpStatus.OK);
	  }
	
}

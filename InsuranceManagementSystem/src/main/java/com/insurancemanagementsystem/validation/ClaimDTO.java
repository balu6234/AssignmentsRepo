package com.insurancemanagementsystem.validation;


import javax.validation.constraints.NotNull;

import com.insurancemanagementsystem.entity.InsurancePolicy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaimDTO {
	
    @NotNull(message="Enter Claim Date")
    private String claimDate;
    
    @NotNull(message="Enter the claim status(claimed/notclaimed)")
    private String claimStatus;

    @NotNull(message="Enter the insurancedescription")
	private String insuranceDescription;
    
	private InsurancePolicy insurancePolicy;
}

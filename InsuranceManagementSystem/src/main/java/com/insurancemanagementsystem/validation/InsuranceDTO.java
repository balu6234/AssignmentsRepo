package com.insurancemanagementsystem.validation;

import javax.validation.constraints.NotBlank; 
import javax.validation.constraints.NotNull;

import com.insurancemanagementsystem.entity.ClientDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsuranceDTO {
	
	@NotBlank(message="Policy Type Not Blank")
    @NotNull(message="Policy Type Should Not Be Null")
    private String policyType;
	
	@NotNull(message="Enter the coverage Amount")
    private int insuranceCoverage;

    @NotNull(message="Enter The Insurance Premium")
    private int Premium;
    
    @NotNull(message="Insurance startDate Not Null")
	private int insuranceStartDate;
    
    @NotNull(message="InsuranceEndDate Not Null")
	private int insuranceEndDate;

    
	private ClientDetails clientDetails;
}

package com.insurancemanagementsystem.validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
	
    @NotBlank(message="Name Should Not be Empty")
	@NotNull(message="Enter The ClientName")
	@Size(min=3,max=15,message="ClientName must be within the range 3-15 characters")
    private String clientName;
    
    @NotBlank(message="Address Should Not be Empty")
	@NotNull(message="Enter The ClientAddress")
    private String clientAddress;
    
	@NotNull(message="Enter The Client Contact Number")
	@Pattern(regexp="\\d{10}",message="Invalid Phone Number")
    private String clientContact;
    
    @NotBlank(message="date of birth Should Not be Empty")
	@NotNull(message="date of birth not null")
    private String dateOfBirth;
	
}

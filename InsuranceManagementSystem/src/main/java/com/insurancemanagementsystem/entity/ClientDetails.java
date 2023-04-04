package com.insurancemanagementsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int clientId;
	@Column(name="Name")
	private String clientName;
	@Column(name="DateOfBirth")
	private String dateOfBirth;
	@Column(name="Address")
	private String clientAddress;
	@Column(name="contact")
	private String clientContact;

}

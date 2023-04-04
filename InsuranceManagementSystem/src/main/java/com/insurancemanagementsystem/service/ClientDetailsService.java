package com.insurancemanagementsystem.service;

import java.util.List; 

import com.insurancemanagementsystem.entity.ClientDetails;
import com.insurancemanagementsystem.validation.ClientDTO;

public interface ClientDetailsService {
    ClientDetails saveClient(ClientDTO clientDTO);
	String deletClientById(int id);
	List<ClientDetails> getAll();
	ClientDetails getclientdetailsById(int id);
	ClientDetails updateClient(ClientDetails client, int clientId);
}

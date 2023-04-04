package com.insurancemanagementsystem.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancemanagementsystem.entity.ClientDetails;
import com.insurancemanagementsystem.repositories.ClientDetailsRepository;
import com.insurancemanagementsystem.service.ClientDetailsService;
import com.insurancemanagementsystem.validation.ClientDTO;

@Service
public class ClientDetailsImpl implements ClientDetailsService {
	@Autowired
	ClientDetailsRepository clientDetailsRepository;

	@Override
	public ClientDetails saveClient(ClientDTO clientDTO) {
		ClientDetails clientDetails = ClientDetails.builder()
				.clientName(clientDTO.getClientName()).dateOfBirth(clientDTO.getDateOfBirth())
				.clientContact(clientDTO.getClientContact())
				.clientAddress(clientDTO.getClientAddress()).build();
		return clientDetailsRepository.save(clientDetails);
	}

	@Override
	public ClientDetails updateClient(ClientDetails params, int clientId) {
		ClientDetails clientDetails=clientDetailsRepository.findById(clientId).get();
		clientDetails.setClientName(params.getClientName());
		clientDetails.setDateOfBirth(params.getDateOfBirth());
		clientDetails.setClientContact(params.getClientContact());
		clientDetails.setClientAddress(params.getClientAddress());
		return clientDetailsRepository.save(clientDetails);
	}

	@Override
	public String deletClientById(int id) {
		clientDetailsRepository.deleteById(id);
		return "Deleted Successfully";
	}

	@Override
	public List<ClientDetails> getAll() {
		return clientDetailsRepository.findAll();
	}

	@Override
	public ClientDetails getclientdetailsById(int id) {
		return clientDetailsRepository.findById(id).get();
	}

}

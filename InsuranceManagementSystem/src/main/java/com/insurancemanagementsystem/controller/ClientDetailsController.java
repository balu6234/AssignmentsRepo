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

import com.insurancemanagementsystem.entity.ClientDetails;
import com.insurancemanagementsystem.exception.ClientDetailsNotFoundException;
import com.insurancemanagementsystem.serviceImpl.ClientDetailsImpl;
import com.insurancemanagementsystem.validation.ClientDTO;


@RestController
public class ClientDetailsController {
	@Autowired
	ClientDetailsImpl clientDetailsImpl;
	@PostMapping("/addclient")
	public ResponseEntity<ClientDetails> addClient(@RequestBody @Valid ClientDTO clientDTO)
	{
		try {
			 ClientDetails clientDetails= clientDetailsImpl.saveClient(clientDTO);
			 if(clientDetails!=null)
			 {
				 return new ResponseEntity<ClientDetails>(clientDetails,HttpStatus.CREATED);
			 }
		}
		catch(Exception ex) 
		{
			throw new ClientDetailsNotFoundException("unable to add client details");
		}
		return new ResponseEntity<ClientDetails>(HttpStatus.BAD_REQUEST);
	}

	
	@GetMapping("/client/{clientId}") ResponseEntity<ClientDetails> getClientDetailsById(@PathVariable("clientId")int clientId)
	{
		try {
			ClientDetails clientDetails = clientDetailsImpl.getclientdetailsById(clientId);
			if(clientDetails!=null) {
				return new ResponseEntity<ClientDetails>(clientDetails,HttpStatus.FOUND);
			}
		}
		catch(Exception ex) {
			throw new ClientDetailsNotFoundException("NO ClientDetails WITH THIS ID"+clientId+"Found");
		}
		return new ResponseEntity<ClientDetails>(HttpStatus.NOT_FOUND);
	}
	@PutMapping("/client/update/{clientId}")
	public ResponseEntity<ClientDetails> updateClientById(@RequestBody ClientDetails client,@PathVariable int clientId)
	{
		try {
			ClientDetails clientDetails = clientDetailsImpl.updateClient(client, clientId);
			if(clientDetails!=null) {
				return new ResponseEntity<ClientDetails>(clientDetails,HttpStatus.ACCEPTED);
			}
		}
		catch(Exception ex) {
			throw new ClientDetailsNotFoundException("Unable To Update Client Details");
		}
		return new ResponseEntity<ClientDetails>(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("/delete/{clientId}")
	public ResponseEntity<String> deleteClaimById(@PathVariable("clientId")int clientId)
	{
		try{
		      String clientDetails = clientDetailsImpl.deletClientById(clientId);
		      if(clientDetails!=null) {
		    	  return new ResponseEntity<String>(clientDetails,HttpStatus.ACCEPTED);
		      }
		}
		catch(Exception ex)
		{
			throw new ClientDetailsNotFoundException("Unable To Delete Client Details");
		}
	
	return new ResponseEntity<String>(HttpStatus.NOT_ACCEPTABLE);
}
	@GetMapping("/allclients")
	public ResponseEntity<List<ClientDetails>> getAll()
	  {
		  return new ResponseEntity<>(clientDetailsImpl.getAll(),HttpStatus.OK);
	  }
	
}


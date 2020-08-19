package com.edudev.osworksapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edudev.osworksapi.exceptions.ObjectNotFoundException;
import com.edudev.osworksapi.model.Client;
import com.edudev.osworksapi.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> findAll(){
		return clientRepository.findAll();
	}
	
	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow(() -> new ObjectNotFoundException("Id not exists!"));
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public Client update(Client client) {
		Client alter = findById(client.getId());
		setAttributes(client,alter);
		return clientRepository.save(alter);
	}
	
	public void delete(Long id) {
		Client client = findById(id);
		clientRepository.delete(client);
	}
	
	private void setAttributes(Client client, Client alter) {
		alter.setName(client.getName());
		alter.setEmail(client.getEmail());
		alter.setPhone(client.getPhone());
	}
	
}

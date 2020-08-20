package com.edudev.osworksapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edudev.osworksapi.exceptions.EntityNotFoundedException;
import com.edudev.osworksapi.exceptions.ObjectNotFoundException;
import com.edudev.osworksapi.model.Client;
import com.edudev.osworksapi.model.Comment;
import com.edudev.osworksapi.model.OrderService;
import com.edudev.osworksapi.model.StatusOrderService;
import com.edudev.osworksapi.repository.ClientRepository;
import com.edudev.osworksapi.repository.CommentRepository;
import com.edudev.osworksapi.repository.OrderServiceRepository;


@Service
public class OrderServiceService {

	@Autowired
	private OrderServiceRepository orderServiceRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public OrderService save(OrderService orderService) {
		Client client = clientRepository.findById(orderService.getClient().getId())
				.orElseThrow(() -> new ObjectNotFoundException("Client not Found" ));
		orderService.setClient(client);
		orderService.setStatus(StatusOrderService.OPEN);
		
		return orderServiceRepository.save(orderService);
	}
	
	public List<OrderService> findAll(){
		return orderServiceRepository.findAll();
	}
	
	public Optional<OrderService> findById(Long id) {
		Optional<OrderService> OS = orderServiceRepository.findById(id);
		
		if(OS.get() == null)
			new ObjectNotFoundException("Id not exists!");
		return OS;
	}
	
	public void finished(Long orderServiceId) {
		OrderService orderService = fetch(orderServiceId);
		
		orderService.setStatus(StatusOrderService.FINISHED);
		orderService.setCloseDate(LocalDateTime.now());
		
		orderServiceRepository.save(orderService);
	}
	
	public Comment addComment(Long orderServiceId, String description) {
		OrderService orderService = fetch(orderServiceId);
		
		Comment comment = new Comment();

		comment.setSendData(LocalDateTime.now());
		comment.setDescription(description);
		comment.setOrderService(orderService);
		
		return commentRepository.save(comment);
		
	}
	
	private OrderService fetch(Long orderServiceId) {
		return orderServiceRepository.findById(orderServiceId)
				.orElseThrow(() -> new EntityNotFoundedException("Service order not found!"));
	}
	
	public void deleteById(Long id) {
		orderServiceRepository.deleteById(id);
	}
	


	
	
}

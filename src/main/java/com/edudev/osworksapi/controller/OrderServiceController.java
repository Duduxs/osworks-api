package com.edudev.osworksapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.osworksapi.model.OrderService;
import com.edudev.osworksapi.model.OrderServiceInput;
import com.edudev.osworksapi.model.dto.OrderServiceDTO;
import com.edudev.osworksapi.service.OrderServiceService;

@RestController
@RequestMapping(value="/orders-service")
public class OrderServiceController {

	@Autowired
	private OrderServiceService orderServiceService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping
	public ResponseEntity<List<OrderServiceDTO>> list(){
		return ResponseEntity.ok().body(toCollectionModel(orderServiceService.findAll()));
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<OrderServiceDTO> findById(@PathVariable Long id){
		
		Optional<OrderService> order = orderServiceService.findById(id);
		OrderServiceDTO orderServiceDTO = toModel(order.get());
		
		return ResponseEntity.ok().body(orderServiceDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<OrderServiceDTO> save(@Validated OrderServiceInput orderServiceInput){
		OrderService orderService = toEntity(orderServiceInput);
		return ResponseEntity.ok().body(toModel(orderServiceService.save(orderService)));
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		orderServiceService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/{orderServiceId}/finished")
	public ResponseEntity<Void> finished(@PathVariable Long orderServiceId) {
		orderServiceService.finished(orderServiceId);
		return ResponseEntity.noContent().build();
	}
	
	private OrderServiceDTO toModel(OrderService orderService) {
		return modelMapper.map(orderService, OrderServiceDTO.class);	
	}
	
	private List<OrderServiceDTO> toCollectionModel(List<OrderService> orderService){
		return orderService.stream()
				.map(order -> toModel(order))
				.collect(Collectors.toList());
	}
	
	private OrderService toEntity(OrderServiceInput orderServiceInput) {
		return modelMapper.map(orderServiceInput, OrderService.class);
	}
	
	
	
}

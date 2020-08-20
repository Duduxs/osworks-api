package com.edudev.osworksapi.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edudev.osworksapi.exceptions.EntityNotFoundedException;
import com.edudev.osworksapi.model.Comment;
import com.edudev.osworksapi.model.CommentInput;
import com.edudev.osworksapi.model.OrderService;
import com.edudev.osworksapi.model.dto.CommentDTO;
import com.edudev.osworksapi.service.OrderServiceService;

@RestController
@RequestMapping(value = "/orders-service/{id}/comments")
public class CommentController {

	@Autowired
	private OrderServiceService orderServiceService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping
	public List<CommentDTO> listAll(@PathVariable Long id){
		OrderService orderService = orderServiceService.findById(id)
				.orElseThrow(() -> new EntityNotFoundedException("Order Service not founded"));
		
		return toCollectionDTO(orderService.getComments());
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CommentDTO> insert(@PathVariable Long id,CommentInput commentInput) {
		Comment comment = orderServiceService.addComment(id, commentInput.getDescription());
		return ResponseEntity.ok().body(toModel(comment));
	}
	
	private CommentDTO toModel(Comment comment) {
		return modelMapper.map(comment, CommentDTO.class);
	}
	
	private List<CommentDTO> toCollectionDTO(List<Comment> comments){
		return comments.stream().map(comment-> toModel(comment))
				.collect(Collectors.toList());
				
	}
}

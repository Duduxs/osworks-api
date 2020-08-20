package com.edudev.osworksapi.model.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.edudev.osworksapi.model.StatusOrderService;

public class OrderServiceDTO {

	private Long id;
	private String description;
	private BigDecimal price;
	
	private StatusOrderService status;
	
	private LocalDateTime openDate;
	private LocalDateTime closeDate;
	
	private ClientDTO client;
	
	public OrderServiceDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public StatusOrderService getStatus() {
		return status;
	}

	public void setStatus(StatusOrderService status) {
		this.status = status;
	}

	public LocalDateTime getOpenDate() {
		return openDate;
	}

	public void setOpenDate(LocalDateTime openDate) {
		this.openDate = openDate;
	}

	public LocalDateTime getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(LocalDateTime closeDate) {
		this.closeDate = closeDate;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}
	
	
	
	
}

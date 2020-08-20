package com.edudev.osworksapi.model;

import java.math.BigDecimal;

public class OrderServiceInput {

	private String description;
	private BigDecimal price;
	private ClientIdInput clientId;
	
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
	public ClientIdInput getClientId() {
		return clientId;
	}
	public void setClientId(ClientIdInput clientId) {
		this.clientId = clientId;
	}
	
	
}

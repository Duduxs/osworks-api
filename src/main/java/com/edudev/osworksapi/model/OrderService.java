package com.edudev.osworksapi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class OrderService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private StatusOrderService status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime openDate;
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime closeDate;
	
	
	@ManyToOne
	@JoinColumn(name="fk_client")
	private Client client;
	
	@OneToMany(mappedBy = "orderService")
	private List<Comment> comments = new ArrayList<>();
	
	public OrderService() {
		
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Comment> getComments() {
		return comments;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderService other = (OrderService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}

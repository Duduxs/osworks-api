package com.edudev.osworksapi.model.dto;

import java.time.LocalDateTime;

public class CommentDTO {

	private Long id;
	private String description;
	private LocalDateTime sendDate;
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
	public LocalDateTime getSendDate() {
		return sendDate;
	}
	public void setSendDate(LocalDateTime sendDate) {
		this.sendDate = sendDate;
	}
	
	
}

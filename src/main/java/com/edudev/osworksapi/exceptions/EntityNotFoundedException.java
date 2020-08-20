package com.edudev.osworksapi.exceptions;

public class EntityNotFoundedException extends ObjectNotFoundException {
	
	private static final long serialVersionUID = 1L;

	public EntityNotFoundedException(String msg) {
		super(msg);
	}

}

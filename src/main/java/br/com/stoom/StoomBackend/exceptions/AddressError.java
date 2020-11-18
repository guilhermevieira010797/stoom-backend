package br.com.stoom.StoomBackend.exceptions;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public class AddressError implements Serializable {
	private static final long serialVersionUID = 7929150788038296582L;
	
	private HttpStatus status;
	private String message;
	
	public AddressError(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

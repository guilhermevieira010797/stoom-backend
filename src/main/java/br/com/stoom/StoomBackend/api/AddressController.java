package br.com.stoom.StoomBackend.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.stoom.StoomBackend.exceptions.AddressError;
import br.com.stoom.StoomBackend.model.AddressTO;
import br.com.stoom.StoomBackend.services.AddressService;

@RestController
@RequestMapping(value="/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createAddress(@RequestBody @Valid AddressTO address) throws Exception {
		return new ResponseEntity<>(addressService.createAddress(address), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateAddress(@RequestBody @Valid AddressTO address) {
		return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
	public ResponseEntity<AddressTO> getAddress(@PathVariable("id") String id) {
		return new ResponseEntity<>(addressService.getAddress(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<AddressTO>> listAddress() {
		return new ResponseEntity<>(addressService.listAddress(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<Void> deleteAddress(@PathVariable("id") String id) {
		return new ResponseEntity<>(addressService.deleteAddress(id), HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<AddressError> exceptionHandler(ResponseStatusException ex) {
		AddressError error = new AddressError(ex.getStatus(), ex.getReason());
		return new ResponseEntity<>(error, ex.getStatus());
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<AddressError> exceptionHandler(NotFoundException ex) {
		AddressError error = new AddressError(HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<AddressError> exceptionHandler(DataAccessException ex) {
		AddressError error = new AddressError(HttpStatus.BAD_REQUEST, "Communication error with database, please review the request");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AddressError> exceptionHandler(Exception ex) {
		AddressError error = new AddressError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

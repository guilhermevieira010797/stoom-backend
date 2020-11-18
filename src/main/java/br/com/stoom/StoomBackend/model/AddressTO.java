package br.com.stoom.StoomBackend.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AddressTO implements Serializable {
		
	private static final long serialVersionUID = -3654161050741621704L;

	private Long id;
	
	@NotNull(message="streetName is required")
	private String streetName;
	
	@NotNull(message="number is required")
	private Integer number;
	
	@NotNull(message="neighbourhood is required")
	private String neighbourhood;
	
	@NotNull(message="city is required")
	private String city;
	
	@NotNull(message="state is required")
	private String state;
	
	@NotNull(message="country is required")
	private String country;
	
	@NotNull(message="zipCode is required")
	private String zipCode;
	
	private String complement;
	
	private String latitude;
	
	private String longitude;
	
	public AddressTO() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}

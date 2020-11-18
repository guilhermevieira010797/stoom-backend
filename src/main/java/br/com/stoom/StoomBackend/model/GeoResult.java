package br.com.stoom.StoomBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoResult {
	
	@JsonProperty("address_components")
	private AddressComponent[] addressComponents;
	
	@JsonProperty("formatted_address")
	private String formattedAddress;
	
	@JsonProperty("geometry")
	private Geometry geometry;
	
	@JsonProperty("place_id")
	private String placeId;
	
	@JsonProperty("plus_code")
	private PlusCode plusCode;
	
	@JsonProperty("types")
	private String[] types;

	public AddressComponent[] getAddressComponents() {
		return addressComponents;
	}

	public void setAddressComponents(AddressComponent[] addressComponents) {
		this.addressComponents = addressComponents;
	}

	public String getFormattedAddress() {
		return formattedAddress;
	}

	public void setFormattedAddress(String formattedAddress) {
		this.formattedAddress = formattedAddress;
	}

	public Geometry getGeometry() {
		return geometry;
	}

	public void setGeometry(Geometry geometry) {
		this.geometry = geometry;
	}

	public String getPlaceId() {
		return placeId;
	}

	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	public PlusCode getPlusCode() {
		return plusCode;
	}

	public void setPlusCode(PlusCode plusCode) {
		this.plusCode = plusCode;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}
	
}

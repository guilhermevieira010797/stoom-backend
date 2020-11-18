package br.com.stoom.StoomBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Geometry {

	@JsonProperty("location")
	private Location location;
	
	@JsonProperty("location_type")
	private String locationType;
	
	@JsonProperty("viewport")
	private ViewPort viewPort;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getLocationType() {
		return locationType;
	}

	public void setLocationType(String locationType) {
		this.locationType = locationType;
	}

	public ViewPort getViewPort() {
		return viewPort;
	}

	public void setViewPort(ViewPort viewPort) {
		this.viewPort = viewPort;
	}
	
}

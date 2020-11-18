package br.com.stoom.StoomBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeoInformation {
	
	@JsonProperty("results")
	private GeoResult[] results;
	
	@JsonProperty("status")
	private String status;

	public GeoResult[] getResults() {
		return results;
	}

	public void setResults(GeoResult[] results) {
		this.results = results;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

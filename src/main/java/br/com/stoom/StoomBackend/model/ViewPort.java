package br.com.stoom.StoomBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViewPort {

	@JsonProperty("northeast")
	private NortHeast nortHeast;
	
	@JsonProperty("southwest")
	private SouthWest southWest;

	public NortHeast getNortHeast() {
		return nortHeast;
	}

	public void setNortHeast(NortHeast nortHeast) {
		this.nortHeast = nortHeast;
	}

	public SouthWest getSouthWest() {
		return southWest;
	}

	public void setSouthWest(SouthWest southWest) {
		this.southWest = southWest;
	}
	
}

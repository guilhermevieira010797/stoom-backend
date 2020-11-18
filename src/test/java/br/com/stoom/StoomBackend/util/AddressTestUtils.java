package br.com.stoom.StoomBackend.util;

import br.com.stoom.StoomBackend.model.AddressTO;

public class AddressTestUtils {

	public static AddressTO getSomeAddress() {
		AddressTO someAddress = new AddressTO();
		someAddress.setStreetName("Kurt Joachim Hering");
		someAddress.setNumber(41);
		someAddress.setNeighbourhood("neighbourhood");
		someAddress.setCity("Limeira");
		someAddress.setState("SP");
		someAddress.setCountry("Brazil");
		someAddress.setZipCode("019");
		return someAddress;
	}
	
}

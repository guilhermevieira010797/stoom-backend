package br.com.stoom.StoomBackend.util;

import br.com.stoom.StoomBackend.model.AddressTO;

public class AddressTestUtils {

	public static AddressTO getSomeAddress() {
		AddressTO someAddress = new AddressTO();
		someAddress.setStreetName("Kurt Joachim Hering");
		someAddress.setNumber(41);
		someAddress.setNeighbourhood("Egistro Ragazzo");
		someAddress.setCity("Limeira");
		someAddress.setState("SP");
		someAddress.setCountry("Brazil");
		someAddress.setZipCode("019");
		return someAddress;
	}
	
	public static AddressTO getSomeInvalidAddress() {
		AddressTO someAddress = new AddressTO();
		someAddress.setStreetName("Kurt Joachim Hering");
		someAddress.setState("SP");
		someAddress.setCountry("Brazil");
		someAddress.setZipCode("019");
		return someAddress;
	}
	
	public static AddressTO getSomeNonexistentAddress() {
		AddressTO someAddress = new AddressTO();
		someAddress.setStreetName("Rua não existente");
		someAddress.setNumber(0);
		someAddress.setNeighbourhood("Bairro não existente");
		someAddress.setCity("Limeira");
		someAddress.setState("SP");
		someAddress.setCountry("Brazil");
		someAddress.setZipCode("019");
		return someAddress;
	}
	
	public static AddressTO getSomeUpdateAddress() {
		AddressTO someAddress = new AddressTO();
		someAddress.setId(1l);
		someAddress.setStreetName("Nova Rua");
		return someAddress;
	}
	
}

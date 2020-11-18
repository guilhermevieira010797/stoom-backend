package br.com.stoom.StoomBackend.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import br.com.stoom.StoomBackend.model.AddressTO;
import br.com.stoom.StoomBackend.services.AddressService;
import br.com.stoom.StoomBackend.util.AddressTestUtils;

public class AddAddressControllerIT {
	
	@Test
	public void createAddressWithoutLatitudeAndLongitude() throws ResponseStatusException, Exception {
		AddressService service = new AddressService();
		AddressTO itAddress = AddressTestUtils.getSomeAddress();
		assertThat(service.createAddress(itAddress));
	}
	
}

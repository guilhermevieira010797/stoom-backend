package br.com.stoom.StoomBackend.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.stoom.StoomBackend.model.AddressTO;
import br.com.stoom.StoomBackend.util.AddressTestUtils;

/**
 * <p>Address Rest Integration Tests</p>
 * @author guilherme_pinheiro
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AddressRestIntegrationTests {
	
	@Autowired
    private MockMvc mockMvc;

	@Autowired
    private ObjectMapper objectMapper;
    
	/**
	 * <p>Create address without latitude and longitude integration test</p>
	 * @throws Exception
	 */
    @Test
    void createAddressWithoutLatAndLongIntegrationTest() throws Exception {
    	AddressTO someAddress = AddressTestUtils.getSomeAddress();
    	mockMvc.perform(MockMvcRequestBuilders.post("/address")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(someAddress)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
    
    /**
     * <p>Create address with invalid required fields integration test</p>
     * @throws Exception
     */
    @Test
    void createInvalidAddressIntegrationTest() throws Exception {
    	AddressTO someInvalidAddress = AddressTestUtils.getSomeInvalidAddress();
    	mockMvc.perform(MockMvcRequestBuilders.post("/address")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(someInvalidAddress)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
    
    /**
     * <p>Create non existent address integration test</p>
     * @throws Exception
     */
    @Test
    void createNonexistentAddressIntegrationTest() throws Exception {
    	AddressTO someInvalidAddress = AddressTestUtils.getSomeNonexistentAddress();
    	mockMvc.perform(MockMvcRequestBuilders.post("/address")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(someInvalidAddress)))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError());
    }
    
    /**
     * <p>Get address by id after insertion integration test</p>
     * @throws Exception
     */
    @Test
    void getAddressAfterSuccessInsertion() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/address")
			.pathInfo("/1"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    /**
     * <p>List address after insertion integration test</p>
     * @throws Exception
     */
    @Test
    void listAddressAfterSuccessInsertion() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.get("/address"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    /**
     * <p>Update address after insertion integration test</p>
     * @throws Exception
     */
    @Test
    void updateAddressAfterSuccessInsertion() throws Exception {
    	AddressTO someInvalidAddress = AddressTestUtils.getSomeUpdateAddress();
    	mockMvc.perform(MockMvcRequestBuilders.put("/address")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(someInvalidAddress)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
    
    /**
     * <p>Delete address after insertion integration test</p>
     * @TODO - Allow [DELETE] Method at this endpoint.
     * @throws Exception
     */
    @Test
    void deleteAddressAfterSuccessIntegrationTests() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/address")
			.pathInfo("/1"))
    		.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
    
}

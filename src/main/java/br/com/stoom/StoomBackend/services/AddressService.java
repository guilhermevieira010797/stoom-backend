package br.com.stoom.StoomBackend.services;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.stoom.StoomBackend.configurations.ConnectionManager;
import br.com.stoom.StoomBackend.mappers.AddressListRowMapper;
import br.com.stoom.StoomBackend.mappers.AddressRowMapper;
import br.com.stoom.StoomBackend.model.AddressTO;
import br.com.stoom.StoomBackend.model.GeoInformation;
import br.com.stoom.StoomBackend.model.GeoResult;

@Service
public class AddressService {
	
	private RestTemplate rest;
	private JdbcTemplate jdbc;
	private static final String googleKey = "AIzaSyDTK0igIQTCi5EYKL9tzOIJ9N6FUASGZos";
	protected Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	public AddressService() throws SQLException {
		jdbc = ConnectionManager.getConnection();
		rest = new RestTemplate();
		logger.info("Database connection established...");
	}
	
	public Void createAddress(AddressTO address) throws ResponseStatusException, Exception {
		logger.info("Starting flow for address insertion...");
		address = validateAddress(address);
		jdbc.update("INSERT INTO ADDRESS(street_name, number, neighbourhood, city, state, country, zip_code, complement, latitude, longitude) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
				address.getStreetName(),
				address.getNumber(),
				address.getNeighbourhood(),
				address.getCity(),
				address.getState(),
				address.getCountry(),
				address.getZipCode(),
				address.getComplement(),
				address.getLatitude(),
				address.getLongitude());
		return null;
	}
	
	public Void updateAddress(AddressTO address) throws DataAccessException {
		logger.info("Starting flow for address update...");
		StringBuilder sql = new StringBuilder("UPDATE ADDRESS SET");
		if (address.getStreetName() != null) sql.append(" ADDRESS.STREET_NAME = '" + address.getStreetName() + "',");
		if (address.getNumber() != null) sql.append(" ADDRESS.NUMBER = '" + address.getNumber() + "'");
		if (address.getNeighbourhood() != null) sql.append(" ADDRESS.NEIGHBOURHOOD = '" + address.getNeighbourhood() + "',");
		if (address.getCity() != null) sql.append(" ADDRESS.CITY = '" + address.getCity() + "',");
		if (address.getState() != null) sql.append(" ADDRESS.STATE = '" + address.getState() + "',");
		if (address.getCountry() != null) sql.append(" ADDRESS.COUNTRY = '" + address.getCountry() + "',");
		if (address.getZipCode() != null) sql.append(" ADDRESS.ZIP_CODE = '" + address.getZipCode() + "',");
		if (address.getComplement() != null) sql.append(" ADDRESS.COMPLEMENT = '" + address.getComplement() + "',");
		if (address.getLatitude() != null) sql.append(" ADDRESS.LATITUDE = '" + address.getLatitude() + "',");
		if (address.getLongitude() != null) sql.append(" ADDRESS.LONGITUDE = '" + address.getLongitude() + "',");
		sql.deleteCharAt(sql.lastIndexOf(","));
		sql.append(" WHERE ADDRESS.ID = " + address.getId() + "");
		logger.info("Update query: " + sql.toString());
		jdbc.update(sql.toString());
		logger.info("Address updated successfully");
		return null;
	}
	
	public AddressTO getAddress(String id) throws DataAccessException {
		logger.info("Starting flow for obtaining address by id...");
		String sql = "SELECT * FROM ADDRESS WHERE ADDRESS.id = " + id + "";
		Object address = jdbc.queryForObject(sql, new AddressRowMapper());
		logger.info("Address obtained successfully");
		return (AddressTO) address;
	}
	
	public List<AddressTO> listAddress() throws DataAccessException {
		logger.info("Starting flow for obtaining the address list...");
		List<AddressTO> ret = jdbc.query("SELECT * FROM ADDRESS", new AddressListRowMapper());
		logger.info("List successfully obtained");
		return ret;
	}
	
	public Void deleteAddress(String id) throws DataAccessException {
		logger.info("Starting flow for address removal...");
		jdbc.update("DELETE FROM ADDRESS WHERE ADDRESS.id = " + id + "");
		logger.info("Address removed successfully");
		return null;
	}
	
	private AddressTO validateAddress(AddressTO address) throws ResponseStatusException, Exception {
		validateAddressFields(address);
		if (address.getLatitude() == null || address.getLongitude() == null) {
			String street = address.getStreetName().replace(" ", "+");
			String city = address.getCity().replace(" ", "+");
			String country = address.getCountry().replace(" ", "+");
			String params = String.valueOf(address.getNumber() + "+" + street + ",+" + city + ",+" + country + "&key=" + googleKey);
			String URL = "https://maps.googleapis.com/maps/api/geocode/json?address=".concat(params);
			logger.info("Sending GET Request for google geocode api with url: " + URL);
			GeoResult geoResult = getGeoLocation(URL);
			String latitude = geoResult.getGeometry().getLocation().getLat();
			String longitude = geoResult.getGeometry().getLocation().getLng();
			logger.info("Found geo-location latitude: " + latitude);
			logger.info("Found geo-location longitude: " + longitude);
			address.setLatitude(latitude);
			address.setLongitude(longitude);
		}
		return address;
	}
	
	public GeoResult getGeoLocation(String URL) throws ResponseStatusException, Exception {
		String geoResponse = rest.getForObject(URL, String.class);
		GeoInformation geoInfo = new ObjectMapper().readValue(geoResponse, GeoInformation.class);
		if (geoInfo.getStatus().equals("OK"))
			return geoInfo.getResults()[0];
		else {
			String log = "Unable to find geo-location details for reference";
			logger.error(log);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, log);
		}
	}
	
	private void validateAddressFields(AddressTO address) throws ResponseStatusException {
		if (address.getStreetName() == null || address.getNumber() == null || address.getNeighbourhood() == null ||
			address.getCity() == null || address.getState() == null || address.getCountry() == null || address.getZipCode() == null)
		{
			String log = "There are unfilled fields that cannot be null";
			logger.error(log);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, log);
		}
	}

}

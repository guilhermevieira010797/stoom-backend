package br.com.stoom.StoomBackend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.stoom.StoomBackend.model.AddressTO;

public class AddressRowMapper implements RowMapper<AddressTO> {

	@Override
	public AddressTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		AddressTO address = new AddressTO();
		address.setId(rs.getLong("id"));
		address.setStreetName(rs.getString("street_name"));
		address.setNumber(rs.getInt("number"));
		address.setNeighbourhood(rs.getString("neighbourhood"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setCountry(rs.getString("country"));
		address.setZipCode(rs.getString("zip_code"));
		address.setComplement(rs.getString("complement"));
		address.setLatitude(rs.getString("latitude"));
		address.setLongitude(rs.getString("longitude"));
		return address;
	}
}

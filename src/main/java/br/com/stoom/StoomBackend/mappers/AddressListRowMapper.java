package br.com.stoom.StoomBackend.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import br.com.stoom.StoomBackend.model.AddressTO;

public class AddressListRowMapper implements ResultSetExtractor<List<AddressTO>> {

	@Override
	public List<AddressTO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<AddressTO> addressList = new ArrayList<AddressTO>();
		while(rs.next()) {
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
			addressList.add(address);
		}
		return addressList;
	}

}

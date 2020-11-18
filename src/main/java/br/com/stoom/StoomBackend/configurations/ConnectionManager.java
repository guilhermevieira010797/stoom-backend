package br.com.stoom.StoomBackend.configurations;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionManager {

	private static final String url  = "jdbc:h2:file:~/test";
	private static final String username = "stoom";
	private static final String password = "stoom123@@";
	
	private static JdbcTemplate INSTANCE;
	
	public static JdbcTemplate getConnection() throws SQLException {
		return INSTANCE == null ? new JdbcTemplate(getDataSource()) : INSTANCE;
	}
	
	@SuppressWarnings("rawtypes")
	private static DataSource getDataSource() {
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
	}
	
}

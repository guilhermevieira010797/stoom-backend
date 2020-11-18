package br.com.stoom.StoomBackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import br.com.stoom.StoomBackend.configurations.ConnectionManager;

@SpringBootApplication
public class StoomBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StoomBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		JdbcTemplate jdbc = ConnectionManager.getConnection();
		jdbc.execute("DROP TABLE IF EXISTS ADDRESS");
		jdbc.execute("CREATE TABLE ADDRESS(" +
		        "id SERIAL, street_name VARCHAR(255), number INT, neighbourhood VARCHAR(255), city VARCHAR(255), state VARCHAR(255), country VARCHAR(255), zip_code VARCHAR(255), complement VARCHAR(255), latitude VARCHAR(255), longitude VARCHAR(255))");
	}

}

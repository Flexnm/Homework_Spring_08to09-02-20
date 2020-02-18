package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Driver;

@Component
public class DriversDBDAO implements DriversDAO, RowMapper<Driver> {

	@Autowired
	private JdbcTemplate jt;

	public void addDriver(Driver driver) {
		jt.update("INSERT INTO drivers(name, birthdate, the_car_id) values(?, ?, ?);", driver.getName(),
				driver.getBirthDate(), driver.getCarID());
	}

	public void deleteDriver(int id) {
		jt.update("DELETE FROM drivers WHERE id = " + id);
	}

	public List<Driver> getAllDrivers() {
		return jt.query("SELECT * FROM drivers", this);
	}

	public Driver getOneDriver(int id) {
		return jt.queryForObject("SELECT * FROM drivers WHERE id = " + id, this);
		
	}

	public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Driver(rs.getInt("id"), rs.getString("name"), rs.getDate("birthdate"), rs.getInt("the_car_id"));
	}

}

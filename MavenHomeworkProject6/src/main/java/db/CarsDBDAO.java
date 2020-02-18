package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Car;

@Component
public class CarsDBDAO implements CarsDAO,  RowMapper<Car> {

	@Autowired
	private JdbcTemplate jt;
	
	public void addCar(Car car) {
		jt.update("INSERT INTO cars(model, color, year) values(?, ?, ?)", car.getModel(), car.getColor(), car.getYear());
	}

	public void deleteCar(int id) {
		jt.update("DELETE FROM cars WHERE id = " + id);
	}

	public List<Car> getAllCars() {
		return jt.query("SELECT * FROM cars", this);
	}

	public Car getOneCar(int id) {
		return jt.queryForObject("SELECT * FROM cars WHERE id = " + id, this);
	}

	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Car(rs.getInt("id"), rs.getString("model"), rs.getString("color"), rs.getInt("year"));
	}

}

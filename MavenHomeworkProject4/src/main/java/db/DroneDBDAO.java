package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import beans.Drone;

@Component
public class DroneDBDAO implements RowMapper<Drone> {

	@Autowired
	private JdbcTemplate jt;

	public void addDrone(Drone drone) {
		jt.update(
				"INSERT INTO drones(manufacturer, model, camera_megpixel, flight_range, price) values(?, ?, ?, ?, ?)",
				drone.getManufacturer(), drone.getModel(), drone.getCameraPix(), drone.getFlightRange(),
				drone.getPrice());
	}

	public void deleteDrone(int id) {
		jt.update("DELETE FROM drones WHERE id = " + id);
	}

	public void updateDrone(Drone drone) {
		jt.update("UPDATE drones SET manufacturer = '" + drone.getManufacturer() + "', model = '" + drone.getModel()
				+ "', camera_megpixel = " + drone.getCameraPix() + ", flight_range = " + drone.getFlightRange()
				+ ", price = " + drone.getPrice() + " WHERE id = " + drone.getId());
	}

	public List<Drone> getAllDrones() {
		return jt.query("SELECT * FROM drones", this);
	}
	
	public List<Drone> getDronesByPrice(double price) {
		return jt.query("SELECT * FROM drones WHERE price <= " + price, this);
	}
	
	public List<Drone> getDronesByManufacturer(String manufacturer){
		return jt.query("SELECT * FROM drones WHERE manufacturer = '" + manufacturer + "'", this);
	}
	
	public List<Drone> getDronesByCameraPix(int cameraPix){
		return jt.query("SELECT * FROM drones WHERE camera_megpixel = " + cameraPix, this);
	}

	public Drone mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Drone(rs.getInt("id"), rs.getString("manufacturer"), rs.getString("model"),
				rs.getInt("camera_megpixel"), rs.getDouble("flight_range"), rs.getDouble("price"));
	}

}

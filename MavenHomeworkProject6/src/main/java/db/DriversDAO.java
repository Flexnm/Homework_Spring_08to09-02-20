package db;

import java.util.List;

import org.springframework.stereotype.Component;

import beans.Driver;
@Component
public interface DriversDAO {
	
	public void addDriver(Driver driver);
	
	public void deleteDriver(int id);
	
	public List<Driver> getAllDrivers();
	
	public Driver getOneDriver(int id);

}

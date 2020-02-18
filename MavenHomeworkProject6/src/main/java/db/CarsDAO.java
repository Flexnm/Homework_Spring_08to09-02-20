package db;

import java.util.List;

import org.springframework.stereotype.Component;

import beans.Car;
@Component
public interface CarsDAO {
	
public void addCar(Car driver);
	
	public void deleteCar(int id);
	
	public List<Car> getAllCars();
	
	public Car getOneCar(int id);

}

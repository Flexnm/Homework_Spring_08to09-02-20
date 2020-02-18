package test;

import java.sql.Date;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.Car;
import beans.Driver;
import config.SpringConfig;
import db.CarsDBDAO;
import db.DriversDBDAO;

public class Program {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {
			
			DriversDBDAO driverDB = ctx.getBean(DriversDBDAO.class);
			CarsDBDAO carDB = ctx.getBean(CarsDBDAO.class);
			
//			carDB.addCar(new Car("Ferrari", "Red", 2015));
			driverDB.addDriver(new Driver("Driver Man", Date.valueOf("1975-04-11"), 2));
			
		}
	}

}

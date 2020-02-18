package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.SpringConfig;
import db.DroneDBDAO;

public class Program {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class)) {

			DroneDBDAO droneDB = ctx.getBean(DroneDBDAO.class);

//			droneDB.addDrone(new Drone("flightEX", "SPEEDY", 20, 500, 100));
//			droneDB.addDrone(new Drone("flightEX", "SuperRange", 40, 2000, 1500));
//			droneDB.addDrone(new Drone("Manuverer", "The Blerb", 25, 700, 200));
			
			
			System.out.println(droneDB.getDronesByCameraPix(40));
			System.out.println(droneDB.getDronesByManufacturer("flightEX"));
			System.out.println(droneDB.getDronesByPrice(200));
			
//			droneDB.updateDrone(new Drone(3, "Manuverer", "The Blerb", 100, 3000, 5000));
//			System.out.println(droneDB.getDronesByManufacturer("Manuverer"));
			
			droneDB.deleteDrone(1);
			System.out.println(droneDB.getAllDrones());
		}

	}

}

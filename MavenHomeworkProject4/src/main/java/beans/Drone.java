package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Drone {
	
	private int id;
	private String manufacturer;
	private String model;
	private int cameraPix;
	private double flightRange;
	private double price;
	
	public Drone(String manufacturer, String model, int cameraPix, double flightRange, double price) {
		setManufacturer(manufacturer);
		setModel(model);
		setCameraPix(cameraPix);
		setFlightRange(flightRange);
		setPrice(price);
	}
	
	public Drone(int id, String manufacturer, String model, int cameraPix, double flightRange, double price) {
		this.id = id;
		setManufacturer(manufacturer);
		setModel(model);
		setCameraPix(cameraPix);
		setFlightRange(flightRange);
		setPrice(price);
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getCameraPix() {
		return cameraPix;
	}
	
	public double getFlightRange() {
		return flightRange;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getId() {
		return id;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setCameraPix(int cameraPix) {
		this.cameraPix = cameraPix;
	}
	
	public void setFlightRange(double flightRange) {
		this.flightRange = flightRange;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Manufacturer: " + manufacturer + ", Model: " + model;
	}

}

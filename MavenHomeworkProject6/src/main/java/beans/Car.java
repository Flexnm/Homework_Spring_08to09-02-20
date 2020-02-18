package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {

	private int id;
	private String model;
	private String color;
	private int year;

	public Car(String model, String color, int year) {
		setModel(model);
		setColor(color);
		setYear(year);
	}

	public Car(int id, String model, String color, int year) {
		this.id = id;
		setModel(model);
		setColor(color);
		setYear(year);
	}

	public int getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getYear() {
		return year;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return "Car: " + model + ", Color: " + color + ", Year: " + year;
	}

}

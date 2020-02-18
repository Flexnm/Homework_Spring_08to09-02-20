package beans;

import java.sql.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Driver {

	private int id;
	private String name;
	private Date birthDate;
	private int carID;

	public Driver(String name, Date birthDate, int carID) {
		setName(name);
		setBirthDate(birthDate);
		setCarID(carID);
	}

	public Driver(int id, String name, Date birthDate, int cadId) {
		this.id = id;
		setName(name);
		setBirthDate(birthDate);
		setCarID(carID);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public int getCarID() {
		return carID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}
	
	public String toString() {
		return "Driver: " + id + ", Name: " + name + ", Birthdate: " + birthDate + ", Car: " + carID;
	}

}

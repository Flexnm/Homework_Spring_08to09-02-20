package beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Author {

	private int id;
	private String name;
	private String email;
	private int age;

	public Author(int id, String name, String email, int age) {
		this.id = id;
		setName(name);
		setEmail(email);
		setAge(age);
	}
	
	public Author(String name, String email, int age) {
		setName(name);
		setEmail(email);
		setAge(age);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Author name: " + name + ", Email: " + email + ", Age: " + age;
	}

}

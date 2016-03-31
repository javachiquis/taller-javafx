package tallerjavafx.model;

import javafx.beans.property.SimpleStringProperty;

public class Employee {

	private SimpleStringProperty name;
	private SimpleStringProperty department;
	private SimpleStringProperty email;

	public Employee(String name, String department, String email) {
		this.name = new SimpleStringProperty(name);
		this.department = new SimpleStringProperty(department);
		this.email = new SimpleStringProperty(email);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String fName) {
		this.name.set(fName);
	}

	public String getDepartment() {
		return department.get();
	}

	public void setDepartment(String fName) {
		this.department.set(fName);
	}
	
	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}
}
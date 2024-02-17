package omar.jdbc.project.model;

import java.util.Date;

public class Employee {
private int  id;
private String name;
private boolean  gender;
private Date birDate;
private double slalay;

public Employee() {

}

public Employee(int id ,String name, boolean gender, Date birDate, double slalay) {
	super();
	this.id = id;
	this.name = name;
	this.gender = gender;
	this.birDate = birDate;
	this.slalay = slalay;
}



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isGender() {
	return gender;
}

public void setGender(boolean gender) {
	this.gender = gender;
}

public Date getBirDate() {
	return birDate;
}

public void setBirDate(Date birDate) {
	this.birDate = birDate;
}

public double getSlalay() {
	return slalay;
}

public void setSlalay(double slalay) {
	this.slalay = slalay;
}
public static EmployeeBuilder builder() {
    return new EmployeeBuilder();
}

@Override
public String toString() {
	return "Employee [id=" + id + 
			", name=" + name 
			+ 
			", gender=" + gender 
			+
			", birDate=" + birDate 
			+
			", slalay="	+ slalay 
			+ "]";
}



	
	
}

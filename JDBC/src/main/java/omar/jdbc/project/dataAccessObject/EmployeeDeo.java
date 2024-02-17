package omar.jdbc.project.dataAccessObject;

import java.util.List;

import omar.jdbc.project.model.Employee;



public interface EmployeeDeo {
	List<Employee>findAll(); 
	Employee findById(int id);
	List<Employee>findByName(String name);
	 
	
	void save(Employee employee);

	void deletAll();
	void deletById(int id);

}

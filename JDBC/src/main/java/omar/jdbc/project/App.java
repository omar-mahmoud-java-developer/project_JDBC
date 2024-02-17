package omar.jdbc.project;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import omar.jdbc.project.dataAccessObject.EmployeeDeo;
import omar.jdbc.project.dataAccessObject.EmployeeiImplementation;
import omar.jdbc.project.model.Employee;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	
   
    	
   	EmployeeDeo employeeDeo =new EmployeeiImplementation();
   	
   	
   	//insert Employee
	    Employee employee1 =new Employee(0,"employee1",false, new Date(),100.5);
    	Employee employee2 =new Employee(0,"employee2",true, new Date(), 200d);
    	Employee employee3 =new Employee(0,"employee3",true, new Date(), 300.5);
    	
    	employeeDeo.save(employee1);
    	employeeDeo.save(employee2);
    	employeeDeo.save(employee3);
    	
      	// Update Employee name & salary
    	  Employee employee5 =new Employee(0,"employee5",false, new Date(),599.9);
    	
   	
   	
 
   	//search by id
    	  Employee emp= employeeDeo.findById(1);
    	  System.out.println(emp);
    	  
    	  
   	//search by name
    	  System.out.println( employeeDeo .findByName("employee2"));
   	//delete by id
    	  employeeDeo.deletById(3);
   	//delete  all
    	  employeeDeo.deletAll();
    	  
   	// find all Employee 
    	  List<Employee> empAll= employeeDeo.findAll();
    	System.out.println(empAll);
   	
  
    }
}

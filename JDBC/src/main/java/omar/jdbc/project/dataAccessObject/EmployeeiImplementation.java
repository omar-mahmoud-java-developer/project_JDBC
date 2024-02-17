package omar.jdbc.project.dataAccessObject;

import java.sql.Array;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import omar.jdbc.project.model.Employee;
import omar.jdbc.project.model.EmployeeBuilder;
import omar.jdbc.project.util.Util;



public class EmployeeiImplementation  implements EmployeeDeo{
//// find all employee form database
//	@Override
//	public List<Employee> findAll() {
//		Connection connection=DBConnection.getConnection();
//		if(connection==null) {
//			return null;
//			
//		}
//		List<Employee>employees=new LinkedList<Employee>();
//	     String query = "SELECT * FROM employee;";
//	     try(PreparedStatement preparedStatement=connection.prepareStatement(query)) {
//	    	 ResultSet result = preparedStatement.executeQuery();
//	    	 while (result.next()) {
//	    		 Employee employee = new Employee(result.getInt("id"),
//	    				 result.getString("name"),
//	    				 result.getBoolean("gender"),
//	    				 result.getDate("birth_date"),
//	    				 result.getDouble("salary"));
//	    		 employees.add(employee);
//	    		 
//	    		 
//	    		 
//	    	 }
//	    	 
//	    	 
//	     } catch(SQLException se) {
//	            se.printStackTrace();
//	        } finally {
//	            try {
//	                connection.close();
//	            } catch(SQLException se) {
//	                se.printStackTrace();
//	            }
//	        }
//
//	        return employees;
//		
//	}
	
	
	// builder design pattern
	//find all employee form database
	@Override
	public List<Employee> findAll() {
		Connection connection=DBConnection.getConnection();
		if(connection==null) {
			return null;
			
		}
		List<Employee>employees=new LinkedList<Employee>();
	     String query = "SELECT * FROM employee;";
	     try(PreparedStatement preparedStatement=connection.prepareStatement(query)) {
	    	 ResultSet result = preparedStatement.executeQuery();
	    	 while (result.next()) {
	    		 Employee employee = Employee.builder()
	    			
	    				    .id(result.getInt("id"))
	                        .name(result.getString("name"))
	                        .gender(result.getBoolean("gender"))
	                        .birthDate(result.getDate("birth_date"))
	                        .salary(result.getDouble("salary"))
	                        .build();
	    		 employees.add(employee);
	    		 
	    		 
	    		 
	    	 }
	    	 
	    	 
	     } catch(SQLException se) {
	            se.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch(SQLException se) {
	                se.printStackTrace();
	            }
	        }

	        return employees;
		
	}

	

	@Override
	public Employee findById(int id) {
	Connection connection=DBConnection.getConnection();
	if(connection==null) {
		return null;
	}
	 String query = "SELECT * FROM employee WHERE id=?;";
	try (PreparedStatement preparedStatement=connection.prepareStatement(query)){
		preparedStatement.setInt(1, id);
		ResultSet result=preparedStatement.executeQuery();
		if(result.next()) {
			
			
			return new Employee(result.getInt("id"),
   				 result.getString("name"),
   				 result.getBoolean("gender"),
   				 result.getDate("birth_date"),
   				 result.getDouble("salary"));
			
			
		}
		
		
		
		
	} catch(SQLException se) {
        se.printStackTrace();
    } finally {
        try {
            connection.close();
        } catch(SQLException se) {
            se.printStackTrace();
        }
    }

    return null;
	}


	
	@Override
	public List<Employee> findByName(String name) {
	    Connection connection = DBConnection.getConnection();
	    if (connection == null) {
	        return null;
	    }

	    List<Employee> employees = new LinkedList<>();
	    String query = "SELECT * FROM employee WHERE name = ?";

	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	      
	        preparedStatement.setString(1, name);
	        ResultSet result = preparedStatement.executeQuery();

	        while (result.next()) {
	            Employee employee = Employee.builder()
	                    .id(result.getInt("id"))
	                    .name(result.getString("name"))
	                    .gender(result.getBoolean("gender"))
	                    .birthDate(result.getDate("birth_date"))
	                    .salary(result.getDouble("salary"))
	                    .build();
	            employees.add(employee);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle specific exception types for more meaningful feedback
	    } finally {
	        try {
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return employees;
	}

//	public List<Employee>findbyname(String name){
//		
//		Connection connection=DBConnection.getConnection();
//		if(connection==null) {
//			return null;
//		}
// List<Employee> employees = new LinkedList<>();
//		  String query = "SELECT * FROM employee WHERE name LIKE ?";
//		try (PreparedStatement preparedStatement=connection.prepareStatement(qurey)){
//			preparedStatement.setString(1, name);
////		
//			ResultSet result=preparedStatement.executeQuery();
//			if(result.next()) {
	
//	   				 result.getInt("id"),
//	   				 result.getBoolean("gender"),
//	   				 result.getDate("birth_date"),
//	   				 result.getDouble("salary"));
//				
//				
//			}
//			
//			
//			
//			
//		} catch(SQLException se) {
//	        se.printStackTrace();
//	    } finally {
//	        try {
//	            connection.close();
//	        } catch(SQLException se) {
//	            se.printStackTrace();
//	        }
//	    }
//		
//		return null;
//		
//		
//		
//		
//	}
	
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		if(connection==null) {
			return;
		}
		// اليوز موجود وعاوز اعمل ابديت للداتا UPDATE
		if (employee.getId()>0){
			String query = "UPDATE employee SET name=?, gender=?, birth_date=?, salary=? WHERE id=?;";
			try(PreparedStatement preparedStatement =connection.prepareStatement(query)) {
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setBoolean(2, employee.isGender());
				preparedStatement.setDate(3, Util.getsqlDate( employee.getBirDate()));
				preparedStatement.setDouble(4,employee.getSlalay());
				   preparedStatement.setInt(5, employee.getId());
				preparedStatement.executeUpdate();
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
			
			
			
		
		//create
		else {
			String query = "INSERT INTO employee (name, gender, birth_date, salary) VALUES (?, ?, ?, ?);";
			try(PreparedStatement preparedStatement =connection.prepareStatement(query)) {
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setBoolean(2, employee.isGender());
				preparedStatement.setDate(3, Util.getsqlDate( employee.getBirDate()));
				preparedStatement.setDouble(4,employee.getSlalay());
				preparedStatement.executeUpdate();
		
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}
	

	@Override
	public void deletAll() {
		Connection connection=DBConnection.getConnection();
		if(connection==null) {
			return ;
		}
		String query = "DELETE  FROM employee ;";
		try(PreparedStatement preparedStatement =connection.prepareStatement(query)) {
			preparedStatement.executeLargeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		
	}

	@Override
	public void deletById(int id) {
		Connection connection=DBConnection.getConnection();
		if(connection==null) {
			return ;
		}

        String query = "DELETE FROM employee WHERE id=?;";
		try(PreparedStatement preparedStatement =connection.prepareStatement(query)){
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	

}

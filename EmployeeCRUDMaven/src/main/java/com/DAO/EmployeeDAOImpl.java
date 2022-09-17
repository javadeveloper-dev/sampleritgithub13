package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.EmployeeModel;
import com.Service.EmployeeServiceImpl;
import com.DAO.EmployeeDAO;
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final  EmployeeModel employee = null;
	private static final int id = 0;
	
	@Override
	public void EmployeeDAO() {
		
		
	}
	
	public Connection getConnection() {
		Connection connection=null;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/EMP?allowPublicKeyRetrieval=true&useSSL=false","root","root");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return connection;
	}

	public void insertEmployee(EmployeeModel employee) {
		System.out.println("INSERT_EMPLOYEE_SQL");
   	 try
   	 {
   		
   		 Connection connection=getConnection();
   		 System.out.println("DAO insert method called ..");
   		 PreparedStatement preparedstatementForInsertEmployee=connection.prepareStatement(INSERT_EMPLOYEE_SQL);
   		 
   		 preparedstatementForInsertEmployee.setString(1,employee.getfirstName());
   		 preparedstatementForInsertEmployee.setString(2,employee.getfirstName());
   		 preparedstatementForInsertEmployee.setString(3,employee.getSkills());
   		 preparedstatementForInsertEmployee.setString(4,employee.getAge());
   		 preparedstatementForInsertEmployee.setString(5,employee.getSalary());
   		 preparedstatementForInsertEmployee.setString(6,employee.getdateOfJoining());
   		 System.out.println(preparedstatementForInsertEmployee);
   		 
   		 preparedstatementForInsertEmployee.executeUpdate();
   	 }
   	 catch(Exception e)
   	 {
   		 e.printStackTrace();
      }
	}

	public EmployeeModel selectEmployee(int id) {
		
		EmployeeModel employee = null;
		
        try
        {
       	 Connection connection=getConnection();
       	 
       	 PreparedStatement preparedstatementForSelectEmployeeById=connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
       	 preparedstatementForSelectEmployeeById.setInt(1,id);
       	 System.out.println(preparedstatementForSelectEmployeeById);
       	 
       	 ResultSet resultSetForSelectEmployeeById=preparedstatementForSelectEmployeeById.executeQuery();
       	 
       	 while(resultSetForSelectEmployeeById.next())
       	{
       		 
       		 String firstName=resultSetForSelectEmployeeById.getString("firstName");
       		 String lastName=resultSetForSelectEmployeeById.getString("lastName");
       		 String skills=resultSetForSelectEmployeeById.getString("skills"); 
       		 String age=resultSetForSelectEmployeeById.getString("age");
       		 String salary=resultSetForSelectEmployeeById.getString("salary");
       		 String dateOfJoining=resultSetForSelectEmployeeById.getString("dateOfJoining");
       		 
       		 employee=new EmployeeModel(id,firstName,lastName,skills,age,salary,dateOfJoining);
       		 
       	 }
       	 
        }
        catch(Exception e)
        {
        	
       	 e.printStackTrace();
       	 
        }
        
   	 return employee;
   	 
	}


	public List<EmployeeModel> selectAllEmployee() {
		
		 List<EmployeeModel> employeeList=new ArrayList();
		 
    	 try
    	 {
    		 
    		 Connection connection=getConnection();
    		 
    		 PreparedStatement preparedstatementForSelectAllEmployee=connection.prepareStatement(SELECT_ALL_EMPLOYEE);
    		 System.out.println(preparedstatementForSelectAllEmployee);
    		 
    		 ResultSet resultsetForSelectAllEmployee=preparedstatementForSelectAllEmployee.executeQuery();
    		
    		 while(resultsetForSelectAllEmployee.next())
    		 {
    			 
    			 int id=resultsetForSelectAllEmployee.getInt("id");
    			 String firstName=resultsetForSelectAllEmployee.getString("firstName");
    			 String lastName=resultsetForSelectAllEmployee.getString("lastName");
    			 String skills=resultsetForSelectAllEmployee.getString("skills");
    			 String age=resultsetForSelectAllEmployee.getString("age");
    			 String salary=resultsetForSelectAllEmployee.getString("salary");
    			 String dateOfJoining=resultsetForSelectAllEmployee.getString("dateOfJoining");
    			 
    			 employeeList.add(new EmployeeModel(id,firstName,lastName,skills,age,salary,dateOfJoining));
    		 }
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
		return employeeList;
	}

	 public  boolean updateEmployee(EmployeeModel employee)
     {
    	 System.out.println();
		boolean udpatedEmployeeDetail = false;
		
		try(Connection connection = getConnection();
				
			PreparedStatement preparedstatementForUpdateEmployee=connection.prepareStatement(UPDATE_EMPLOYEE_SQL);)
			{
			
			System.out.println("Updated User"+employee);
			preparedstatementForUpdateEmployee.setString(1,employee.getfirstName());
			preparedstatementForUpdateEmployee.setString(2,employee.getfirstName());
			preparedstatementForUpdateEmployee.setString(3,employee.getSkills());
			preparedstatementForUpdateEmployee.setString(4,employee.getAge());
			preparedstatementForUpdateEmployee.setString(5,employee.getSalary());
			preparedstatementForUpdateEmployee.setString(6,employee.getdateOfJoining());
			preparedstatementForUpdateEmployee.setInt(7,employee.getId());
			
			System.out.println("Updated pstmt"+preparedstatementForUpdateEmployee);
			udpatedEmployeeDetail=preparedstatementForUpdateEmployee.executeUpdate()>0;
			System.out.println("updated: "+preparedstatementForUpdateEmployee.executeUpdate());
		}
    	 catch(Exception e)
		{
    		 e.printStackTrace();
		}
		return udpatedEmployeeDetail;
     }
	 
	 public   boolean deleteEmployee(int id) throws Exception
     {
		 
		boolean deleteEmployee = false;
		try(Connection connection=getConnection();
				
			PreparedStatement preparedstatementForDeleteEmployee=connection.prepareStatement(DELETE_EMPLOYEE_BY_ID);)
		    {
			
			preparedstatementForDeleteEmployee.setInt(1,id);
			deleteEmployee=preparedstatementForDeleteEmployee.executeUpdate()>0;
			
		    }
		
		return deleteEmployee;
    	 
     }

	    public static void main(String args[]) throws Exception
	    {
	    	
	    	EmployeeServiceImpl employeeDAO=new EmployeeServiceImpl();
	    	((com.DAO.EmployeeDAO) employeeDAO).insertEmployee(employee);
	    	((com.DAO.EmployeeDAO) employeeDAO).selectEmployee(id);
	    	employeeDAO.selectAllEmployee();
	    	((com.DAO.EmployeeDAO) employeeDAO).deleteEmployee(id);
	    	((com.DAO.EmployeeDAO) employeeDAO).updateEmployee(employee);
	    }
}

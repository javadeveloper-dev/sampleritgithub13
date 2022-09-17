package com.Service;

import java.sql.Connection;
import java.util.List;

import com.Model.EmployeeModel;


public interface EmployeeService {
	
	
	public Connection getConnection();
	
    public   void insertEmployee(EmployeeModel employee);
	
	public EmployeeModel selectEmployee(int id);
    
	public   List<EmployeeModel> selectAllEmployee();
	
	public  boolean updateEmployee(EmployeeModel employee);

	public  boolean deleteEmployee(int id) throws Exception;
}

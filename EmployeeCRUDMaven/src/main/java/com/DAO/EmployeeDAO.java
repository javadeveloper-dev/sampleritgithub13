package com.DAO;
import java.sql.*;
import java.util.*;

import com.Model.EmployeeModel;
public interface EmployeeDAO {
    public  static final String INSERT_EMPLOYEE_SQL= "INSERT INTO Employee1"+"(firstname,lastname,skills,age,salary,doj)Values"+"(?,?,?,?,?,?)";
	
	public  static final String SELECT_EMPLOYEE_BY_ID="select * from Employee1 where id=?";
	
	public  static final String SELECT_ALL_EMPLOYEE="select * from Employee1";
	public  static final String DELETE_EMPLOYEE_BY_ID="delete from Employee1 where id=?";
	public  static final String UPDATE_EMPLOYEE_SQL="update Employee1 set firstname=?,lastname=?,skills=?,age=?,salary=?,doj=? where id=?";
	
	public void EmployeeDAO();
	
	public Connection getConnection();
	
	public   void insertEmployee(EmployeeModel employee);
	
	public EmployeeModel selectEmployee(int id);
    
	public   List<EmployeeModel> selectAllEmployee();
	
	public  boolean updateEmployee(EmployeeModel employee);

	public  boolean deleteEmployee(int id) throws Exception;

	
	
	

	
	
}

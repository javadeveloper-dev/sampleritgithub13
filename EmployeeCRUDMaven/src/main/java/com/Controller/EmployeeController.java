package com.Controller;

import java.util.*;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.DAO.EmployeeDAO;
import com.Model.EmployeeModel;
import com.Service.EmployeeService;

@WebServlet("/")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDAO empDAO;
    
    public EmployeeController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getServletPath();
		switch(action)
		{
		 case "/new" :
			 showNewForm(request,response);
			 break;
		 case "/insert":
			 try {
				insertNewEmployee(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			 break;
		 case "/delete":
			 try {
				deleteEmployee(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 break;
		 case "/edit":
			 showEditForm(request,response);
			 break;
		 case "/update":
			 try {
				updateEmployee(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 break;
		 default: 
			  listEmployee(request,response);  
			 break;
		}
	}
		private void showNewForm(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		{
			RequestDispatcher dispatcher=req.getRequestDispatcher("WEB-INF\\Views\\EmployeeRegistration.jsp");
			dispatcher.forward(req,res);
		}
		private void insertNewEmployee(HttpServletRequest request,HttpServletResponse response) throws IOException,SQLException, ClassNotFoundException
		{
			EmployeeService employeeService = null;
			String firstName=request.getParameter("empfname");
			String lastName=request.getParameter("emplname");
			String employee_skills_array[] = new String[0];
			String checked_employee_skills="";				
			if(request.getParameterValues("empSkills")!=null) {
				employee_skills_array=request.getParameterValues("empSkills");
				checked_employee_skills=employee_skills_array[0];
			}
		
			for(int i=1;i<employee_skills_array.length;i++)
			{
				checked_employee_skills+=","+employee_skills_array[i];
			}
			String skills=checked_employee_skills;

			System.out.println(skills);
			String age=request.getParameter("empage");
			String salary=request.getParameter("empsalary");
			String dateOfJoining=request.getParameter("empdoj");

			
			EmployeeModel employee=new EmployeeModel(firstName,lastName,skills,age,salary,dateOfJoining);
			employeeService.insertEmployee(employee);
			response.sendRedirect("emplist");
			
		}
	    private void  deleteEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException, IOException
	    {
	    	EmployeeService employeeService = null;
	    	try
	    	{
	    		int id=Integer.parseInt( request.getParameter("id"));
	    		employeeService.deleteEmployee(id);

	    		response.sendRedirect("emplist");
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
	    private void showEditForm(HttpServletRequest request,HttpServletResponse response)
	    {
	    	EmployeeService employeeService = null;
	    	System.out.println("id"+request.getParameter("id"));
	    	
	    	int id=Integer.parseInt(request.getParameter("id"));
	    	
			EmployeeModel existingEmployee;
	    	
	    	try
	    	{
	    		existingEmployee=employeeService.selectEmployee(id);
	    		RequestDispatcher dispatcher=request.getRequestDispatcher("//WEB-INF//Views//EmployeeRegistration.jsp");//Insert Form name
	    		request.setAttribute("Emp",existingEmployee);		
	    		dispatcher.forward(request,response);   	
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	    }
		private void updateEmployee(HttpServletRequest request,HttpServletResponse response) throws SQLException,IOException
		{
			EmployeeService employeeService = null;
			System.out.println("Update");
			System.out.println("UPDATE1"+request.getParameter("empSrNo"));
			int id=Integer.parseInt(request.getParameter("empSrNo"));
			String firstname=request.getParameter("empfname");
			String lastname=request.getParameter("emplname");
			String employee_skills_array[]=request.getParameterValues("empSkills");
			String checked_employee_skills=employee_skills_array[0];
			for(int i=1;i<employee_skills_array.length;i++)
			{
				
				checked_employee_skills+=","+employee_skills_array[i];
			}
			
			String skills=checked_employee_skills;
			String age=request.getParameter("empage");
			String salary=request.getParameter("empsalary");
			String dateOfJoining=request.getParameter("empdoj");
			EmployeeModel employee=new EmployeeModel(id,firstname,lastname,skills,age,salary,dateOfJoining);
			
			System.out.println("UPDATE2");
			employeeService.updateEmployee(employee);
			response.sendRedirect("emplist");
		}
		private void listEmployee(HttpServletRequest request,HttpServletResponse response)
		{
			EmployeeService employeeService = null;
			try
			{
				List<EmployeeModel> employeeList=employeeService.selectAllEmployee();   
				request.setAttribute("emplist", employeeList);
				RequestDispatcher dispatcher=request.getRequestDispatcher("//WEB-INF//Views//index.jsp");
			    dispatcher.forward(request, response);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
        
	}


}

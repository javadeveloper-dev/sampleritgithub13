<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%-- <%@ page import="com.Model.EmployeeModel,com.Controller.EmployeeController,java.util.*" %> --%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.Form
{
    margin-left:400px;
}
#submit
{
    margin-left:150px;
}
#reset
{
    margin-left:30px;
}
</style>
</head>
<body>

    <c:if test="${Emp==null}">
    	<form action="<%=request.getContextPath() %>/insert" method="post" >
         
    </c:if>
   
    <c:if test="${Emp!=null }">
    	<form action="<%=request.getContextPath() %>/update" method="post">
    </c:if>
    
    
      <div class="Form">
        <c:if test="${Emp!= null}">
        	<input type="hidden" name="empSrNo" value="${Emp.getId()}">
        </c:if>
       
        Enter the Employee Name : <input type="text" name="empfname"  placeholder="Enter the First Name" value="${Emp.getFirstname()}"  required/>
        <input type="text" name="emplname"  placeholder="Enter the Last Name" value="${Emp.getLastname()}"required/><br /><br />
        Enter the Employee Skills :
   
        
        <input type="checkbox" name="empSkills" value="C"  ${Emp.getSkills().contains("C,") or Emp.getSkills().length()==1 ?"checked":""}>C  
        <input type="checkbox" name="empSkills" value="C++" ${Emp.getSkills().contains("C++")  ?"checked":""}>C++
        <input type="checkbox" name="empSkills" value="JAVA" ${Emp.getSkills().contains("JAVA")?"checked":""}>JAVA
        <input type="checkbox" name="empSkills" value="PYTHON" ${Emp.getSkills().contains("PYTHON")?"checked":""}>PYTHON
        <input type="checkbox" name="empSkills" value="AWS" ${Emp.getSkills().contains("AWS")?"checked":""}>AWS
        
          <br /><br />
        Enter the Employee Age :
        <input type="number" name="empage"  value="${Emp.getAge()}"pattern="[A-Za-z]" min="20" max="60"required/><br /><br />
        Enter the Employee Salary :
        <input type="number" name="empsalary" value="${Emp.getSalary()}" min="20000" max="90000"required/><br /><br />
        Enter the Employee's Date of Joining :
        <input type="date" name="empdoj" value="${Emp.getDoj()}"required/><br /><br />
        <input type="submit" name="submit" value="Submit" id="submit"required/>
        <input type="reset" name="reset" value="Reset" id="reset" required/>
       &nbsp;&nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/" ><button type="button">List</button></a>
      
      </div>
      
      </form>
      
    
</body>
</html>
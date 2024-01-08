<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>Add New Employee</h1>  
<form action="SaveServlet" method="post"> 
<table>  
<tr><td>Id:</td><td><input type="text" name="Id"/></td></tr>
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>  
<tr><td>Designation:</td><td><input  name="designation"/></td></tr>  
<tr><td>Salary</td><td><input type="number" name="salary"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Employee"/></td></tr>  
</table>  
</form>  
<br/>  
<a href="ViewServlet">view employees</a>  
</center> 
</body>
</html>
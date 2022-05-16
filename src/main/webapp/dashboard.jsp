<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>   
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




<body>



<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Student Entry</h3>
  </div>
  <div class="panel-body">


	
	<s:form action="processUser" method="post" modelAttribute="formDto">
		
		<s:hidden path="id" id="id"/>
	
	
	  <div class="form-group">
	    <label for="name">Name</label>
	    
	    <s:input path="name" id="name" cssClass="form-control" placeholder="Name"/>
	    
	    
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone No</label>
	     <s:input path="phoneNo" id="phoneNo" cssClass="form-control" placeholder="Phone No"/>
	  </div>
	   <div class="form-group">
	    <label for="dob">DOB</label>
	     <s:input path="dob" id="dob" cssClass="form-control" placeholder="DOB"/>
	    
	  </div>
	  <div class="form-group">
	    <label for="username">Username</label>
	    <s:input path="username" id="username" cssClass="form-control" placeholder="Username"/>
	   
	  </div>
	   <div class="form-group">
	    <label for="password">Password</label>
	    <s:input path="password" id="password" cssClass="form-control" placeholder="Password"/>
	   
	  </div>

	  <button type="submit" class="btn btn-default">Submit</button>
	</s:form>




	
  </div>
  
</div>





<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Student List</h3>
  </div>
  <div class="panel-body">
  
  	<table class="table">
  		<thead>
  			<tr>
  				<th>ID</th>
  				<th>Name</th>
  				<th>Phone No</th>
  				<th>DOB</th>
  				<th>Edit</th>
  				<th>Delete</th>
  			</tr>
  		</thead>
  		
  		<tbody>
  			
  			
  			<c:forEach items="${userList}" var="row">
  				
  				<tr>
  					<td> ${row.id}  </td>
  					<td> ${row.name} </td>
  					<td> ${row.phoneNo} </td>
  					<td> ${row.dob}  </td> 
  					<td> <a href="editUser?id=${row.id}">Edit</a>  </td>
  					<td> <a href="delete.do?id=${row.id}">Delete</a> </td>
  				</tr>
  			
  			</c:forEach>
  		
  		
  		
  			
  		</tbody>
  		
  		
  	</table>
  
  
  
    
  </div>
</div>





</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

<hr>
<h2>Employee Overview:</h2>
<table>

	<tr>
		<td>
			<c:out value="${employee.firstName}" /> 
			<c:out value="${employee.middleInitial}" />. 
			<c:out value="${employee.lastName}" />
			(<c:out value="${employee.enterpriseID}" />)
		</td>
	</tr>
	<tr>
		<td>
			<c:out value="${employee.level}" />, <c:out value="${employee.workForce}" />
		</td>
	</tr>
</table>
<hr>

<h2>Project History:</h2>
<c:forEach var="projectdetail" items="${projectList}">
	<c:set var="project" value="${projectdetail.project}"/>
	<b>${project.name}</b><br>
	${project.description}
	<table border=1 width="90%">
		<tr >
			<th>Role</th>
			<th>Start Date</th>
			<th>End Date</th>
		</tr>
		
		
		<c:forEach var="projectrole" items="${projectdetail.projectRoles}">
		
			<tr>
			<td width=50%><c:out value="${projectrole.role}" /> </td>
			<td width=25%><c:out value="${projectrole.startDate}" /> </td>
			<td width=25%><c:out value="${projectrole.endDate}" /> </td>
			</tr>
		</c:forEach>
	
	</table>
	<br>
</c:forEach>
<hr>

<h2>Skill Set:</h2>

<table border=1 width="90%">
	<tr >
		<th>Skill</th>
		<th>Description</th>
		<th>Rating</th>
	</tr>
	
	<c:forEach var="skill" items="${skillList}">
		<tr>
		<td><c:out value="${skill.name}" /> </td>
		<td><c:out value="${skill.description}" /> </td>
		<td><c:out value="${skill.rating}" /> </td>
		</tr>
	</c:forEach>

</table>
	<br>

<hr>


<a href="#" onClick="history.go(-1)">Back to results</a> 
<BR>

</body>
</html>
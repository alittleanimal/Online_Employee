<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for Employee</title>

<script language="JavaScript" type="text/javascript">
	
</script>

</head>
<body>
	<hr>
	<span class="text-primary"> Enter the first name and last name
		of the employee you wish to find and the application will return a
		list of employees with names that contain the search parameters you
		entered<br>
	</span>
	<hr>

	<form name="searchForm" action="/empdb/find/findEmployees.htm"
		method="POST">
		<table>
			<tr>
				<td>First Name</td>
				<td colspan=2><input class="form-control" name="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input class="form-control" name="lastName" /></td>
				<td><input type="submit" class="btn btn-primary"
					name="searchType" value="Find By Name"
					onClick="this.value='findByName'"></td>
			</tr>
			<tr>
				<td colspan=2>OR</td>
			</tr>

			<tr>
				<td>Project Name</td>
				<td><select name="projectID">
						<c:forEach var="project" items="${projectList}">
							<option value="${project.ID}">${project.name}</option>
						</c:forEach>
				</select>
				</td>
				<td><input class="btn btn-primary" type="submit"
					name="searchType" value="Find by Project"
					onClick="this.value='findByProject'"></td>
			</tr>

		</table>
	</form>
	<hr>

	<%@ include file="employeeSearchResults.jsp"%>

</body>
</html>
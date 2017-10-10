<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script language="JavaScript" type="text/javascript">
function submitEmployeeID(form, id)
{
  form.employeeID.value=id;
  form.submit();
}

</script> 

<title>Search Results</title>
</head>

<body>
Displaying ${fn:length(employeeList)} Result(s) 
For search criteria: 
<hr>

<form name="resultsForm" action="/empdb/find/viewEmployeeDetails.htm" method="POST">
<input type='hidden' name="employeeID">
<input type='hidden' name="searchString" value="${searchString}">
<table border=1 width="80%">
	<tr>
			<th width="25%">
				Employee Name
			</th>
			<th width="25%">
				Enterprise ID
			</th>
			<th width="25%">
				Level
			</th>
			<th width="25%">
				Workforce
			</th>
		</tr>
<c:forEach
	var="employee" items="${employeeList}">
	
	
		<tr>

			<td>
				<a href="javascript: submitEmployeeID(this.resultsForm, ${employee.ID})"> 
					<c:out value="${employee.firstName}" /> 
					<c:out value="${employee.middleInitial}" /> .
					<c:out value="${employee.lastName}" /> 
				</a>
			</td>
			<td>	
				<c:out value="${employee.enterpriseID}" /> 	
			</td>
			<td>	
				<c:out value="${employee.level}" /> 	
			</td>
			<td>	
				<c:out value="${employee.workForce}" /> 	
			</td>

		</tr>

	
</c:forEach>
</table>
<hr>
</form>


<BR>
End

</body>
</html>

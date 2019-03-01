<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


${message}
<br>
<a href="hello.html">Click Here to Generate Action </a>
<br>

<form action="add_emp.html">

<input type="hidden" name="id"   value="${emp.getId()}"/>
<input type="text" name="name" placeholder="enter name" value="${emp.getName()}"/>
<input type="password" name="pass" placeholder="enter password" value="${emp.getPass()}"/>
<input type="submit" value="AddEmployee"/>

</form>




<br>
<br>

<c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Employee Pass</th>
				<th>Action</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"/></td>
				<td><c:out value="${employee.name}"/></td>
				<td><c:out value="${employee.pass }	"/></td> 
				<td><a href="pre.html?id=${employee.id}">UPDATE</a> || 
					<a href="delete.html?id=${employee.id}">DELETE</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</c:if>



</body>
</html>
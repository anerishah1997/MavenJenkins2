<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.lti.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3><a href='AddUser.jsp'>Add User</a> | <a href='Home.jsp'>Home</a></h3>
	<table>
		<tr>
			<th>UserName</th>
			<th>Password</th>
			
		</tr>
		<c:forEach var="user" items="${ requestScope.UsersList }">
			
			<tr>
				<td> <c:out value="${ user.username }"></c:out> </td>
				<td> <c:out value="${ user.password }"></c:out> </td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>
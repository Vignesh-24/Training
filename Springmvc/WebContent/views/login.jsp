<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="submitform" modelAttribute="lfb" method="post">
		Username: <form:input type="text" path="username"/>
		Password: <form:input type="text" path="password"/>
		<input type="submit" value="submitform"/>
	</form:form>


</body>
</html>
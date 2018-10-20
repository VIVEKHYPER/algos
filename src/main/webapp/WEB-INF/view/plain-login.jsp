<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.failed{
	color:red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom Login Page</title>
</head>
<body>
	<h3>Login Page(Custom)</h3>
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">
		<c:if test="${param.error != null}">
			<i class="failed">Sorry! You have entered wrong user name/password</i>
		</c:if>
		<c:if test="${param.logout != null}">
			<i class="failed">You have been logged out.</i>
		</c:if>
		<p>
			User name : <input type="text" name="username" />
		</p>
		<p>
			Password : <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>
</body>
</html>
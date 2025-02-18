<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
			<h1>Iniciar Sesión</h1>
			<div>
				<a href="/login">Login</a>
				<a href="/">Registro</a>
			</div>
			
	</header>
	<main id="main">
		<form:form action="/iniciarSesion" method="POST" modelAttribute="loginUsuario">
			<div>
				<form:label path="emailLogin">E-mail:</form:label>
				<form:input path="emailLogin" class="form-control" />
				<form:errors path="emailLogin" class="text-danger" />
			</div>
			<div>
				<form:label path="passwordLogin">Password:</form:label>
				<form:password path="passwordLogin" class="form-control" />
				<form:errors path="passwordLogin" class="text-danger" />
			</div>
			<input type="submit" class="button" value="Iniciar Sesión" >
		</form:form>
	</main>

</body>
</html>
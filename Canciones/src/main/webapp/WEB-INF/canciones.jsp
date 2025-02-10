<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h1>Lista de Canciones</h1>
	
	<table>
		<thead>
			<tr>
				<td>Titulo</td>
				<td>Autor</td>
				<td>Detalle</td>
			</tr>
		</thead>
		
	
		
	
		
	
	<c:forEach items="${listaCanciones}" var="cancion">
		<tr>
			<td>${cancion.titulo}</td>
			<td>${cancion.artista}</td>
			<td><a href="/canciones/detalle/${cancion.id}">Detalle</a></td>
		
		</tr>
	
	
	</c:forEach>
	</table>

</body>
</html>
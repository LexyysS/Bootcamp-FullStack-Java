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
	<h1>Lista de libros</h1>
	<ul>
		<c:forEach items="${listaLibros}" var="libro">
			<li>
				<a href="/libros/${libro.key }"> ${libro.key} - ${libro.value} </a>
				
			</li>
		
		
		
		</c:forEach>
	
	
	</ul>
	
	<a href="/libros/formulario" class="btnAgregar">Agregar libro</a>

</body>
</html>
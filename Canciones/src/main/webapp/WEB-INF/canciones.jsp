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
			<td style="display:flex; justify-content:center; align-items:center ; gap:20px">
				<a href="/canciones/detalle/${cancion.id}">Detalle</a>
			 	<a style="background-color:green" href="/canciones/formulario/editar/${cancion.id}">Editar</a>
			 	<form style="width:100px; height:50px ; padding:0 ; background-color:red" action="/canciones/eliminar/${cancion.id}" method="post">
					<input type="hidden" name="_method" value="DELETE"/>
					<button style="background-color:red; color:white ; border:none" >Eliminar cancion</button>
				</form>
			 </td>
		
		</tr>
	
	
	</c:forEach>
	
	<a href="/canciones/formulario/agregar">Agregar Cancion</a>
	</table>

</body>
</html>
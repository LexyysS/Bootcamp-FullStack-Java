<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar Serie</title>
<link href="/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
			
		<h1>TV Series</h1>	
		<div>
			<a href="/compras">Mis compras</a>
			
			<a href="/dashboard">Series</a>
			
			<a href="/agregarSerie">Agregar series</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		
		</div>
	</header>
	<div id="main">
		
		<form:form action="/guardarSerie" method="POST" modelAttribute="serie" >
			<h2>Agregar Serie</h2>
			<div>
				<form:label path="titulo">Titulo:</form:label>
				<form:input path="titulo" class="form-control" />
				<form:errors path="titulo" class="text-danger" />
			</div>
			<div>
				<form:label path="year">Año:</form:label>
				<form:input path="year" class="form-control" />
				<form:errors path="year" class="text-danger" />
			</div>
			<div>
				<form:label path="descripcion">Descripcion:</form:label>
				<form:input path="descripcion" class="form-control" />
				<form:errors path="descripcion" class="text-danger" />
			</div>
			<div>
				<form:label path="url">URL a imagen:</form:label>
				<form:input path="url" class="form-control" />
				<form:errors path="url" class="text-danger" />
			</div>
			<div>
				<form:label path="cantidad">Cantidad:</form:label>
				<form:input path="cantidad" class="form-control" />
				<form:errors path="cantidad" class="text-danger" />
			</div>
			<div>
				<form:label path="precio">Precio:</form:label>
				<form:input path="precio" class="form-control" />
				<form:errors path="precio" class="text-danger" />
			</div>
			<form:hidden value="${usuarioSesion.id}" path="creador" />
			<input type="submit" class="button" value="Guardar" >
		</form:form>
	</div>

</body>
</html>
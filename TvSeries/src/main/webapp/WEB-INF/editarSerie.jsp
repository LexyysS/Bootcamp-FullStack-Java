<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Serie</title>
<link href="/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<h1>TV Series</h1>
		<div>
			<a href="/compras">Mis compras</a>
			
			<a href="/dashboard">Series</a>
			
			<a href="/agregarSerie">Agregar series</a>
			
			<a href="/logout">Cerrar Sesión</a>
		
		</div>
	</header>
	<div id="main">
		
		<form:form action="/actualizar/${serie.id}" method="PUT" modelAttribute="serie" >
			<h2>Actualizar Serie</h2>
			<div>
				<form:label path="titulo">Titulo:</form:label>
				<form:input path="titulo" class="form-control" value="${serie.titulo }" />
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
		
		<c:if test="${usuarioSesion.id == serie.creador.id}">
			<form style="background-color:white; width:400px; height:50px;" action="/eliminarSerie/${serie.id}" method="post">
				<input type="hidden" name="_method" value="DELETE"/>
				<button id="btnEliminar">Eliminar</button>
			</form>
		</c:if>
		
		
		
	</div>

</body>
</html>
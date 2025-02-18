<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<h1>TV Series</h1>
		<div>
			<a href="/compras">Mis compras</a>
			
			<a href="/dashboard">Series</a>
			
			<a href="/agregarSerie">Agregar series</a>
			
			<a href="/logout" >Cerrar Sesión</a>
		
		</div>
	
	</header>
	
	<main>
		<h1>Bienvenid@ de vuelta ${usuario.nombre}</h1>
		<c:forEach items="${series}" var="serie">
			<div class="content-serie" style="display:flex; gap:20px;" >
				<img style="width:150px; height:250px;" src="${serie.url}"/>
				<div class="div-serie">
					<h2>${serie.titulo}</h2>
					
					<p><span>Año</span> ${serie.year}</p>
					<p><span>Precio</span>${serie.precio}</p>
					
					<div>
						<a class="a-main" href="/mostrar/${serie.id}">Ver</a>
						<a class="a-main" href="/editar/${serie.id}">Editar</a>
					</div>
					
				
				</div>
			
			
			
			</div>
		
		
		</c:forEach>
	
	
	</main>

</body>
</html>
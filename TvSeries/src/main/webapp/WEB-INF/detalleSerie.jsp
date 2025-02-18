<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detalle serie</title>
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
		<h1>${serie.titulo}</h1>
		<div id="div-detalle">
			<img style="width:180px; height:280px;" src="${serie.url}"/>
			<div>
				<p style="color:gray">Usuario que publico esta serie</p>
				<p>${serie.creador.nombre}</p>
				<p style="color:gray">Descripcion</p>
				<p>${serie.descripcion}</p>
				<p style="color:gray">Precio</p>
				<p>$${serie.precio }</p>
				<p style="color:gray">Cantidad en inventario</p>
				<p>${serie.cantidad }</p>
				
				<c:if test="${serie.cantidad > 0}">
					<a style="background-color:green; border-radius:10px; padding:10px; text-align: center ; color:white;" href="/comprar/${usuarioSesion.id}/${serie.id}">Comprar</a>
				</c:if>
				
				<c:if test="${serie.cantidad <= 0}">
					<p>Agotado!</p>
				</c:if>
				
				
				
			</div>
			
			
			
			
		
		</div>
		
		
		<c:if test="${not empty serie.usuariosComprados}">
			
			<div style="background-color:gray; padding:20px; border-radius:10px; margin-top:10px;">
				<p>Personas que han comprado la pelicula</p>
				<ul style="padding:15px">
        			<c:forEach var="usuario" items="${serie.usuariosComprados}">
            			<li>${usuario.nombre}</li>
        			</c:forEach>
    			</ul>
			</div>
    		
		</c:if>
		
		<c:if test="${empty serie.usuariosComprados}">
    		<p>Ningun usuario ha comprado la serie</p>
		</c:if>

		
	
	
	
	
	</main>
	
	
	
	
</body>
</html>
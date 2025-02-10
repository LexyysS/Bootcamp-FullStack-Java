<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	
	<h1>Detalle de Cancion</h1>
	
	<p>Titulo: ${cancion.titulo }</p>
	<p>Artista: ${cancion.artista }</p>
	<p>Album: ${cancion.album }</p>
	<p>Genero: ${cancion.genero }</p>
	<p>Idioma: ${cancion.idioma }</p>
	
	
	<a href="/canciones">Volver a Canciones</a>
</body>
</html>
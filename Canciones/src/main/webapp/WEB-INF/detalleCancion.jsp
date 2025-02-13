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
	
	<a style="background-color:green" href="/canciones/formulario/editar/${cancion.id}">Editar cancion</a>
	<form style="width:100px; height:50px ; padding:0 ; background-color:red" action="/canciones/eliminar/${cancion.id}" method="post">
					<input type="hidden" name="_method" value="DELETE"/>
					<button style="background-color:red; color:white; border:none" >Eliminar cancion</button>
				</form>
	<a href="/canciones">Volver a Canciones</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
	
    <form:form action="/canciones/procesa/agregar" method="post" modelAttribute="cancion">
       	<h2>Formulario de cancion</h2>
           
        <form:label path="titulo">Titulo:</form:label>
        <form:input path="titulo" name="titulo"  />
    	<form:errors path="titulo"/>
        
        <form:label path="artista">Artista:</form:label>
        <form:input path="artista" name="artista"  />
    	<form:errors path="artista"/>
    	
    	<form:label path="album">Album:</form:label>
        <form:input path="album" name="album"  />
    	<form:errors path="album"/>
    	
    	<form:label path="genero">Genero:</form:label>
        <form:input path="genero" name="genero"  />
    	<form:errors path="genero"/>
    	
    	<form:label path="idioma">Idioma:</form:label>
        <form:input path="idioma" name="idioma"  />
    	<form:errors path="idioma"/>
    	
 
        
        <input type="submit" value="Guardar Cancion" />
         
    </form:form>
	
	
	<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>
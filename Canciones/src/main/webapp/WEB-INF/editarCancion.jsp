<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/styles.css" rel="stylesheet" type="text/css">
</head>
<body>

  <form:form action="/canciones/procesa/editar/${cancion.id}" method="post" modelAttribute="cancion">
       	<h2>Formulario de cancion</h2>
        
        <input type="hidden" name="_method" value="PUT"/>  
        <form:label path="titulo" for="titulo" value="${cancion.titulo}">Titulo:</form:label>
        <form:input path="titulo" name="titulo"  />
    	<form:errors path="titulo"/>
        
        <form:label path="artista" for="artista" value="${cancion.artista}" >Artista:</form:label>
        <form:input path="artista" name="artista"  />
    	<form:errors path="artista"/>
    	
    	<form:label path="album" for="album" value="${cancion.album}" >Album:</form:label>
        <form:input path="album" name="album"   />
    	<form:errors path="album"/>
    	
    	<form:label path="genero" for="genero" value="${cancion.genero}">Genero:</form:label>
        <form:input path="genero" name="genero"  />
    	<form:errors path="genero"/>
    	
    	<form:label path="idioma" for="idioma" value="${cancion.idioma}">Idioma:</form:label>
        <form:input path="idioma" name="idioma"  />
    	<form:errors path="idioma"/>
    	
 
        
        <input type="submit" value="Actualizar Cancion" />
         
    </form:form>
	
	
	<a href="/canciones">Volver a lista de canciones</a>

</body>
</html>
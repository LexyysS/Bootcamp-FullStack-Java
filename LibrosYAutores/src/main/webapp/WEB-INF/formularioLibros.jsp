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
	<div class="container">
		<h1>Formulario</h1>
		<form action="/procesa/libro" method="POST">
			<input class="lblAutor" name="nombreAutor" placeholder="Ingresa autor." >
			<input class="lblLibro" name="nombreLibro" placeholder="Ingresa Libro.">
			<input type="submit" class="submit" value="Ingresar">
		</form>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<c:if test="${not empty error}">
		<h1>${error}</h1>
	
	</c:if>
	
	<h1>${nombreReceta}</h1>
	
	<ul>
		
		<c:forEach items="${resultado}" var="receta">
			<li>${receta}</li>
		</c:forEach>
	
	</ul>
	
	
	
</body>
</html>
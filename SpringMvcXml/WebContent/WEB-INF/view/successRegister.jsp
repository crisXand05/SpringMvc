<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmacion de registroe</title>
</head>
<body>
	<h1>Se ha registrado el alumno ${student.name } ${student.lastName } con exito</h1>
	<h2>Materias</h2>
	<br>
	<p>${student.subject }</p>
	<c:if test="${student.sex == 'f' }">Female</c:if>
	<c:if test="${student.sex == 'm' }">Male</c:if>
	<h2>Idiomas escogidos</h2>
	${ student.language }
	<br>
	<strong>Tarjeta de credito</strong> ${student.creditCard }
</body>
</html>
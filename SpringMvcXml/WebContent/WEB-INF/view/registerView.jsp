<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de registro</title>
</head>
<body>
	<form:form action = "registerstudent" modelAttribute = "student">
		<label>Nombre</label> <form:input path="name"/>
		<br>
		<label>Apellido</label> <form:input path="lastName"/>
		<br>
		<label>Materia</label>
		<form:select path="subject">
			<form:option value="Disenio" label="Disenio"></form:option>
			<form:option value="Informatica" label="Informatica"></form:option>
			<form:option value="Math" label="Math"></form:option>
		</form:select>
		<br>
		
		<label>Sex</label>
		<td> 
			<label>Male</label> <form:radiobutton path = "sex" value = "m" />
			<label>Female</label> <form:radiobutton path="sex" value = "f"/>
		 </td>
		 <br>
		 <label>Languages</label>
		 <br>
		 <label>English</label> <form:checkbox path = "language" value = "English" />
		 <label>French</label> <form:checkbox path = "language" value = "French" />
		 <label>Portuguese</label> <form:checkbox path = "language" value = "Portuguese" />
		<input type = "submit" value = "Enviar">
	</form:form>
</body>
</html>
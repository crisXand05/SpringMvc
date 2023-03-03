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
		<form:errors path="name" style="color:red"/>
		<br>
		<label>Apellido</label> <form:input path="lastName"/>
		<label>Edad</label> <form:input path="age"/>
		<form:errors path="age"></form:errors>
		<label>Tarjeta de credito</label> <form:input path="creditCard"/>
		<form:errors path = "creditCard" style="color:red"/>
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
		<label>Numero par</label><form:input path="evenNumber"/>
		<form:errors path="evenNumber"/>
		<br>
		<input type = "submit" value = "Enviar">
	</form:form>
</body>
</html>
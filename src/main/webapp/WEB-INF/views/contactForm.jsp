<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
		body {
			font-family: sans-serif;
		}
		.data, .data td {
			border-collapse: collapse;
			width: 100%;
			border: 1px solid #aaa;
			margin: 2px;
			padding: 2px;
		}
		.data th {
			font-weight: bold;
			background-color: #5C82FF;
			color: white;
		}
	</style>
</head>
<body>
<h2>Contact Manager</h2>
<c:url var="addAction" value="/contact/add" ></c:url>

<form:form action="${addAction}" commandName="contact" modelAttribute="contact">


<h3>${message}</h3>

 <c:if test="${!empty contact.nombre}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" /><br>
            <form:hidden path="id" />
        </td> 
    </tr>
    </c:if>
 
 NOMBRE: <form:input path="nombre"/><br>
 <form:errors path="nombre"/>
     
 SEXO: <form:radiobutton path="sexo" value="M"/>M 
       <form:radiobutton path="sexo" value="F"/>F<br>
                  
 IDIOMA:
            INGLES<form:checkbox path="idioma" value="INGLES"/>
            ESPAÑOL<form:checkbox path="idioma" value="ESPAÑOL"/>
            ALEMAN<form:checkbox path="idioma" value="ALEMAN"/><br>

COMENTARIO<form:textarea path="comentario"/><br>     

 <c:if test="${!empty contact.nombre}">
                <input type="submit"
                    value="<spring:message text="Edit Contact"/>" />
            </c:if>

<c:if test="${empty contact.nombre}">
                <input type="submit"
                    value="<spring:message text="Add Contact"/>" />
            </c:if>
</form:form>
     

    <h3>Contacts</h3>
<table class="data" border="1">
<tr>
    <th>ID</th>
    <th>NOMBRE</th>
    <th>SEXO</th>
    <th>IDIOMA</th>
    <th>COMENTARIO</th>
    <th>REMOVE</th>
    <th>EDIT</th>
</tr>
<c:forEach items="${contactList}" var="contact">
    <tr>
        <td>${contact.id}</td>
        <td>${contact.nombre}</td>
        <td>${contact.sexo}</td>
        <td>${contact.idioma}</td>
        <td>${contact.comentario}</td>
	<td><a href="<c:url value='/delete/${contact.id}'/>">Delete</a></td>
	<td><a href="<c:url value='/edit/${contact.id}'/>">Edit</a></td>
    </tr>
</c:forEach>
</table>     
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Cliente</title>
</head>
<body>
	<div align="center">
		<h1>Alterar Cliente</h1>
		<form action="update" method="post">
			<table style="with: 80%">
				<tr>
					<td>Primeiro Nome <input type="hidden" name="id" value="<c:out value='${cliente.id}' />" /></td>
					<td><input type="text" name="firstName" value="${cliente.firstName}"/></td>
				</tr>
				<tr>
					<td>Sobrenome</td>
					<td><input type="text" name="lastName" value="${cliente.lastName}"/></td>
				</tr>
				<tr>
					<td>Endereço</td>
					<td><input type="text" name="address" value="${cliente.address}"/></td>
				</tr>
				<tr>
					<td>Telefone</td>
					<td><input type="text" name="contact" value="${cliente.contact}"/></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Salvar" />
		</form>
	</div>
</body>
</html>
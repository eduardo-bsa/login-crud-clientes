<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
	<div align="center">
		<h1>Registre um Cliente</h1>
		<form action="<%= request.getContextPath() %>/register" method="post">
			<table style="with: 80%">
				<tr>
					<td>Primeiro Nome</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Sobrenome</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Endereço</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Telefone</td>
					<td><input type="text" name="contact" /></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="Salvar" />
		</form>
	</div>
	<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2><a href="list">Listar Clientes</a></h2></caption>
            <tr>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>Endereço</th>
                <th>Telefone</th>
            </tr>
            <c:forEach var="cliente" items="${listCliente}">
                <tr>
                    <td><c:out value="${cliente.firstName}" /></td>
                    <td><c:out value="${cliente.lastName}" /></td>
                    <td><c:out value="${cliente.address}" /></td>
                    <td><c:out value="${cliente.contact}" /></td>
                    <td>
                    	<a href="edit?id=<c:out value='${cliente.id}' />">Alterar</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete?id=<c:out value='${cliente.id}' />">Excluir</a>                    	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
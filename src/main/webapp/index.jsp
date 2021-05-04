<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Clientes</title>
</head>
<body>
 <div align="center">
  <h1>Registro de Clientes</h1>
  <form action="<%=request.getContextPath()%>/login" method="post">
   <table style="with: 100%">
    <tr>
     <td>Usuário</td>
     <td><input type="text" name="username" /></td>
    </tr>
    <tr>
     <td>Senha</td>
     <td><input type="password" name="password" /></td>
    </tr>

   </table>
   <br>
   <input type="submit" value="Entrar" />
  </form>
 </div>
</body>
</html>
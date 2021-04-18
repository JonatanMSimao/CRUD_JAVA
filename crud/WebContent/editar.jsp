<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Usuários</title>
<link rel="icon" href="imagens/icontitleadd.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Usuário</h1>
	<form name="forUser" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="box3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="box1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" class="box1"
					value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="fone" class="box2"
					value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
		</table>
		<input type="button" class="btn1" value="Salvar" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Cadastro de Usuários</title>
<link rel="icon" href="imagens/icontitleadd.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Cadastrar Usuários</h1>
	<a href="novo_cadastro.html" class="btn1">Novo Cadastro</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Fone</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>" class="btn1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId()%>)"
					class="btn2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("container");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Teste T2S</title>
<link rel="icon" href="imagens/favicon.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="externa">
		<div class="header">
			<h1>Painel de Controle</h1>
		</div>
		<div class="navBar">
			<a href="novoContainer.html" class="botao1">Novo Container</a><a
				href="report" class="botao2">Relatório</a>
		</div>
		<div class="interna">
			<table id="tabela">
				<thead>
					<tr>
						<th>Cliente</th>
						<th>Nº Container</th>
						<th>Tipo</th>
						<th>Status</th>
						<th>Categoria</th>
						<th>Movimentação</th>
						<th>Entrada</th>
						<th>Saída</th>
						<th>Opções</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < lista.size(); i++) {
					%>
					<tr>
						<td><%=lista.get(i).getNomeCliente()%></td>
						<td><%=lista.get(i).getNumContainer()%></td>
						<td><%=lista.get(i).getTipo()%></td>
						<td><%=lista.get(i).getStatusAtual()%></td>
						<td><%=lista.get(i).getCategoria()%></td>
						<td><%=lista.get(i).getTipoMovimentacao()%></td>
						<td><%=lista.get(i).getDataInicio()%></td>
						<td><%=lista.get(i).getDataFim()%></td>
						<td><a href="select?id=<%=lista.get(i).getId()%>"
							class="botao1">Editar</a><a
							href="javascript: confirmar(<%=lista.get(i).getId()%> )"
							class="botao2">Excluir</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<div id="rodape">&copy;Todos os direitos reservados</div>
</body>
</html>
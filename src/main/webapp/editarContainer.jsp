<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar container</title>
<link rel="icon" href="imagens/favicon.jpg">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="externa" id="fixed">
		<div class="header">
			<h1>Editar container</h1>
		</div>
		<div class="interna">
			<form name="newContainer" action="updateC" method="get">
				<input type="text" name="id" style="display: none;"
				 required value="<%out.print(request.getAttribute("id"));%>">
				<h4>Cliente:</h4>
				<input type="text" class="caixa1" name="nomeCliente"
				 required value="<%out.print(request.getAttribute("nomeCliente"));%>"> <br>
				<h4>Número do container:</h4>
				<input type="text" class="caixa1" pattern="[a-zA-Z]{4}[0-9]{7}"
					name="numContainer" required value="<%out.print(request.getAttribute("numContainer"));%>"> <br>

				<h4>Tipo de container:</h4>
				<select name="tipo" class="caixa1" required value="<%out.print(request.getAttribute("tipo")); %>">
					<option value="20">20</option>
					<option value="40">40</option>
				</select> <br>

				<h4>Status:</h4>
				<select name="status" class="caixa1" required value="<%out.print(request.getAttribute("status")); %>">
					<option value="Cheio">Cheio</option>
					<option value="Vazio">Vazio</option>
				</select>

				<h4>Categoria:</h4>
				<select name="categoria" class="caixa1" required value="<%out.print(request.getAttribute("categoria")); %>">
					<option value="Importacao">Importação</option>
					<option value="Exportacao">Exportacao</option>
				</select><br>
				<br>
				<div class="btn_submit">
					<input type="submit" value="Atualizar" class="botao1">
				</div>
			</form>
			<br> <br>
		</div>
		<div id="rodape">&copy;Todos os direitos reservados</div>
	</div>
</body>
</html>
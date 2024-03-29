<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<title>Área do Atendente</title>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="content" class="atendente">
		<a href="${pageContext.request.contextPath}/jsp/ate-saldo.jsp"><img src="${pageContext.request.contextPath}/png/dinheiro.png" />Consultar Saldo de Cliente</a>
	 	<a href="${pageContext.request.contextPath}/jsp/ate-autorizacoes.jsp"><img src="${pageContext.request.contextPath}/png/autorizacao.png" />Gerenciar Autorizações</a>
  		<a href="${pageContext.request.contextPath}/jsp/ate-procedimentos.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/procedimento.png" />Gerenciar Procedimentos</a>
  		<a href="${pageContext.request.contextPath}/jsp/ate-extrato.jsp"><img src="${pageContext.request.contextPath}/png/extrato.png" />Extrato de Procedimentos</a>
  		<a href="${pageContext.request.contextPath}/jsp/ate-comprovante.jsp"><img src="${pageContext.request.contextPath}/png/comprovante.png" />Emitir Comprovante</a>
  		<a href="${pageContext.request.contextPath}/jsp/ate-informacoes.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/informacao.png" />Alterar Suas Informações</a>
	</div>
    <div id="footer">
		<p>© 2015 | Club Saúde, PUC-Rio. Trabalho de conclusão do curso de Pós-Graduação em Análise e Projeto de Sistemas.</p>
		<p>© 2015 | Hernani Jorge, Lucas Gonçalves, Marcelo Silva, Tales Souza. Trabalho registrado na biblioteca da PUC-Rio.</p>
		<p>Software versão 1.0. Todos os direitos reservados.</p>
	</div>
</div>
</body>
</html>


<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<title>Área do Financeiro</title>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p class="cliente">Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="content" class="financeiro">
  		<a href="${pageContext.request.contextPath}/jsp/fin-pagamentos.jsp"><img src="${pageContext.request.contextPath}/png/dinheiro.png" />Listar Pagamentos</a>
		<a href="${pageContext.request.contextPath}/jsp/fin-previsoes.jsp"><img src="${pageContext.request.contextPath}/png/previsoes.png" />Previsões de Pagamento</a>
		<a href="${pageContext.request.contextPath}/jsp/fin-balanco.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/balanco.png" />Listar Balanço</a>
  		<a href="${pageContext.request.contextPath}/jsp/fin-clinicas.jsp"><img src="${pageContext.request.contextPath}/png/clinica.png" />Pagar Clínicas</a>
  		<a href="${pageContext.request.contextPath}/jsp/fin-boletos.jsp"><img src="${pageContext.request.contextPath}/png/comprovante.png" />Quitar Boletos</a>
  		<a href="${pageContext.request.contextPath}/jsp/fin-informacoes.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/informacao.png" />Alterar Suas Informações</a>
	</div>
    <div id="footer">
		<p>© 2015 | Club Saúde, PUC-Rio. Trabalho de conclusão do curso de Pós-Graduação em Análise e Projeto de Sistemas.</p>
		<p>© 2015 | Hernani Jorge, Lucas Gonçalves, Marcelo Silva, Tales Souza. Trabalho registrado na biblioteca da PUC-Rio.</p>
		<p>Software versão 1.0. Todos os direitos reservados.</p>
	</div>
</div>
</body>
</html>


<%@ page isErrorPage="true" contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mais/efeitos.js"></script>
<title>Erro 403</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
	</div>
	<div id="subheader" class="webmaster">
	 	<div></div>
        <h1>403</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/index.jsp">Voltar</a>        
    </div>
    <div id="content">
        <h2>Acesso Proibido</h2>
		<p>Você não tem permissão para acessar esta página.</p>
        <p>Por favor, utilize o formulário da página inicial para acessar o seu perfil.</p>
        <p>Retorne à página inicial clicando na logo Webmedi, ou à anterior pelo botão Voltar.</p>
	</div>
    <div id="footer">
		<p>© 2015 | Club Saúde, PUC-Rio. Trabalho de conclusão do curso de Pós-Graduação em Análise e Projeto de Sistemas.</p>
		<p>© 2015 | Hernani Jorge, Lucas Gonçalves, Marcelo Silva, Tales Souza. Trabalho registrado na biblioteca da PUC-Rio.</p>
		<p>Software versão 1.0. Todos os direitos reservados.</p>
	</div>
</div>
</body>
</html>
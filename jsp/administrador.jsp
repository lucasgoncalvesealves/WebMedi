<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<title>Área do Administrador</title>
</head>

<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p class="cliente">Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="content" class="administrador">
		<a href="${pageContext.request.contextPath}/jsp/adm-movimentos.jsp"><img src="${pageContext.request.contextPath}/png/dinheiro.png" />Listar Movimentos</a>
  		<a href="${pageContext.request.contextPath}/jsp/adm-clinicas.jsp"><img src="${pageContext.request.contextPath}/png/clinica.png" />Consultar Clínicas</a>       
  		<a href="${pageContext.request.contextPath}/jsp/adm-procedimentos.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/procedimento.png" />Gerenciar Procedimentos</a>
  		<a href="${pageContext.request.contextPath}/jsp/adm-cliente.jsp"><img src="${pageContext.request.contextPath}/png/cliente.png" />Gerenciar Clientes</a>
  		<a href="${pageContext.request.contextPath}/jsp/adm-adesoes.jsp"><img src="${pageContext.request.contextPath}/png/comprovante.png" />Gerenciar Adesões</a>
        <a href="${pageContext.request.contextPath}/jsp/adm-especialidades.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/especialidade.png" />Gerenciar Especialidades</a>
  		<a href="${pageContext.request.contextPath}/jsp/adm-recarregar.jsp"><img src="${pageContext.request.contextPath}/png/recarga.png" />Recarregar Cartão</a>
		<a href="${pageContext.request.contextPath}/jsp/adm-contingencia.jsp"><img src="${pageContext.request.contextPath}/png/contingencia.png" />Cobrar Contingência</a>   
  		<a href="${pageContext.request.contextPath}/jsp/adm-informacoes.jsp" style="margin-right: 0;"><img src="${pageContext.request.contextPath}/png/informacao.png" />Alterar Suas Informações</a>
	</div>
    <div id="footer">
		<p>© 2015 | Club Saúde, PUC-Rio. Trabalho de conclusão do curso de Pós-Graduação em Análise e Projeto de Sistemas.</p>
		<p>© 2015 | Hernani Jorge, Lucas Gonçalves, Marcelo Silva, Tales Souza. Trabalho registrado na biblioteca da PUC-Rio.</p>
		<p>Software versão 1.0. Todos os direitos reservados.</p>
	</div>
</div>
</body>
</html>

<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mais/efeitos.js"></script>
<title>Alterar Suas Informações</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="financeiro">
	 	<div><img src="${pageContext.request.contextPath}/png/informacao.png" /></div>
        <h1>Informações</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/financeiro.jsp">Voltar</a>        
    </div>
    <div id="content">
        <h2>Alterar Suas Informações</h2>
        <form class="informacoes">
        <table>
  	      <tr>
    	    <td>Nome completo</td>
        	<td><input type="text" pattern="[a-z\s]+$" /></td>
          </tr>
    	  <tr>
        	<td style="vertical-align: text-top;">Endereço</td>
     	    <td><textarea></textarea></td>
       	 </tr>
  	      <tr>
    	    <td>Telefone</td>
        	<td><input type="text" pattern="[0-9]+$" /></td>
          </tr>
  	      <tr>
    	    <td>E-mail</td>
        	<td><input type="text" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" /></td>
          </tr>
  	      <tr>
    	    <td>Senha</td>
        	<td><input type="password" pattern="[a-zA-Z0-9]{6,10}" /></td>
          </tr>
  	      <tr>
    	    <td>Confirmar senha</td>
        	<td><input type="password" pattern="[a-zA-Z0-9]{6,10}" /></td>
          </tr>          
         <tr>
      	   <td></td>
           <td style="text-align: right;"><button type="submit">Enviar</button></td>
         </tr>
        </table>
        </form>
	</div>
    <div id="footer">
		<p>© 2015 | Club Saúde, PUC-Rio. Trabalho de conclusão do curso de Pós-Graduação em Análise e Projeto de Sistemas.</p>
		<p>© 2015 | Hernani Jorge, Lucas Gonçalves, Marcelo Silva, Tales Souza. Trabalho registrado na biblioteca da PUC-Rio.</p>
		<p>Software versão 1.0. Todos os direitos reservados.</p>
	</div>
</div>
</body>
</html>
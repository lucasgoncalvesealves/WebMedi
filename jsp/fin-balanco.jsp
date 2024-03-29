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
<title>Listar Balanço</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="financeiro">
	 	<div><img src="${pageContext.request.contextPath}/png/balanco.png" /></div>
        <h1>Balanço</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/financeiro.jsp">Voltar</a>        
        <a id="button-2">Clínica</a>    
        <a id="button-1">Cliente</a>
    </div>
    <div id="content">
        <div id="div-1">
        <h2>Listar Balanço de Cliente</h2>
        <form>
        <table>
    	  <tr>
        	<td>CPF do cliente</td>
     	    <td><input type="text" name="cpf" pattern="[0-9]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Data do início</td>
     	    <td><input type="text" name="inicio" class="data" /></td>
       	 </tr>
    	  <tr>
        	<td>Data de término</td>
     	    <td><input type="text" name="fim" class="data" /></td>
       	 </tr>
         <tr>
      	   <td></td>
           <td><button type="submit">Enviar</button></td>
         </tr>
        </table>
        </form>
        </div>
        <div id="div-2">
        <h2>Listar Balanço de Clínica</h2>
        <form>
        <table>
    	  <tr>
        	<td>CNPJ da clínica</td>
     	    <td><input type="text" name="cnpj" pattern="[0-9]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Data do início</td>
     	    <td><input type="text" name="inicio" class="data" /></td>
       	 </tr>
    	  <tr>
        	<td>Data de término</td>
     	    <td><input type="text" name="fim" class="data" /></td>
       	 </tr>
         <tr>
      	   <td></td>
           <td><button type="submit">Enviar</button></td>
         </tr>
        </table>
        </form>
        </div>
	</div>
    <div id="footer">
		<p>© 2015 | Club Saúde, PUC-Rio. Trabalho de conclusão do curso de Pós-Graduação em Análise e Projeto de Sistemas.</p>
		<p>© 2015 | Hernani Jorge, Lucas Gonçalves, Marcelo Silva, Tales Souza. Trabalho registrado na biblioteca da PUC-Rio.</p>
		<p>Software versão 1.0. Todos os direitos reservados.</p>
	</div>
</div>
</body>
</html>
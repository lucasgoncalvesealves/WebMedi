<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mais/efeitos.js"></script>
<title>Quitar Boletos</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="financeiro">
	 	<div><img src="${pageContext.request.contextPath}/png/comprovante.png" /></div>
        <h1>Quitar Boletos</h1>
        <a class="voltar" href="javascript:history.back();">Voltar</a>        
    </div>
    <div id="content">
        <h2>Quitar Boleto</h2>
        <form>
        <table>
    	  <tr>
        	<td>CPF do cliente</td>
     	    <td><input type="text" name="cpf" pattern="[0-9]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Número do boleto</td>
     	    <td><input type="text" name="boleto" pattern="[0-9]+$" /></td>
       	 </tr>
         <tr>
            <td>Tipo de boleto</td>
            <td>
            <select name="tipo">
               <option></option>
               <option>Recarga</option>
               <option>Adesão</option>
            </select>
            </td>
         </tr>
    	  <tr>
        	<td>Data do boleto</td>
     	    <td><input type="text" name="data" class="data" /></td>
       	 </tr>
    	  <tr>
        	<td>Valor do boleto</td>
     	    <td><input type="text" name="valor" pattern="[0-9]+$" /></td>
       	 </tr>
         <tr>
      	   <td></td>
           <td><button type="submit">Enviar</button></td>
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
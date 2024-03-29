<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/mais/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/mais/efeitos.js"></script>
<title>Emitir Comprovante</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="atendente">
	 	<div><img src="${pageContext.request.contextPath}/png/comprovante.png" /></div>
        <h1>Comprovantes</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/atendente.jsp">Voltar</a>        
    </div>
    <div id="content">
        <h2>Emitir Segunda Via de Comprovante</h2>
        <form>
        <table>
    	  <tr>
        	<td>Número do cartão do cliente</td>
     	    <td><input type="text" name="cartao" pattern="[0-9]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Tipo de comprovante</td>
            <td>
            <select name="tipo">
               <option></option>
               <option>Autorização</option>
               <option>Agendamento</option>
            </select>
            </td>
       	 </tr>
    	  <tr>
        	<td>Número do documento</td>
     	    <td><input type="text" name="documento" pattern="[0-9]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Data do documento</td>
     	    <td><input type="text" name="data" class="data" /></td>
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
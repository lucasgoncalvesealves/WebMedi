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
<title>Gerenciar Preços</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="credenciador">
	 	<div><img src="${pageContext.request.contextPath}/png/dinheiro.png" /></div>
        <h1>Preços de Procedimentos</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/credenciador.jsp">Voltar</a>        
        <a id="button-2">Incluir</a>    
        <a id="button-1">Consultar</a>
    </div>
    <div id="content">
        <div id="div-1">
        <h2>Consultar Preço</h2>
        <form>
        <table>
    	  <tr>
        	<td>Nome do procedimento</td>
     	    <td><input type="text" name="procedimento" pattern="[a-z\s]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Nome da clínica</td>
     	    <td><input type="text" name="clinica" pattern="[a-z\s]+$" /></td>
       	 </tr>
         <tr>
      	   <td></td>
           <td><button type="submit">Enviar</button></td>
         </tr>
        </table>
        </form>
        </div>
        <div id="div-2">
        <h2>Incluir Preço</h2>
        <form>
        <table>
  	      <tr>
    	    <td>Nome do procedimento</td>
        	<td><input type="text" name="procedimento" pattern="[a-z\s]+$" /></td>
          </tr>
    	  <tr>
        	<td>Nome da clínica</td>
     	    <td><input type="text" name="clinica" pattern="[a-z\s]+$" /></td>
       	 </tr>
    	  <tr>
        	<td>Preço do procedimento</td>
     	    <td><input type="text" name="preco" pattern="[0-9]+$" /></td>
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
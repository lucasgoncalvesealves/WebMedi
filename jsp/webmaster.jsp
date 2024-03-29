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
<title>Gerenciar Usuários</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="webmaster">
	 	<div><img src="${pageContext.request.contextPath}/png/cliente.png" /></div>
        <h1>Usuários</h1>
        <a class="voltar" href="javascript:history.back();">Voltar</a>        
        <a id="button-2" href="#">Incluir</a>    
        <a id="button-1" href="#">Consultar</a>
    </div>
    <div id="content">
        <div id="div-1">
        <h2>Consultar Usuário</h2>
        <form>
        <table>
  	      <tr>
    	    <td>Login do usuário</td>
        	<td><input type="text" /></td>
          </tr>
		  <tr>
			<td>Perfil do usuário</td>
			<td>
				<select>
					<option></option>
					<option>Cliente</option>
					<option>Atendente</option>
					<option>Credenciador</option>
					<option>Administrador</option>
					<option>Financeiro</option>
				</select>
			</td>
		</tr>
         <tr>
      	   <td></td>
           <td><button type="submit">Enviar</button></td>
         </tr>
        </table>
        </form>
        </div>
        <div id="div-2">
        <h2>Incluir Usuário</h2>
        <form>
        <table>
  	      <tr>
    	    <td>Login do usuário</td>
        	<td><input type="text" /></td>
          </tr>
		  <tr>
			<td>Perfil do usuário</td>
			<td>
				<select>
					<option></option>
					<option>Cliente</option>
					<option>Atendente</option>
					<option>Credenciador</option>
					<option>Administrador</option>
					<option>Financeiro</option>
				</select>
			</td>
		</tr>
  	      <tr>
    	    <td>Senha do usuário</td>
        	<td><input type="text" /></td>
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
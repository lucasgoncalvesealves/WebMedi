<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css"/>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript">
var msgStatus = '<%=request.getAttribute("msgStatus")%>'
if (msgStatus != "null") {
	alert(msgStatus)	
}
</script>
<title>Bem-vindo ao Autorizador WebMedi</title>
</head>
<body class="inicial">
<div id="wrapper">
	<img src="${pageContext.request.contextPath}/png/logo_webmedi.png" />
	<div id="formulario">
		<form method="post" action="${pageContext.request.contextPath}/LogarNoSistema.do">		
        <table>
		<tr>
			<td>Login:</td>
			<td colspan="2"><input type="text" name="usuario" /></td>
		</tr>
		<tr>
			<td>Senha:</td>
			<td colspan="2"><input type="password" name="senha" /></td>
		</tr>
		<tr>
			<td>Eu sou:</td>
			<td>
				<select name="quemsou" onchange="document.getElementById('formulario').style.backgroundColor = this.options[this.selectedIndex].value">
					<option></option>
					<option value="#0C9">Cliente</option>
					<option value="#0CC">Atendente</option>
					<option value="#0CF">Credenciador</option>
					<option value="#39F">Administrador</option>
					<option value="#99F">Financeiro</option>
				</select>
			</td>
			<td align="right"><input type="submit" value="OK" /></td>
		</tr>
        <tr>
        	<td></td>
            <td colspan="2"><a href="${pageContext.request.contextPath}/esqueci-a-senha.jsp">Esqueci minha senha</a></td>
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

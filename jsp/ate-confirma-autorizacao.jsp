<%@ page import="java.text.SimpleDateFormat,java.util.Date,dao.ProcedimentoDAO,model.clsProcedimento,java.util.*,java.math.BigDecimal,java.text.DecimalFormat" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<%
Date dataRealiza = (Date) session.getAttribute("dataRealiza");
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String cDataRealiza = sdf.format(dataRealiza);
String horaRealiza = (String) session.getAttribute("horaRealiza");
ProcedimentoDAO procedDAO = new ProcedimentoDAO();
List<clsProcedimento> lstProced = procedDAO.buscaPorNome(request.getParameter("nomProced"));
BigDecimal nValor = new BigDecimal(0);
DecimalFormat df = new DecimalFormat("###,##0.00");
String cValor = df.format(nValor);
if (!lstProced.isEmpty()) {
	clsProcedimento proced = lstProced.get(0);
	nValor = proced.getValor();
	cValor = df.format(nValor);
}
BigDecimal numCartao = new BigDecimal(request.getParameter("numCartao"));
session.setAttribute("numCartao", numCartao);
session.setAttribute("nomProced", request.getParameter("nomProced"));
session.setAttribute("nomClinica", request.getParameter("nomClinica"));
session.setAttribute("nomAtendente", request.getParameter("nomAtendente"));
session.setAttribute("nomMedico", request.getParameter("nomMedico"));
session.setAttribute("dataRealiza", dataRealiza);
session.setAttribute("horaRealiza", horaRealiza);
session.setAttribute("preco", new Double(cValor.replace(".","").replace(",",".")));
%>
<title>Confirmar Autorização</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="atendente">
	 	<div><img src="${pageContext.request.contextPath}/png/autorizacao.png" /></div>
        <h1>Autorização</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/atendente.jsp">Voltar</a>        
    </div>
    <div id="content">
        <div>
        <h2>Confirmar Autorização</h2>
        <form method="post" action="${pageContext.request.contextPath}/ConfirmarAutorizacao.do">
        <table>
  	     <tr>
    	    <td>Número do cartão do cliente</td>
        	<td><%= request.getParameter("numCartao") %></td>
         </tr>
    	 <tr>
        	<td>Nome do procedimento</td>
        	<td><%= request.getParameter("nomProced") %></td>
       	 </tr>
     	 <tr>
    	    <td>Nome da clínica</td>
        	<td><%= request.getParameter("nomClinica") %></td>
	     </tr>
     	 <tr>
    	    <td>Nome do atendente</td>
        	<td><%= request.getParameter("nomAtendente") %></td>
	     </tr>
     	 <tr>
    	    <td>Nome do médico</td>
        	<td><%= request.getParameter("nomMedico") %></td>
	     </tr>
    	 <tr>
        	<td>Data de realização</td>
        	<td><%= cDataRealiza %></td>
       	 </tr>
    	 <tr>
        	<td>Hora de realização</td>
        	<td><%= horaRealiza %></td>
       	 </tr>
    	 <tr>
        	<td>Preço do procedimento</td>
        	<td><%= cValor %></td>
       	 </tr>
         <tr>
      	   	<td></td>
           	<td><button type="submit">Confirmar</button></td>
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
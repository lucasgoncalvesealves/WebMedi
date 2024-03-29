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
<script type="text/javascript">
alert("ATENÇÃO: Saldo Insuficiente. A Autorização Somente Poderá ser Concedida em Contingência.")	
</script>
<%
SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
Date dataRealiza = (Date) request.getAttribute("dataRealiza");
String cDataRealiza = sdf2.format(dataRealiza);
String horaRealiza = (String) request.getAttribute("horaRealiza");
ProcedimentoDAO procedDAO = new ProcedimentoDAO();
List<clsProcedimento> lstProced = procedDAO.buscaPorNome((String) request.getAttribute("nomProced"));
BigDecimal nValor = new BigDecimal(0);
DecimalFormat df = new DecimalFormat("###,##0.00");
String cValor = df.format(nValor);
if (!lstProced.isEmpty()) {
	clsProcedimento proced = lstProced.get(0);
	nValor = proced.getValor();
	cValor = df.format(nValor);
}
BigDecimal numCartao = (BigDecimal) request.getAttribute("numCartao");
session.setAttribute("numCartao", numCartao);
session.setAttribute("nomProced", request.getAttribute("nomProced"));
session.setAttribute("nomClinica", request.getAttribute("nomClinica"));
session.setAttribute("nomAtendente", request.getAttribute("nomAtendente"));
session.setAttribute("nomMedico", request.getAttribute("nomMedico"));
session.setAttribute("dataRealiza", dataRealiza);
session.setAttribute("horaRealiza", horaRealiza);
session.setAttribute("preco", new Double(cValor.replace(".","").replace(",",".")));
%>
<title>Confirmar Contingência</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="atendente">
	 	<div><img src="${pageContext.request.contextPath}/png/autorizacao.png" /></div>
        <h1>Contingência</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/atendente.jsp">Voltar</a>        
    </div>
    <div id="content">
        <div>
        <h2>Confirmar Contingência</h2>
        <form method="post" action="${pageContext.request.contextPath}/ConfirmarContingencia.do">
        <table>
  	     <tr>
    	    <td>Número do cartão do cliente</td>
        	<td><%= request.getAttribute("numCartao") %></td>
         </tr>
    	 <tr>
        	<td>Nome do procedimento</td>
        	<td><%= request.getAttribute("nomProced") %></td>
       	 </tr>
     	 <tr>
    	    <td>Nome da clínica</td>
        	<td><%= request.getAttribute("nomClinica") %></td>
	     </tr>
     	 <tr>
    	    <td>Nome do atendente</td>
        	<td><%= request.getAttribute("nomAtendente") %></td>
	     </tr>
     	 <tr>
    	    <td>Nome do médico</td>
        	<td><%= request.getAttribute("nomMedico") %></td>
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
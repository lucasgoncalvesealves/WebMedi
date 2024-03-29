<%@ page import="java.text.SimpleDateFormat,java.util.Date,model.clsProcedimento,dao.ProcedimentoDAO,java.util.*,java.math.BigDecimal,java.text.DecimalFormat,dao.SolicitacaoDAO,model.clsSolicitacao,model.clsCliente,model.clsClinica,model.clsAtendente,model.clsMedico,dao.AgendamentoDAO,model.clsAgendamento" %>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/mais/estilos.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath}/mais/jquery-1.8.2.min.js"></script>
<%
BigDecimal numCartao = new BigDecimal(0);
String nomProced = "";
String nomClinica = "";
String nomAtendente = "";
String nomMedico = "";
Long solicitaSel = new Long(request.getParameter("solicitaSel"));
SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
List<clsSolicitacao> lstSolicita = solicitaDAO.buscaPorCod(solicitaSel);
clsSolicitacao solicita = new clsSolicitacao();
Date dataExecucao = new Date(0);
String horaExecucao = "";
if (!lstSolicita.isEmpty()) {
	solicita = lstSolicita.get(0);
	clsCliente cli = solicita.getTblCliente();
	numCartao = cli.getNroCartao();
	clsProcedimento proced = solicita.getTblProcedimento();
	nomProced = proced.getNome();
	clsClinica clin = solicita.getTblClinica();
	nomClinica = clin.getNome();
	clsAtendente atende = solicita.getTblAtendente();
	nomAtendente = atende.getNome();
	clsMedico med = solicita.getTblMedico();
	nomMedico = med.getNome();

	AgendamentoDAO agendaDAO = new AgendamentoDAO();
	String strSql = "SELECT * FROM TBL_AGENDAMENTO WHERE COD_SOLICITACAO = " + solicitaSel;
	List<clsAgendamento> lstAgenda = agendaDAO.buscaSQL(strSql);
	if (!lstAgenda.isEmpty()) {
		clsAgendamento agenda = lstAgenda.get(0);
		dataExecucao = agenda.getData();
		horaExecucao = agenda.getHora();
	}

}
ProcedimentoDAO procedDAO = new ProcedimentoDAO();
BigDecimal nValor = new BigDecimal(0);
DecimalFormat df = new DecimalFormat("###,##0.00");
String cValor = df.format(nValor);
List<clsProcedimento> lstProced = procedDAO.buscaPorNome(nomProced);
if (!lstProced.isEmpty()) {
	clsProcedimento proced = lstProced.get(0);
	nValor = proced.getValor();
	cValor = df.format(nValor);
}
session.setAttribute("numCartao", numCartao);
session.setAttribute("nomProced", nomProced);
session.setAttribute("preco", new Double(cValor.replace(".","").replace(",",".")));
session.setAttribute("solicitaSel", solicitaSel);
%>
<title>Confirmar Execução</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="atendente">
	 	<div><img src="${pageContext.request.contextPath}/png/procedimento.png" /></div>
        <h1>Execução</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/atendente.jsp">Voltar</a>        
    </div>
    <div id="content">
        <div>
        <h2>Confirmar Execução</h2>
        <form method="post" action="${pageContext.request.contextPath}/ConfirmarExecucao.do">
        <table>
  	      <tr>
    	    <td>Número do cartão do cliente</td>
        	<td><%= numCartao %></td>
          </tr>
    	  <tr>
        	<td>Nome do procedimento</td>
     	    <td><%= nomProced %></td>
       	 </tr>
     	 <tr>
    	    <td>Nome da clínica</td>
        	<td><%= nomClinica %></td>
	     </tr>
     	 <tr>
    	    <td>Nome do atendente</td>
        	<td><%= nomAtendente %></td>
	     </tr>
     	 <tr>
    	    <td>Nome do médico</td>
        	<td><%= nomMedico %></td>
	     </tr>
    	 <tr>
        	<td>Data de execução</td>
     	    <td><input type="date" name="dataExecucao" value=<%= dataExecucao %> /></td>
       	 </tr>
    	 <tr>
        	<td>Hora de execução</td>
     	    <td><input type="time" name="horaExecucao" value=<%= horaExecucao %> /></td>
       	 </tr>
    	 <tr>
        	<td>Preço do procedimento</td>
        	<td><%= cValor %></td>
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
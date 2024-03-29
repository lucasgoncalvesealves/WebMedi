<%@ page import="bean.ProcedimentoBean,model.clsProcedimento,dao.ProcedimentoDAO,util.HibernateUtils,bean.ClinicaBean,model.clsClinica,dao.ClinicaDAO,bean.MedicoBean,model.clsMedico,dao.MedicoDAO,bean.AtendenteBean,model.clsAtendente,dao.AtendenteDAO,bean.SolicitacaoBean,dao.SolicitacaoDAO,model.clsSolicitacao,bean.AutorizacaoBean,dao.AutorizacaoDAO,model.clsAutorizacao,bean.AgendamentoBean,dao.AgendamentoDAO,model.clsAgendamento,java.text.SimpleDateFormat,java.text.DecimalFormat,model.clsCliente,java.util.Date,java.util.*" %>
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
<script type="text/javascript">
var msgRet = '<%=request.getAttribute("msgRet")%>'
if (msgRet != "null") {
	alert(msgRet)	
}
</script>
<%
Date dataRealiza = new Date();
SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
String horaRealiza = sdf1.format(dataRealiza);
SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
String cDataRealiza = sdf2.format(dataRealiza);
session.setAttribute("dataRealiza",dataRealiza);
session.setAttribute("horaRealiza",horaRealiza);
%>
<title>Gerenciar Autorizações</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="atendente">
	 	<div><img src="${pageContext.request.contextPath}/png/autorizacao.png" /></div>
        <h1>Autorizações</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/atendente.jsp">Voltar</a>        
        <a id="button-2">Cancelar</a>    
        <a id="button-1">Solicitar</a>
    </div>
    <div id="content">
        <div id="div-1">
        <h2>Solicitar Autorização</h2>
        <form method="post" action="${pageContext.request.contextPath}/ValidarDadosAutorizacao.do">
        <table>
  	      <tr>
    	    <td>Número do cartão do cliente</td>
        	<td><input type="number" name="numCartao" pattern="[0-9]+$" /></td>
          </tr>
		 <tr>
			<td>Nome do procedimento</td>
			<td>
			<select style=width:300px name="nomProced" size="1">
			<%
			ProcedimentoBean procedBean = new ProcedimentoBean();
			List<clsProcedimento> lstProced = procedBean.getListaItens();
			for (Iterator<clsProcedimento> iterator = lstProced.iterator(); iterator.hasNext();) {
				clsProcedimento proced = (clsProcedimento) iterator.next();
			%>
				<option value="<%= proced.getNome() %>"> <%= proced.getNome() %> </option>
			<%
			}
			%>
			</select>
			</td>
		 </tr>
		 <tr>
			<td>Nome da clínica</td>
			<td>
			<select style=width:300px name="nomClinica" size="1">
			<%
			ClinicaBean clinBean = new ClinicaBean();
			List<clsClinica> lstClin = clinBean.getListaItens();
			for (Iterator<clsClinica> iterator = lstClin.iterator(); iterator.hasNext();) {
				clsClinica clin = (clsClinica) iterator.next();
			%>
				<option value="<%= clin.getNome() %>"> <%= clin.getNome() %> </option>
			<%
			}
			%>
			</select>
			</td>
		 </tr>
		 <tr>
			<td>Nome do atendente</td>
			<td>
			<select style=width:300px name="nomAtendente" size="1">
			<%
			AtendenteBean atendeBean = new AtendenteBean();
			List<clsAtendente> lstAtende = atendeBean.getListaItens();
			for (Iterator<clsAtendente> iterator = lstAtende.iterator(); iterator.hasNext();) {
				clsAtendente atende = (clsAtendente) iterator.next();
			%>
				<option value="<%= atende.getNome() %>"> <%= atende.getNome() %> </option>
			<%
			}
			%>
			</select>
			</td>
		 </tr>
		 <tr>
			<td>Nome do médico</td>
			<td>
			<select style=width:300px name="nomMedico" size="1">
			<%
			MedicoBean medBean = new MedicoBean();
			List<clsMedico> lstMed = medBean.getListaItens();
			for (Iterator<clsMedico> iterator = lstMed.iterator(); iterator.hasNext();) {
				clsMedico med = (clsMedico) iterator.next();
			%>
				<option value="<%= med.getNome() %>"> <%= med.getNome() %> </option>
			<%
			}
			%>
			</select>
			</td>
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
      	   <td></td>
           <td><button type="submit">Enviar</button></td>
         </tr>
        </table>
        </form>
        </div>
        <div id="div-2">
        <h2>Cancelar Autorização</h2>
        <form method="post" action="${pageContext.request.contextPath}/ValidarDadosCancelamento.do">
		<table class="captacao">
			<tr>
				<th width="4%"> </th>
				<th width="9%">Autorização</th>
				<th width="9%">Data</th>
				<th width="7%">Horário</th>
				<th width="15%">Cartão</th>
				<th width="14%">Clínica</th>
				<th width="14%">Médico</th>
				<th width="15%">Procedimento</th>
				<th width="8%">Preço</th>
			</tr>
			<%
			SolicitacaoBean solicitaBean = new SolicitacaoBean();
			List<clsSolicitacao> lstSolicita = solicitaBean.getListaItens();
			for (Iterator<clsSolicitacao> iterator = lstSolicita.iterator(); iterator.hasNext();) {
				clsSolicitacao solicita = (clsSolicitacao) iterator.next();
				Long codSolicita = solicita.getCodSolicitacao();
				Boolean participa = new Boolean(true);
				AutorizacaoDAO autorizaDAO = new AutorizacaoDAO();
				clsAutorizacao autoriza = new clsAutorizacao();
				String strSql = "SELECT * FROM TBL_AUTORIZACAO WHERE STATUS = 'A' AND COD_SOLICITACAO = " + codSolicita;
				List<clsAutorizacao> lstAutoriza = autorizaDAO.buscaSQL(strSql);
				if (!lstAutoriza.isEmpty()) {
					autoriza = lstAutoriza.get(0);
					AgendamentoDAO agendaDAO = new AgendamentoDAO();
					strSql = "SELECT * FROM TBL_AGENDAMENTO WHERE COD_SOLICITACAO = " + codSolicita;
					List<clsAgendamento> lstAgenda = agendaDAO.buscaSQL(strSql);
					if (!lstAgenda.isEmpty()) {
						participa = false;					
					}
				}
				else {
					participa = false;
				}
				if (participa) {
			%>
					<tr>
						<td width="4%"><input type="radio" name="solicitaSel" value="<%= solicita.getCodSolicitacao() %>" /></td>
						<td width="9%"><%= autoriza.getCodAutorizacao() %></td>
						<td width="9%">
						<%
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						String cData = sdf.format(autoriza.getData());
						%>
						<%= cData %>
						</td>
						<td width="7%">
						<%= autoriza.getHora() %>
						</td>
						<td width="15%">
						<%
						clsCliente tabCli = solicita.getTblCliente();
						%>
						<%= tabCli.getNroCartao() %>
						</td>
						<td width="14%">
						<%
						clsClinica tabClinica = solicita.getTblClinica();
						%>
						<%= tabClinica.getNome() %>
						</td>
						<td width="14%">
						<%
						clsMedico tabMed = solicita.getTblMedico();
						if (tabMed != null) {
						%>
						<%= tabMed.getNome() %>
						<%
						}
						%>
						</td>
						<td width="15%">
						<%
						clsProcedimento tabProced = solicita.getTblProcedimento();
						%>
						<%= tabProced.getNome() %>
						</td>
						<td width="8%">
						<%
						DecimalFormat dfPreco = new DecimalFormat("###,##0.00");
						String cPreco = dfPreco.format(solicita.getPreco());
						%>
						<%= cPreco %>
						</td>
					</tr>
				<%
				}
				%>
			<%
			}
			%>
		</table>
		<div class="pos-tabela">
		<button type="submit">Enviar</button>
        </div>
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

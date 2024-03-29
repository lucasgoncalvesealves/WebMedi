<%@ page import="bean.ProcedimentoBean,model.clsProcedimento,java.util.*,bean.SolicitacaoBean,model.clsSolicitacao,java.text.SimpleDateFormat,java.text.DecimalFormat,model.clsCliente,model.clsClinica,model.clsAtendente,dao.AgendamentoDAO,model.clsAgendamento,dao.AutorizacaoDAO,model.clsAutorizacao,model.clsMedico" %>
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
<title>Gerenciar Procedimentos</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<a href="${pageContext.request.contextPath}/jsp/index.jsp"><img src="${pageContext.request.contextPath}/png/cabecalho.png" /></a>
		<p>Bem-vindo, <b><%=session.getAttribute("atribUsuario") %></b>.</p>
	</div>
	<div id="subheader" class="atendente">
	 	<div><img src="${pageContext.request.contextPath}/png/procedimento.png" /></div>
        <h1>Procedimentos</h1>
        <a class="voltar" href="${pageContext.request.contextPath}/jsp/atendente.jsp">Voltar</a>        
        <a id="button-2">Executar</a>    
        <a id="button-1">Agendar</a>
    </div>
    <div id="content">
        <div id="div-1">
        <h2>Agendar Procedimento</h2>
        <form method="post" action="${pageContext.request.contextPath}/ValidarDadosAgendamento.do">
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
			clsAutorizacao autoriza = new clsAutorizacao();
			for (Iterator<clsSolicitacao> iterator = lstSolicita.iterator(); iterator.hasNext();) {
				clsSolicitacao solicita = (clsSolicitacao) iterator.next();
				Long codSolicita = solicita.getCodSolicitacao();
				Boolean participa = new Boolean(true);
				AutorizacaoDAO autorizaDAO = new AutorizacaoDAO();
				String strSql = "SELECT * FROM TBL_AUTORIZACAO WHERE STATUS = 'A' AND COD_SOLICITACAO = " + codSolicita;
				List<clsAutorizacao> lstAutoriza = autorizaDAO.buscaSQL(strSql);
				autoriza = new clsAutorizacao();
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
						String cData = sdf.format(solicita.getData());
						%>
						<%= cData %>
						</td>
						<td width="7%">
						<%= solicita.getHora() %>
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
        <div id="div-2">
        <h2>Executar Procedimento</h2>
        <form method="post" action="${pageContext.request.contextPath}/ValidarDadosExecucao.do">
		<table class="captacao">
			<tr>
				<th width="4%"> </th>
				<th width="9%">Agendamento</th>
				<th width="9%">Data</th>
				<th width="7%">Horário</th>
				<th width="15%">Cartão</th>
				<th width="14%">Clínica</th>
				<th width="14%">Médico</th>
				<th width="15%">Procedimento</th>
				<th width="8%">Preço</th>
			</tr>
			<%
			SolicitacaoBean solicitaBean2 = new SolicitacaoBean();
			List<clsSolicitacao> lstSolicita2 = solicitaBean2.getListaItens();
			clsAgendamento agenda = new clsAgendamento();
			for (Iterator<clsSolicitacao> iterator2 = lstSolicita2.iterator(); iterator2.hasNext();) {
				clsSolicitacao solicita2 = (clsSolicitacao) iterator2.next();
				Long codSolicita2 = solicita2.getCodSolicitacao();
				Boolean participa2 = new Boolean(true);
				AutorizacaoDAO autorizaDAO2 = new AutorizacaoDAO();
				String strSql2 = "SELECT * FROM TBL_AUTORIZACAO WHERE STATUS = 'A' AND COD_SOLICITACAO = " + codSolicita2;
				List<clsAutorizacao> lstAutoriza2 = autorizaDAO2.buscaSQL(strSql2);
				agenda = new clsAgendamento();
				if (!lstAutoriza2.isEmpty()) {
					AgendamentoDAO agendaDAO2 = new AgendamentoDAO();
					strSql2 = "SELECT * FROM TBL_AGENDAMENTO WHERE COD_SOLICITACAO = " + codSolicita2 + " AND DATA_EXECUCAO IS NULL";
					List<clsAgendamento> lstAgenda2 = agendaDAO2.buscaSQL(strSql2);
					if (lstAgenda2.isEmpty()) {
						participa2 = false;					
					}
					else {
						agenda = lstAgenda2.get(0);
					}
				}
				else {
					participa2 = false;
				}
				if (participa2) {
			%>
					<tr>
						<td width="4%"><input type="radio" name="solicitaSel" value="<%= solicita2.getCodSolicitacao() %>" /></td>
						<td width="9%"><%= agenda.getCodAgendamento() %></td>
						<td width="9%">
						<%
						SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
						String cData2 = sdf2.format(agenda.getData());
						%>
						<%= cData2 %>
						</td>
						<td width="7%">
						<%= agenda.getHora() %>
						</td>
						<td width="15%">
						<%
						clsCliente tabCli2 = solicita2.getTblCliente();
						%>
						<%= tabCli2.getNroCartao() %>
						</td>
						<td width="14%">
						<%
						clsClinica tabClinica2 = solicita2.getTblClinica();
						%>
						<%= tabClinica2.getNome() %>
						</td>
						<td width="14%">
						<%
						clsMedico tabMed2 = solicita2.getTblMedico();
						if (tabMed2 != null) {
						%>
						<%= tabMed2.getNome() %>
						<%
						}
						%>
						</td>
						<td width="15%">
						<%
						clsProcedimento tabProced2 = solicita2.getTblProcedimento();
						%>
						<%= tabProced2.getNome() %>
						</td>
						<td width="8%">
						<%
						DecimalFormat dfPreco2 = new DecimalFormat("###,##0.00");
						String cPreco2 = dfPreco2.format(solicita2.getPreco());
						%>
						<%= cPreco2 %>
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

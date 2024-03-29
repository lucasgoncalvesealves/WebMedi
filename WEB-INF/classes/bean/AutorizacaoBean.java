package bean;

import java.text.DecimalFormat;
import java.util.List;

import model.clsAutorizacao;
import dao.AutorizacaoDAO;

import javax.faces.bean.ManagedBean;

import org.hibernate.exception.ConstraintViolationException;

import java.util.Date;

import dao.ClienteDAO;
import model.clsCliente;

import java.math.BigDecimal;

import dao.SolicitacaoDAO;
import model.clsSolicitacao;

//import java.util.Calendar;

import dao.ClinicaDAO;
import model.clsClinica;
import dao.ProcedimentoDAO;
import model.clsProcedimento;
import dao.AtendenteDAO;
import model.clsAtendente;
import dao.MedicoDAO;
import model.clsMedico;

import java.util.*;

import model.clsContrato;
import dao.ContratoDAO;
import model.clsMovimentacao;
import dao.MovimentacaoDAO;
import model.clsPrevisaoPagamento;
import dao.PrevisaoPagamentoDAO;

//import org.hibernate.exception.GenericJDBCException;
import java.sql.*;

@ManagedBean
public class AutorizacaoBean {
	private AutorizacaoDAO autorizaDAO = new AutorizacaoDAO();
	private clsAutorizacao itemSelecionado;
	private List<clsAutorizacao> listaItens;
	
	public AutorizacaoBean() {
		listaItens = autorizaDAO.listaTodos();
	}

	public List<clsAutorizacao> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsAutorizacao> listaItens) {
		this.listaItens = listaItens;
	}

	public clsAutorizacao getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsAutorizacao itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public String validarDadosAutorizacao(BigDecimal numCartao, String nomProced, String nomClinica, String nomAtendente, String nomMedico, Date dataRealiza, String horaRealiza) {
		String msgRet = "";
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (lstCli.isEmpty()) {
			msgRet = "Cliente Não Encontrado!";
		}
		if (msgRet == "") {
			ProcedimentoDAO procedDAO = new ProcedimentoDAO();
			List<clsProcedimento> lstProced = procedDAO.buscaPorNome(nomProced);
			if (lstProced.isEmpty()) {
				msgRet = "Procedimento Não Encontrado!";
			}
		}
		return msgRet;
	}
	
	public String solicitarAutorizacao(BigDecimal numCartao, String nomProced, String nomClinica, String nomAtendente, String nomMedico, Date dataRealiza, String horaRealiza, Double preco, String contingencia) {
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String precoStr = df.format(preco);
		BigDecimal precoBig = new BigDecimal(precoStr.replace(".","").replace(",","."));
		SolicitacaoDAO daoSolicita = new SolicitacaoDAO();
		clsSolicitacao tabSolicita = new clsSolicitacao();
		tabSolicita.setContingencia(contingencia);
		tabSolicita.setData(dataRealiza);
		tabSolicita.setHora(horaRealiza);
		//Integer intHora = (Calendar.getInstance().get(Calendar.HOUR) * 100);
		//intHora = intHora + Calendar.getInstance().get(Calendar.MINUTE);
		//Double hora = intHora.doubleValue();
		//tabSolicita.setHorario(hora);
		tabSolicita.setPreco(preco);
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		clsCliente cli = new clsCliente();
		if (!lstCli.isEmpty()) {
			cli = lstCli.get(0);
			tabSolicita.setTblCliente(cli);
		}
		else {
			tabSolicita.setTblCliente(null);
		}
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		List<clsClinica> lstClinica = clinicaDAO.buscaPorNome(nomClinica);
		if (!lstClinica.isEmpty()) {
			clsClinica clinica = lstClinica.get(0);
			tabSolicita.setTblClinica(clinica);
		}
		else {
			tabSolicita.setTblClinica(null);
		}
		ProcedimentoDAO procedDAO = new ProcedimentoDAO();
		List<clsProcedimento> lstProced = procedDAO.buscaPorNome(nomProced);
		clsProcedimento proced = new clsProcedimento();
		if (!lstProced.isEmpty()) {
			proced = lstProced.get(0);
			tabSolicita.setTblProcedimento(proced);
		}
		else {
			tabSolicita.setTblProcedimento(null);
		}
		AtendenteDAO atendDAO = new AtendenteDAO();
		List<clsAtendente> lstAtend = atendDAO.buscaPorNome(nomAtendente);
		clsAtendente atend = new clsAtendente();
		if (!lstAtend.isEmpty()) {
			atend = lstAtend.get(0);
			tabSolicita.setTblAtendente(atend);
		}
		else {
			tabSolicita.setTblAtendente(null);
		}
		MedicoDAO medicoDAO = new MedicoDAO();
		List<clsMedico> lstMedico = medicoDAO.buscaPorNome(nomMedico);
		clsMedico medico = new clsMedico();
		if (!lstMedico.isEmpty()) {
			medico = lstMedico.get(0);
			tabSolicita.setTblMedico(medico);
		}
		else {
			tabSolicita.setTblMedico(null);
		}
		
		AutorizacaoDAO daoAutoriza = new AutorizacaoDAO();
		clsAutorizacao tabAutoriza = new clsAutorizacao();
		tabAutoriza.setData(dataRealiza);
		tabAutoriza.setHora(horaRealiza);
		tabAutoriza.setStatus("A");
		tabAutoriza.setTblSolicitacao(tabSolicita);

		MovimentacaoDAO daoMov = new MovimentacaoDAO();
		clsMovimentacao tabMov = new clsMovimentacao();
		if (contingencia.equals("N")) {
			tabMov.setCredito(new BigDecimal(0));
			tabMov.setDebito(precoBig);
			tabMov.setData(dataRealiza);
			//tabMov.setSaldo(new BigDecimal(0));
			tabMov.setTblAutorizacao(tabAutoriza);
			if (!lstCli.isEmpty()) {
				cli = lstCli.get(0);
				ContratoDAO contraDAO = new ContratoDAO();
				String strSql = "SELECT * FROM TBL_CONTRATO WHERE COD_CLIENTE = " + cli.getCodCliente() + " ORDER BY DATA_VENC DESC";
				List<clsContrato> lstContra = contraDAO.buscaSQL(strSql);
				if (!lstContra.isEmpty()) {
					clsContrato contra = lstContra.get(0);
					tabMov.setTblContrato(contra);
				}
			}
		}
		
		/*
		PrevisaoPagamentoDAO daoPrev = new PrevisaoPagamentoDAO();
		clsPrevisaoPagamento tabPrev = new clsPrevisaoPagamento();
		Calendar calend = Calendar.getInstance();
		calend.setTime(dataRealiza);
		calend.add(Calendar.DATE,15);
		Date dataPrev = calend.getTime();
		tabPrev.setDataPrevista(dataPrev);
		tabPrev.setValorPrevisto(preco);
		tabPrev.setTblAutorizacao(tabAutoriza);
		*/
		
		List<clsAutorizacao> lstAutoriza = new ArrayList<clsAutorizacao>();
		lstAutoriza.add(tabAutoriza);
		tabSolicita.setTblAutorizacaos(lstAutoriza);
		tabSolicita.setTblAgendamentos(null);
		tabSolicita.setTblAutorizacaoNegadas(null);

		/*
		List<clsPrevisaoPagamento> lstPrev = new ArrayList<clsPrevisaoPagamento>();
		lstPrev.add(tabPrev);
		tabAutoriza.setTblPrevisaoPagamentos(lstPrev);
		*/
		
		try {
			daoSolicita.salvar(tabSolicita);
			daoAutoriza.salvar(tabAutoriza);
			if (contingencia.equals("N")) {
				daoMov.salvar(tabMov);
			}
			//daoPrev.salvar(tabPrev);
			if (contingencia == "N") {
				return "Autorização " + tabAutoriza.getCodAutorizacao() + " Concedida!";
			}
			else {
				return "Autorização " + tabAutoriza.getCodAutorizacao() + " Concedida em Contingência!";
			}
		}
		catch (ConstraintViolationException e) {
			return "Erro na Inclusão da Autorização Concedida: Violação de Restrição do Banco de Dados!";
		}
		catch (Exception e) {
			return "Erro na Inclusão da Autorização Concedida: " + e.getMessage();
		}
	}

	public String verificarSaldo(BigDecimal numCartao, String nomProced, String nomClinica, String nomAtendente, String nomMedico, Date dataRealiza, String horaRealiza, Double preco) {
		Double nSaldo = new Double(0);
		String msgRet = "";
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (!lstCli.isEmpty()) {
			clsCliente cli = lstCli.get(0);
			ContratoDAO contraDAO = new ContratoDAO();
			String strSql = "SELECT * FROM TBL_CONTRATO WHERE COD_CLIENTE = " + cli.getCodCliente() + " ORDER BY DATA_VENC DESC";
			List<clsContrato> lstContra = contraDAO.buscaSQL(strSql);
			if (!lstContra.isEmpty()) {
				clsContrato contra = lstContra.get(0);
				Long codContra = contra.getCodContrato();
				MovimentacaoDAO movDAO = new MovimentacaoDAO();
				strSql = "SELECT * FROM TBL_MOVIMENTACAO WHERE COD_CONTRATO = " + codContra;
				List<clsMovimentacao> lstMov = movDAO.buscaSQL(strSql);
				if (!lstMov.isEmpty()) {
					for (Iterator<clsMovimentacao> iterator = lstMov.iterator(); iterator.hasNext();) {
						clsMovimentacao mov = (clsMovimentacao) iterator.next();
						nSaldo = nSaldo + mov.getCredito().doubleValue();
						nSaldo = nSaldo - mov.getDebito().doubleValue();
					}
				}
			}
		}
		if (Double.compare(nSaldo,preco) < 0) {
			msgRet = "Autorização Negada: Saldo Insuficiente.";
		}
		return msgRet;
	}

	public String verificarContingencia(BigDecimal numCartao, String nomProced, String nomClinica, String nomAtendente, String nomMedico, Date dataRealiza, String horaRealiza, BigDecimal preco) {
		String msgRet = "";
		Long codCli = new Long(0);
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (!lstCli.isEmpty()) {
			clsCliente cli = lstCli.get(0);
			codCli = cli.getCodCliente();
		}
		ClinicaDAO clinicaDAO = new ClinicaDAO();
		List<clsClinica> lstClinica = clinicaDAO.buscaPorNome(nomClinica);
		if (!lstClinica.isEmpty()) {
			clsClinica clinica = lstClinica.get(0);
			if (clinica.getContingencia().equals("N")) {
				msgRet = "Clínica Não Pode Autorizar em Contingência.";
			}
		}
		if (msgRet == "") {
			SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
			String strSql = "SELECT * FROM TBL_SOLICITACAO WHERE CONTINGENCIA = 'S' AND COD_CLIENTE = " + codCli;
			List<clsSolicitacao> lstSolicita = solicitaDAO.buscaSQL(strSql);
			if (!lstSolicita.isEmpty()) {
				for (Iterator<clsSolicitacao> iterator = lstSolicita.iterator(); iterator.hasNext();) {
					clsSolicitacao solicita = (clsSolicitacao) iterator.next();
					Long codSolicita = solicita.getCodSolicitacao();
					AutorizacaoDAO autorizaDAO = new AutorizacaoDAO();
					strSql = "SELECT * FROM TBL_AUTORIZACAO WHERE STATUS = 'A' AND COD_SOLICITACAO = " + codSolicita;
					List<clsAutorizacao> lstAutoriza = autorizaDAO.buscaSQL(strSql);
					if (!lstAutoriza.isEmpty()) {
						Date dataPagtoContingencia = solicita.getDataPagtoContingencia();
						if (dataPagtoContingencia == null) {
							msgRet = "Cliente com Contingência Não Paga.";
							break;
						}
						/*
						clsAutorizacao autoriza = lstAutoriza.get(0);
						Long codAutoriza = autoriza.getCodAutorizacao();
						PrevisaoPagamentoDAO prevDAO = new PrevisaoPagamentoDAO();
						strSql = "SELECT * FROM TBL_PREVISAO_PAGAMENTO WHERE DATA_PAGAMENTO IS NULL AND COD_AUTORIZACAO= " + codAutoriza;
						List<clsPrevisaoPagamento> lstPrev = prevDAO.buscaSQL(strSql);
						if (!lstPrev.isEmpty()) {
							msgRet = "Cliente com Contingência Não Paga.";
							break;
						}
						*/
					}
				}
			}
		}
		return msgRet;
	}

	public String validarDadosCancelamento(BigDecimal numCartao, String nomProced, Long codSolicita) {
		String msgRet = "";
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (lstCli.isEmpty()) {
			msgRet = "Cliente Não Encontrado!";
		}
		if (msgRet == "") {
			ProcedimentoDAO procedDAO = new ProcedimentoDAO();
			List<clsProcedimento> lstProced = procedDAO.buscaPorNome(nomProced);
			if (lstProced.isEmpty()) {
				msgRet = "Procedimento Não Encontrado!";
			}
		}
		return msgRet;
	}

	public String cancelarAutorizacao(BigDecimal numCartao, String nomProced, Date dataCancela, String horaCancela, Double preco, Long solicitaSel) {
		AutorizacaoDAO daoAutoriza = new AutorizacaoDAO();
		clsAutorizacao tabAutoriza = new clsAutorizacao();
		SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
		List<clsSolicitacao> lstSolicita = solicitaDAO.buscaPorCod(solicitaSel);
		clsSolicitacao solicita = new clsSolicitacao();
		//PrevisaoPagamentoDAO daoPrev = new PrevisaoPagamentoDAO();
		//clsPrevisaoPagamento tabPrev = new clsPrevisaoPagamento();
		MovimentacaoDAO daoMov = new MovimentacaoDAO();
		clsMovimentacao tabMov = new clsMovimentacao();
		Boolean excMov = false; 
		if (!lstSolicita.isEmpty()) {
			solicita = lstSolicita.get(0);
			List<clsAutorizacao> lstAutoriza = solicita.getTblAutorizacaos();
			if (!lstAutoriza.isEmpty()) {
				tabAutoriza = lstAutoriza.get(0);
				tabAutoriza.setData_Cancelamento(dataCancela);
				tabAutoriza.setHora_Cancelamento(horaCancela);
				tabAutoriza.setStatus("C");
				/*
				List<clsPrevisaoPagamento> lstPrev = tabAutoriza.getTblPrevisaoPagamentos();
				if (!lstPrev.isEmpty()) {
					tabPrev = lstPrev.get(0);
				}
				*/
				String strSql = "SELECT * FROM TBL_MOVIMENTACAO WHERE COD_AUTORIZACAO = " + tabAutoriza.getCodAutorizacao();
				List<clsMovimentacao> lstMov = daoMov.buscaSQL(strSql);
				if (!lstMov.isEmpty()) {
					tabMov = lstMov.get(0);
					excMov = true;
				}
			}
		}
		try {
			daoAutoriza.salvar(tabAutoriza);
			//daoPrev.remover(tabPrev);
			if (excMov) {
				daoMov.remover(tabMov);
			}
			return "Cancelamento da Autorização Realizado com Sucesso!";
		}
		//catch (GenericJDBCException e) {
		//	return "Cancelamento da Autorização Não Realizado: Restrição de Integridade - " + e.getMessage();
		//}
		catch (ConstraintViolationException e) {
			return "Cancelamento da Autorização Não Realizado: Violação de Restrição do Banco de Dados!";
		}
		catch (Exception e) {
			return "Cancelamento da Autorização Não Realizado: " + e.getMessage();
		}
	}

	public String verificarCancelamento(BigDecimal numCartao, String nomProced, Date dataExecucao, String horaExecucao, Double preco, Long solicitaSel) {
		String msgRet = "";
		clsAutorizacao tabAutoriza = new clsAutorizacao();
		SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
		List<clsSolicitacao> lstSolicita = solicitaDAO.buscaPorCod(solicitaSel);
		clsSolicitacao solicita = new clsSolicitacao();
		Long codAutorizacao = new Long(0);
		if (!lstSolicita.isEmpty()) {
			solicita = lstSolicita.get(0);
			List<clsAutorizacao> lstAutoriza = solicita.getTblAutorizacaos();
			if (!lstAutoriza.isEmpty()) {
				tabAutoriza = lstAutoriza.get(0);
				codAutorizacao = tabAutoriza.getCodAutorizacao();
			}
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","WEBMEDI","WEBMEDI");
			CallableStatement cstmt = conn.prepareCall("{? = call CANCELAR_AUTORIZACAO(?)}");
			cstmt.registerOutParameter(1,Types.VARCHAR);
			cstmt.setLong(2,codAutorizacao);
			cstmt.execute();
			msgRet = cstmt.getString(1);
			cstmt.close();
			conn.close();
			if (msgRet.equals("Cancelamento Autorizado!")) {
				msgRet = "";
			}
		}
		catch (Exception e) {
			msgRet = e.getMessage();
		}		
		return msgRet;
	}
	
}

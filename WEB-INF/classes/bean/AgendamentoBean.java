package bean;

import java.util.List;

import model.clsAgendamento;
import model.clsSolicitacao;
import dao.AgendamentoDAO;
import dao.SolicitacaoDAO;

import javax.faces.bean.ManagedBean;

import org.hibernate.exception.ConstraintViolationException;

import java.util.Date;

import dao.ClienteDAO;
import model.clsCliente;

import java.math.BigDecimal;

import dao.ProcedimentoDAO;
import model.clsProcedimento;
import java.util.*;
import model.clsClinica;
import model.clsMedico;

import dao.PrevisaoPagamentoDAO;
import model.clsPrevisaoPagamento;
import dao.AutorizacaoDAO;
import model.clsAutorizacao;

@ManagedBean
public class AgendamentoBean {
	private AgendamentoDAO agendaDAO = new AgendamentoDAO();
	private clsAgendamento itemSelecionado;
	private List<clsAgendamento> listaItens;
	
	public AgendamentoBean() {
		listaItens = agendaDAO.listaTodos();
	}

	public List<clsAgendamento> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsAgendamento> listaItens) {
		this.listaItens = listaItens;
	}

	public clsAgendamento getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsAgendamento itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public String validarDadosAgendamento(BigDecimal numCartao, String nomProced, Long codSolicita) {
		String msgRet = "";
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (lstCli.isEmpty()) {
			msgRet = "Cliente Não Encontrado!";
		}
		return msgRet;
	}
	
	public String agendarProcedimento(BigDecimal numCartao, String nomProced, Date dataRealiza, String horaRealiza, Double preco, Long solicitaSel) {
		AgendamentoDAO daoAgenda = new AgendamentoDAO();
		clsAgendamento tabAgenda = new clsAgendamento();
		tabAgenda.setData(dataRealiza);
		tabAgenda.setHora(horaRealiza);
		
		SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
		List<clsSolicitacao> lstSolicita = solicitaDAO.buscaPorCod(solicitaSel);
		clsSolicitacao solicita = new clsSolicitacao();
		if (!lstSolicita.isEmpty()) {
			solicita = lstSolicita.get(0);
			tabAgenda.setTblSolicitacao(solicita);
		}

		try {
			daoAgenda.salvar(tabAgenda);
			return "Agendamento " + tabAgenda.getCodAgendamento() + " do Procedimento Realizado com Sucesso!";
		}
		catch (ConstraintViolationException e) {
			return "Agendamento do Procedimento Não Realizado: Violação de Restrição do Banco de Dados!";
		}
		catch (Exception e) {
			return "Agendamento do Procedimento Não Realizado: " + e.getMessage();
		}
	}

	public String verificarDisponibilidade(BigDecimal numCartao, String nomProced, Date dataRealiza, String horaRealiza, Double preco, Long solicitaSel) {
		String msgRet = "";
		Long codProced = new Long(0);
		ProcedimentoDAO procedDAO = new ProcedimentoDAO();
		List<clsProcedimento> lstProced = procedDAO.buscaPorNome(nomProced);
		clsProcedimento proced = new clsProcedimento();
		if (!lstProced.isEmpty()) {
			proced = lstProced.get(0);
			codProced = proced.getCodProcedimento();
		}
		Long codClinica = new Long(0);
		Long codMedico = new Long(0);
		clsClinica clinica = new clsClinica();
		clsMedico med = new clsMedico();
		SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
		String strSql = "SELECT * FROM TBL_SOLICITACAO WHERE COD_SOLICITACAO = " + solicitaSel;
		List<clsSolicitacao> lstSolicita = solicitaDAO.buscaSQL(strSql);
		clsSolicitacao solicita = new clsSolicitacao();
		if (!lstSolicita.isEmpty()) {
			solicita = lstSolicita.get(0);
			clinica = solicita.getTblClinica();
			codClinica = clinica.getCodClinica();
			med = solicita.getTblMedico();
			codMedico = med.getCodMedico();
		}
		Long codSolicita = new Long(0);
		strSql = "SELECT * FROM TBL_SOLICITACAO WHERE COD_PROCEDIMENTO = " + codProced + " AND COD_CLINICA = " + codClinica + " AND COD_MEDICO = " + codMedico;
		lstSolicita = solicitaDAO.buscaSQL(strSql);
		for (Iterator<clsSolicitacao> iterator = lstSolicita.iterator(); iterator.hasNext();) {
			solicita = (clsSolicitacao) iterator.next();
			codSolicita = solicita.getCodSolicitacao();
			AgendamentoDAO agendaDAO = new AgendamentoDAO();
			strSql = "SELECT * FROM TBL_AGENDAMENTO WHERE COD_SOLICITACAO = " + codSolicita;
			List<clsAgendamento> lstAgenda = agendaDAO.buscaSQL(strSql);
			if (!lstAgenda.isEmpty()) {
				clsAgendamento agenda = lstAgenda.get(0);
				Date dataAgenda = agenda.getData();
				String horaAgenda = agenda.getHora();
				if (dataAgenda.equals(dataRealiza) && horaAgenda.equals(horaRealiza)) {
					msgRet = "Não existe disponibilidade para essa Data e Hora!";
				}
			}
		}
		return msgRet;
	}
	
	public String validarDadosExecucao(BigDecimal numCartao, String nomProced, Long codSolicita) {
		String msgRet = "";
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (lstCli.isEmpty()) {
			msgRet = "Cliente Não Encontrado!";
		}
		return msgRet;
	}

	public String executarProcedimento(BigDecimal numCartao, String nomProced, Date dataExecucao, String horaExecucao, Double preco, Long solicitaSel) {
		AgendamentoDAO daoAgenda = new AgendamentoDAO();
		clsAgendamento tabAgenda = new clsAgendamento();
		SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
		List<clsSolicitacao> lstSolicita = solicitaDAO.buscaPorCod(solicitaSel);
		clsSolicitacao solicita = new clsSolicitacao();
		AutorizacaoDAO daoAutoriza = new AutorizacaoDAO();
		clsAutorizacao tabAutoriza = new clsAutorizacao();
		if (!lstSolicita.isEmpty()) {
			solicita = lstSolicita.get(0);
			List<clsAgendamento> lstAgenda = solicita.getTblAgendamentos();
			if (!lstAgenda.isEmpty()) {
				tabAgenda = lstAgenda.get(0);
				tabAgenda.setData_Execucao(dataExecucao);
				tabAgenda.setHora_Execucao(horaExecucao);
			}
			List<clsAutorizacao> lstAutoriza = solicita.getTblAutorizacaos();
			if (!lstAutoriza.isEmpty()) {
				tabAutoriza = lstAutoriza.get(0);
			}
		}

		PrevisaoPagamentoDAO daoPrev = new PrevisaoPagamentoDAO();
		clsPrevisaoPagamento tabPrev = new clsPrevisaoPagamento();
		Calendar calend = Calendar.getInstance();
		calend.setTime(dataExecucao);
		calend.add(Calendar.DATE,15);
		Date dataPrev = calend.getTime();
		tabPrev.setDataPrevista(dataPrev);
		tabPrev.setValorPrevisto(preco * 90 / 100);
		tabPrev.setTblAutorizacao(tabAutoriza);

		List<clsPrevisaoPagamento> lstPrev = new ArrayList<clsPrevisaoPagamento>();
		lstPrev.add(tabPrev);
		tabAutoriza.setTblPrevisaoPagamentos(lstPrev);
		
		try {
			daoAgenda.salvar(tabAgenda);
			daoPrev.salvar(tabPrev);
			daoAutoriza.salvar(tabAutoriza);
			return "Execução do Procedimento Realizada com Sucesso!";
		}
		catch (ConstraintViolationException e) {
			return "Execução do Procedimento Não Realizada: Violação de Restrição do Banco de Dados!";
		}
		catch (Exception e) {
			return "Execução do Procedimento Não Realizada: " + e.getMessage();
		}
	}

	public String verificarExecucao(BigDecimal numCartao, String nomProced, Date dataExecucao, String horaExecucao, Double preco, Long solicitaSel) {
		String msgRet = "";
		Long codProced = new Long(0);
		ProcedimentoDAO procedDAO = new ProcedimentoDAO();
		List<clsProcedimento> lstProced = procedDAO.buscaPorNome(nomProced);
		clsProcedimento proced = new clsProcedimento();
		if (!lstProced.isEmpty()) {
			proced = lstProced.get(0);
			codProced = proced.getCodProcedimento();
		}
		Long codClinica = new Long(0);
		Long codMedico = new Long(0);
		clsClinica clinica = new clsClinica();
		clsMedico med = new clsMedico();
		SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
		String strSql = "SELECT * FROM TBL_SOLICITACAO WHERE COD_SOLICITACAO = " + solicitaSel;
		List<clsSolicitacao> lstSolicita = solicitaDAO.buscaSQL(strSql);
		clsSolicitacao solicita = new clsSolicitacao();
		if (!lstSolicita.isEmpty()) {
			solicita = lstSolicita.get(0);
			clinica = solicita.getTblClinica();
			codClinica = clinica.getCodClinica();
			med = solicita.getTblMedico();
			codMedico = med.getCodMedico();
		}
		Long codSolicita = new Long(0);
		strSql = "SELECT * FROM TBL_SOLICITACAO WHERE COD_PROCEDIMENTO = " + codProced + " AND COD_CLINICA = " + codClinica + " AND COD_MEDICO = " + codMedico;
		lstSolicita = solicitaDAO.buscaSQL(strSql);
		for (Iterator<clsSolicitacao> iterator = lstSolicita.iterator(); iterator.hasNext();) {
			solicita = (clsSolicitacao) iterator.next();
			codSolicita = solicita.getCodSolicitacao();
			AgendamentoDAO agendaDAO = new AgendamentoDAO();
			strSql = "SELECT * FROM TBL_AGENDAMENTO WHERE COD_SOLICITACAO = " + codSolicita;
			List<clsAgendamento> lstAgenda = agendaDAO.buscaSQL(strSql);
			if (!lstAgenda.isEmpty()) {
				clsAgendamento agenda = lstAgenda.get(0);
				Date dataExecucaoAgenda = agenda.getData_Execucao();
				String horaExecucaoAgenda = agenda.getHora_Execucao();
				if (dataExecucaoAgenda != null && horaExecucaoAgenda != null) {
					if (dataExecucaoAgenda.equals(dataExecucao) && horaExecucaoAgenda.equals(horaExecucao)) {
						msgRet = "Já existe o mesmo Procedimento Executado nessa mesma Clínica por esse mesmo Médico nessa mesma Data e Hora!";
					}
				}
			}
		}
		return msgRet;
	}
	
}

package bean;

import java.util.ArrayList;
import java.util.List;

import model.clsAutorizacaoNegada;
import dao.AutorizacaoNegadaDAO;

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

@ManagedBean
public class AutorizacaoNegadaBean {
	private AutorizacaoNegadaDAO autorizaNegDAO = new AutorizacaoNegadaDAO();
	private clsAutorizacaoNegada itemSelecionado;
	private List<clsAutorizacaoNegada> listaItens;
	
	public AutorizacaoNegadaBean() {
		listaItens = autorizaNegDAO.listaTodos();
	}

	public List<clsAutorizacaoNegada> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsAutorizacaoNegada> listaItens) {
		this.listaItens = listaItens;
	}

	public clsAutorizacaoNegada getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsAutorizacaoNegada itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public String negarAutorizacao(BigDecimal numCartao, String nomProced, String nomClinica, String nomAtendente, String nomMedico, Date dataRealiza, String horaRealiza, Double preco) {
		SolicitacaoDAO daoSolicita = new SolicitacaoDAO();
		clsSolicitacao tabSolicita = new clsSolicitacao();
		tabSolicita.setContingencia("N");
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
		
		AutorizacaoNegadaDAO daoAutorizaNeg = new AutorizacaoNegadaDAO();
		clsAutorizacaoNegada tabAutorizaNeg = new clsAutorizacaoNegada();
		tabAutorizaNeg.setData(dataRealiza);
		tabAutorizaNeg.setHora(horaRealiza);
		tabAutorizaNeg.setTblSolicitacao(tabSolicita);

		List<clsAutorizacaoNegada> lstAutorizaNeg = new ArrayList<clsAutorizacaoNegada>();
		lstAutorizaNeg.add(tabAutorizaNeg);
		tabSolicita.setTblAutorizacaos(null);
		tabSolicita.setTblAgendamentos(null);
		tabSolicita.setTblAutorizacaoNegadas(lstAutorizaNeg);

		try {
			daoSolicita.salvar(tabSolicita);
			daoAutorizaNeg.salvar(tabAutorizaNeg);
			return "";
		}
		catch (ConstraintViolationException e) {
			return "Erro na Inclusão da Autorização Negada: Violação de Restrição do Banco de Dados!";
		}
		catch (Exception e) {
			return "Erro na Inclusão da Autorização Negada: " + e.getMessage();
		}
	}
	
}

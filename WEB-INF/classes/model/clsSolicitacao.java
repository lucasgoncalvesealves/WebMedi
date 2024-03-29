package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TBL_SOLICITACAO database table.
 * 
 */
@Entity
@Table(name="TBL_SOLICITACAO")
@NamedQuery(name="clsSolicitacao.findAll", query="SELECT c FROM clsSolicitacao c")
public class clsSolicitacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_SOLICITACAO_CODSOLICITACAO_GENERATOR", sequenceName="SEQ_TBL_SOLICITACAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_SOLICITACAO_CODSOLICITACAO_GENERATOR")
	@Column(name="COD_SOLICITACAO")
	private long codSolicitacao;

	private String contingencia;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA_PAGTO_CONTING\"")
	private Date dataPagtoContingencia;
	
	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA\"")
	private Date data;

	//private double horario;

	private String hora;

	private double preco;

	//bi-directional many-to-one association to clsAgendamento
	@OneToMany(mappedBy="tblSolicitacao")
	private List<clsAgendamento> tblAgendamentos;

	//bi-directional many-to-one association to clsAutorizacao
	@OneToMany(mappedBy="tblSolicitacao")
	private List<clsAutorizacao> tblAutorizacaos;

	//bi-directional many-to-one association to clsAutorizacaoNegada
	@OneToMany(mappedBy="tblSolicitacao")
	private List<clsAutorizacaoNegada> tblAutorizacaoNegadas;

	//bi-directional many-to-one association to clsAtendente
	@ManyToOne
	@JoinColumn(name="COD_ATENDENTE")
	private clsAtendente tblAtendente;

	//bi-directional many-to-one association to clsCliente
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE")
	private clsCliente tblCliente;

	//bi-directional many-to-one association to clsClinica
	@ManyToOne
	@JoinColumn(name="COD_CLINICA")
	private clsClinica tblClinica;

	//bi-directional many-to-one association to clsMedico
	@ManyToOne
	@JoinColumn(name="COD_MEDICO")
	private clsMedico tblMedico;

	//bi-directional many-to-one association to clsProcedimento
	@ManyToOne
	@JoinColumn(name="COD_PROCEDIMENTO")
	private clsProcedimento tblProcedimento;
	
	public clsSolicitacao() {
	}

	public long getCodSolicitacao() {
		return this.codSolicitacao;
	}

	public void setCodSolicitacao(long codSolicitacao) {
		this.codSolicitacao = codSolicitacao;
	}

	public String getContingencia() {
		return this.contingencia;
	}

	public void setContingencia(String contingencia) {
		this.contingencia = contingencia;
	}

	public Date getDataPagtoContingencia() {
		return this.dataPagtoContingencia;
	}

	public void setDataPagtoContingencia(Date dataPagtoContingencia) {
		this.dataPagtoContingencia = dataPagtoContingencia;
	}
	
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	//public double getHorario() {
	//	return this.horario;
	//}

	//public void setHorario(double horario) {
	//	this.horario = horario;
	//}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public double getPreco() {
		return this.preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<clsAgendamento> getTblAgendamentos() {
		return this.tblAgendamentos;
	}

	public void setTblAgendamentos(List<clsAgendamento> tblAgendamentos) {
		this.tblAgendamentos = tblAgendamentos;
	}

	public clsAgendamento addTblAgendamento(clsAgendamento tblAgendamento) {
		getTblAgendamentos().add(tblAgendamento);
		tblAgendamento.setTblSolicitacao(this);

		return tblAgendamento;
	}

	public clsAgendamento removeTblAgendamento(clsAgendamento tblAgendamento) {
		getTblAgendamentos().remove(tblAgendamento);
		tblAgendamento.setTblSolicitacao(null);

		return tblAgendamento;
	}

	public List<clsAutorizacao> getTblAutorizacaos() {
		return this.tblAutorizacaos;
	}

	public void setTblAutorizacaos(List<clsAutorizacao> tblAutorizacaos) {
		this.tblAutorizacaos = tblAutorizacaos;
	}

	public clsAutorizacao addTblAutorizacao(clsAutorizacao tblAutorizacao) {
		getTblAutorizacaos().add(tblAutorizacao);
		tblAutorizacao.setTblSolicitacao(this);

		return tblAutorizacao;
	}

	public clsAutorizacao removeTblAutorizacao(clsAutorizacao tblAutorizacao) {
		getTblAutorizacaos().remove(tblAutorizacao);
		tblAutorizacao.setTblSolicitacao(null);

		return tblAutorizacao;
	}

	public List<clsAutorizacaoNegada> getTblAutorizacaoNegadas() {
		return this.tblAutorizacaoNegadas;
	}

	public void setTblAutorizacaoNegadas(List<clsAutorizacaoNegada> tblAutorizacaoNegadas) {
		this.tblAutorizacaoNegadas = tblAutorizacaoNegadas;
	}

	public clsAutorizacaoNegada addTblAutorizacaoNegada(clsAutorizacaoNegada tblAutorizacaoNegada) {
		getTblAutorizacaoNegadas().add(tblAutorizacaoNegada);
		tblAutorizacaoNegada.setTblSolicitacao(this);

		return tblAutorizacaoNegada;
	}

	public clsAutorizacaoNegada removeTblAutorizacaoNegada(clsAutorizacaoNegada tblAutorizacaoNegada) {
		getTblAutorizacaoNegadas().remove(tblAutorizacaoNegada);
		tblAutorizacaoNegada.setTblSolicitacao(null);

		return tblAutorizacaoNegada;
	}

	public clsAtendente getTblAtendente() {
		return this.tblAtendente;
	}

	public void setTblAtendente(clsAtendente tblAtendente) {
		this.tblAtendente = tblAtendente;
	}

	public clsCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(clsCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

	public clsClinica getTblClinica() {
		return this.tblClinica;
	}

	public void setTblClinica(clsClinica tblClinica) {
		this.tblClinica = tblClinica;
	}

	public clsMedico getTblMedico() {
		return this.tblMedico;
	}

	public void setTblMedico(clsMedico tblMedico) {
		this.tblMedico = tblMedico;
	}

	public clsProcedimento getTblProcedimento() {
		return this.tblProcedimento;
	}

	public void setTblProcedimento(clsProcedimento tblProcedimento) {
		this.tblProcedimento = tblProcedimento;
	}
	
}

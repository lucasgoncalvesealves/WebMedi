package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TBL_AUTORIZACAO database table.
 * 
 */
@Entity
@Table(name="TBL_AUTORIZACAO")
@NamedQuery(name="clsAutorizacao.findAll", query="SELECT c FROM clsAutorizacao c")
public class clsAutorizacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_AUTORIZACAO_CODAUTORIZACAO_GENERATOR", sequenceName="SEQ_TBL_AUTORIZACAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_AUTORIZACAO_CODAUTORIZACAO_GENERATOR")
	@Column(name="COD_AUTORIZACAO")
	private long codAutorizacao;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA\"")
	private Date data;
	
	private String hora;

	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA_CANCELAMENTO\"")
	private Date data_cancelamento;

	private String hora_cancelamento;
	
	//bi-directional many-to-one association to clsSolicitacao
	@ManyToOne
	@JoinColumn(name="COD_SOLICITACAO")
	private clsSolicitacao tblSolicitacao;

	//bi-directional many-to-one association to clsPrevisaoPagamento
	@OneToMany(mappedBy="tblAutorizacao")
	private List<clsPrevisaoPagamento> tblPrevisaoPagamentos;

	public clsAutorizacao() {
	}

	public long getCodAutorizacao() {
		return this.codAutorizacao;
	}

	public void setCodAutorizacao(long codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public clsSolicitacao getTblSolicitacao() {
		return this.tblSolicitacao;
	}

	public void setTblSolicitacao(clsSolicitacao tblSolicitacao) {
		this.tblSolicitacao = tblSolicitacao;
	}

	public List<clsPrevisaoPagamento> getTblPrevisaoPagamentos() {
		return this.tblPrevisaoPagamentos;
	}

	public void setTblPrevisaoPagamentos(List<clsPrevisaoPagamento> tblPrevisaoPagamentos) {
		this.tblPrevisaoPagamentos = tblPrevisaoPagamentos;
	}

	public clsPrevisaoPagamento addTblPrevisaoPagamento(clsPrevisaoPagamento tblPrevisaoPagamento) {
		getTblPrevisaoPagamentos().add(tblPrevisaoPagamento);
		tblPrevisaoPagamento.setTblAutorizacao(this);

		return tblPrevisaoPagamento;
	}

	public clsPrevisaoPagamento removeTblPrevisaoPagamento(clsPrevisaoPagamento tblPrevisaoPagamento) {
		getTblPrevisaoPagamentos().remove(tblPrevisaoPagamento);
		tblPrevisaoPagamento.setTblAutorizacao(null);

		return tblPrevisaoPagamento;
	}
	
	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData_Cancelamento() {
		return this.data_cancelamento;
	}

	public void setData_Cancelamento(Date data_cancelamento) {
		this.data_cancelamento = data_cancelamento;
	}
	
	public String getHora_Cancelamento() {
		return this.hora_cancelamento;
	}

	public void setHora_Cancelamento(String hora_cancelamento) {
		this.hora_cancelamento = hora_cancelamento;
	}
	
}
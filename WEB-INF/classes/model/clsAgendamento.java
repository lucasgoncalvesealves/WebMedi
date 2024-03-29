package model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the TBL_AGENDAMENTO database table.
 * 
 */
@Entity
@Table(name="TBL_AGENDAMENTO")
@NamedQuery(name="clsAgendamento.findAll", query="SELECT c FROM clsAgendamento c")
public class clsAgendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_AGENDAMENTO_CODAGENDAMENTO_GENERATOR", sequenceName="SEQ_TBL_AGENDAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_AGENDAMENTO_CODAGENDAMENTO_GENERATOR")
	@Column(name="COD_AGENDAMENTO")
	private long codAgendamento;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA\"")
	private Date data;

	private String hora;
	
	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA_EXECUCAO\"")
	private Date data_execucao;

	private String hora_execucao;

	//bi-directional many-to-one association to clsSolicitacao
	@ManyToOne
	@JoinColumn(name="COD_SOLICITACAO")
	private clsSolicitacao tblSolicitacao;

	public clsAgendamento() {
	}

	public long getCodAgendamento() {
		return this.codAgendamento;
	}

	public void setCodAgendamento(long codAgendamento) {
		this.codAgendamento = codAgendamento;
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

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Date getData_Execucao() {
		return this.data_execucao;
	}

	public void setData_Execucao(Date data_execucao) {
		this.data_execucao = data_execucao;
	}

	public String getHora_Execucao() {
		return this.hora_execucao;
	}

	public void setHora_Execucao(String hora_execucao) {
		this.hora_execucao = hora_execucao;
	}
	
}
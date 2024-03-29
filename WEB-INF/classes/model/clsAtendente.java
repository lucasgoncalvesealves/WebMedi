package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TBL_ATENDENTE database table.
 * 
 */
@Entity
@Table(name="TBL_ATENDENTE")
@NamedQuery(name="clsAtendente.findAll", query="SELECT c FROM clsAtendente c")
public class clsAtendente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_ATENDENTE_CODATENDENTE_GENERATOR", sequenceName="SEQ_TBL_ATENDENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_ATENDENTE_CODATENDENTE_GENERATOR")
	@Column(name="COD_ATENDENTE")
	private long codAtendente;

	private BigDecimal cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNasc;

	private String endereco;

	private BigDecimal matricula;

	private String nome;

	private String sexo;

	private BigDecimal telefone;

	//bi-directional many-to-one association to clsClinica
	@ManyToOne
	@JoinColumn(name="COD_CLINICA")
	private clsClinica tblClinica;

	//bi-directional many-to-one association to clsSolicitacao
	@OneToMany(mappedBy="tblAtendente")
	private List<clsSolicitacao> tblSolicitacaos;

	public clsAtendente() {
	}

	public long getCodAtendente() {
		return this.codAtendente;
	}

	public void setCodAtendente(long codAtendente) {
		this.codAtendente = codAtendente;
	}

	public BigDecimal getCpf() {
		return this.cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getMatricula() {
		return this.matricula;
	}

	public void setMatricula(BigDecimal matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getTelefone() {
		return this.telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}

	public clsClinica getTblClinica() {
		return this.tblClinica;
	}

	public void setTblClinica(clsClinica tblClinica) {
		this.tblClinica = tblClinica;
	}

	public List<clsSolicitacao> getTblSolicitacaos() {
		return this.tblSolicitacaos;
	}

	public void setTblSolicitacaos(List<clsSolicitacao> tblSolicitacaos) {
		this.tblSolicitacaos = tblSolicitacaos;
	}

	public clsSolicitacao addTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().add(tblSolicitacao);
		tblSolicitacao.setTblAtendente(this);

		return tblSolicitacao;
	}

	public clsSolicitacao removeTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().remove(tblSolicitacao);
		tblSolicitacao.setTblAtendente(null);

		return tblSolicitacao;
	}

}
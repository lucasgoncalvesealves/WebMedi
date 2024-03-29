package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the TBL_CLINICA database table.
 * 
 */
@Entity
@Table(name="TBL_CLINICA")
@NamedQuery(name="clsClinica.findAll", query="SELECT c FROM clsClinica c")
public class clsClinica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_CLINICA_CODCLINICA_GENERATOR", sequenceName="SEQ_TBL_CLINICA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_CLINICA_CODCLINICA_GENERATOR")
	@Column(name="COD_CLINICA")
	private long codClinica;

	private BigDecimal cnpj;

	private String contingencia;

	private String endereco;

	private String nome;

	private BigDecimal telefone;

	//bi-directional many-to-one association to clsAtendente
	@OneToMany(mappedBy="tblClinica")
	private List<clsAtendente> tblAtendentes;

	//bi-directional many-to-one association to clsSolicitacao
	@OneToMany(mappedBy="tblClinica")
	private List<clsSolicitacao> tblSolicitacaos;

	public clsClinica() {
	}

	public long getCodClinica() {
		return this.codClinica;
	}

	public void setCodClinica(long codClinica) {
		this.codClinica = codClinica;
	}

	public BigDecimal getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(BigDecimal cnpj) {
		this.cnpj = cnpj;
	}

	public String getContingencia() {
		return this.contingencia;
	}

	public void setContingencia(String contingencia) {
		this.contingencia = contingencia;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTelefone() {
		return this.telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}

	public List<clsAtendente> getTblAtendentes() {
		return this.tblAtendentes;
	}

	public void setTblAtendentes(List<clsAtendente> tblAtendentes) {
		this.tblAtendentes = tblAtendentes;
	}

	public clsAtendente addTblAtendente(clsAtendente tblAtendente) {
		getTblAtendentes().add(tblAtendente);
		tblAtendente.setTblClinica(this);

		return tblAtendente;
	}

	public clsAtendente removeTblAtendente(clsAtendente tblAtendente) {
		getTblAtendentes().remove(tblAtendente);
		tblAtendente.setTblClinica(null);

		return tblAtendente;
	}

	public List<clsSolicitacao> getTblSolicitacaos() {
		return this.tblSolicitacaos;
	}

	public void setTblSolicitacaos(List<clsSolicitacao> tblSolicitacaos) {
		this.tblSolicitacaos = tblSolicitacaos;
	}

	public clsSolicitacao addTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().add(tblSolicitacao);
		tblSolicitacao.setTblClinica(this);

		return tblSolicitacao;
	}

	public clsSolicitacao removeTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().remove(tblSolicitacao);
		tblSolicitacao.setTblClinica(null);

		return tblSolicitacao;
	}

}

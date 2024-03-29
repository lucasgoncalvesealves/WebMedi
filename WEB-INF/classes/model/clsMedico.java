package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TBL_MEDICO database table.
 * 
 */
@Entity
@Table(name="TBL_MEDICO")
@NamedQuery(name="clsMedico.findAll", query="SELECT c FROM clsMedico c")
public class clsMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_MEDICO_CODMEDICO_GENERATOR", sequenceName="SEQ_TBL_MEDICO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_MEDICO_CODMEDICO_GENERATOR")
	@Column(name="COD_MEDICO")
	private long codMedico;

	private BigDecimal crm;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNasc;

	private String endereco;

	private BigDecimal matricula;

	private String nome;

	private String sexo;

	private BigDecimal telefone;

	//bi-directional many-to-one association to clsEspecialidade
	@ManyToOne
	@JoinColumn(name="COD_ESPECIALIDADE")
	private clsEspecialidade tblEspecialidade;

	//bi-directional many-to-one association to clsSolicitacao
	@OneToMany(mappedBy="tblMedico")
	private List<clsSolicitacao> tblSolicitacaos;

	public clsMedico() {
	}

	public long getCodMedico() {
		return this.codMedico;
	}

	public void setCodMedico(long codMedico) {
		this.codMedico = codMedico;
	}

	public BigDecimal getCrm() {
		return this.crm;
	}

	public void setCrm(BigDecimal crm) {
		this.crm = crm;
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

	public clsEspecialidade getTblEspecialidade() {
		return this.tblEspecialidade;
	}

	public void setTblEspecialidade(clsEspecialidade tblEspecialidade) {
		this.tblEspecialidade = tblEspecialidade;
	}

	public List<clsSolicitacao> getTblSolicitacaos() {
		return this.tblSolicitacaos;
	}

	public void setTblSolicitacaos(List<clsSolicitacao> tblSolicitacaos) {
		this.tblSolicitacaos = tblSolicitacaos;
	}

	public clsSolicitacao addTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().add(tblSolicitacao);
		tblSolicitacao.setTblMedico(this);

		return tblSolicitacao;
	}

	public clsSolicitacao removeTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().remove(tblSolicitacao);
		tblSolicitacao.setTblMedico(null);

		return tblSolicitacao;
	}

}
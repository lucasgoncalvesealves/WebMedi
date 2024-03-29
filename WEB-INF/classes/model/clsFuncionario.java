package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TBL_FUNCIONARIO database table.
 * 
 */
@Entity
@Table(name="TBL_FUNCIONARIO")
@NamedQuery(name="clsFuncionario.findAll", query="SELECT c FROM clsFuncionario c")
public class clsFuncionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_FUNCIONARIO_CODFUNCIONARIO_GENERATOR", sequenceName="SEQ_TBL_FUNCIONARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_FUNCIONARIO_CODFUNCIONARIO_GENERATOR")
	@Column(name="COD_FUNCIONARIO")
	private long codFuncionario;

	private BigDecimal cfp;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNasc;

	private String funcao;

	private String nome;

	private String sexo;

	private BigDecimal telefone;

	//bi-directional many-to-one association to clsDepartamento
	@ManyToOne
	@JoinColumn(name="COD_DEPARTAMENTO")
	private clsDepartamento tblDepartamento;

	public clsFuncionario() {
	}

	public long getCodFuncionario() {
		return this.codFuncionario;
	}

	public void setCodFuncionario(long codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public BigDecimal getCfp() {
		return this.cfp;
	}

	public void setCfp(BigDecimal cfp) {
		this.cfp = cfp;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getFuncao() {
		return this.funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
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

	public clsDepartamento getTblDepartamento() {
		return this.tblDepartamento;
	}

	public void setTblDepartamento(clsDepartamento tblDepartamento) {
		this.tblDepartamento = tblDepartamento;
	}

}
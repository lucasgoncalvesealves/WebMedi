package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the TBL_PROCEDIMENTO database table.
 * 
 */
@Entity
@Table(name="TBL_PROCEDIMENTO")
@NamedQuery(name="clsProcedimento.findAll", query="SELECT c FROM clsProcedimento c")
public class clsProcedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_PROCEDIMENTO_CODPROCEDIMENTO_GENERATOR", sequenceName="SEQ_TBL_PROCEDIMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_PROCEDIMENTO_CODPROCEDIMENTO_GENERATOR")
	@Column(name="COD_PROCEDIMENTO")
	private long codProcedimento;

	private String nome;

	private BigDecimal valor;

	//bi-directional many-to-one association to clsEspecialidade
	@ManyToOne
	@JoinColumn(name="COD_ESPECIALIDADE")
	private clsEspecialidade tblEspecialidade;

	public clsProcedimento() {
	}

	public long getCodProcedimento() {
		return this.codProcedimento;
	}

	public void setCodProcedimento(long codProcedimento) {
		this.codProcedimento = codProcedimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public clsEspecialidade getTblEspecialidade() {
		return this.tblEspecialidade;
	}

	public void setTblEspecialidade(clsEspecialidade tblEspecialidade) {
		this.tblEspecialidade = tblEspecialidade;
	}

}

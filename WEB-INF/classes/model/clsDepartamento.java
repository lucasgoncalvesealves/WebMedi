package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TBL_DEPARTAMENTO database table.
 * 
 */
@Entity
@Table(name="TBL_DEPARTAMENTO")
@NamedQuery(name="clsDepartamento.findAll", query="SELECT c FROM clsDepartamento c")
public class clsDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_DEPARTAMENTO_CODDEPARTAMENTO_GENERATOR", sequenceName="SEQ_TBL_DEPARTAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_DEPARTAMENTO_CODDEPARTAMENTO_GENERATOR")
	@Column(name="COD_DEPARTAMENTO")
	private long codDepartamento;

	private String descricao;

	//bi-directional many-to-one association to clsFuncionario
	@OneToMany(mappedBy="tblDepartamento")
	private List<clsFuncionario> tblFuncionarios;

	public clsDepartamento() {
	}

	public long getCodDepartamento() {
		return this.codDepartamento;
	}

	public void setCodDepartamento(long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<clsFuncionario> getTblFuncionarios() {
		return this.tblFuncionarios;
	}

	public void setTblFuncionarios(List<clsFuncionario> tblFuncionarios) {
		this.tblFuncionarios = tblFuncionarios;
	}

	public clsFuncionario addTblFuncionario(clsFuncionario tblFuncionario) {
		getTblFuncionarios().add(tblFuncionario);
		tblFuncionario.setTblDepartamento(this);

		return tblFuncionario;
	}

	public clsFuncionario removeTblFuncionario(clsFuncionario tblFuncionario) {
		getTblFuncionarios().remove(tblFuncionario);
		tblFuncionario.setTblDepartamento(null);

		return tblFuncionario;
	}

}
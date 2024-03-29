package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_ESPECIALIDADE database table.
 * 
 */
@Entity
@Table(name="TBL_ESPECIALIDADE")
public class clsEspecialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_ESPECIALIDADE_CODESPECIALIDADE_GENERATOR", sequenceName="SEQ_TBL_ESPECIALIDADE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_ESPECIALIDADE_CODESPECIALIDADE_GENERATOR")
	@Column(name="COD_ESPECIALIDADE")
	private long codEspecialidade;

	private String descricao;

	public clsEspecialidade() {
	}

	public long getCodEspecialidade() {
		return this.codEspecialidade;
	}

	public void setCodEspecialidade(long codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

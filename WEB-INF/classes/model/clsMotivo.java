package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TBL_MOTIVO database table.
 * 
 */
@Entity
@Table(name="TBL_MOTIVO")
@NamedQuery(name="clsMotivo.findAll", query="SELECT c FROM clsMotivo c")
public class clsMotivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_MOTIVO_CODMOTIVO_GENERATOR", sequenceName="SEQ_TBL_MOTIVO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_MOTIVO_CODMOTIVO_GENERATOR")
	@Column(name="COD_MOTIVO")
	private long codMotivo;

	private String descricao;

	public clsMotivo() {
	}

	public long getCodMotivo() {
		return this.codMotivo;
	}

	public void setCodMotivo(long codMotivo) {
		this.codMotivo = codMotivo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
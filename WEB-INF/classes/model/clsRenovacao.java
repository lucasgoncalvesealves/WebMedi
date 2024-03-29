package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TBL_RENOVACAO database table.
 * 
 */
@Entity
@Table(name="TBL_RENOVACAO")
@NamedQuery(name="clsRenovacao.findAll", query="SELECT c FROM clsRenovacao c")
public class clsRenovacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_RENOVACAO_CODRENOVACAO_GENERATOR", sequenceName="SEQ_TBL_RENOVACAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_RENOVACAO_CODRENOVACAO_GENERATOR")
	@Column(name="COD_RENOVACAO")
	private long codRenovacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_RENOVACAO")
	private Date dataRenovacao;

	private String descricao;

	//bi-directional many-to-one association to clsContrato
	@ManyToOne
	@JoinColumn(name="COD_CONTRATO")
	private clsContrato tblContrato;

	public clsRenovacao() {
	}

	public long getCodRenovacao() {
		return this.codRenovacao;
	}

	public void setCodRenovacao(long codRenovacao) {
		this.codRenovacao = codRenovacao;
	}

	public Date getDataRenovacao() {
		return this.dataRenovacao;
	}

	public void setDataRenovacao(Date dataRenovacao) {
		this.dataRenovacao = dataRenovacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public clsContrato getTblContrato() {
		return this.tblContrato;
	}

	public void setTblContrato(clsContrato tblContrato) {
		this.tblContrato = tblContrato;
	}

}
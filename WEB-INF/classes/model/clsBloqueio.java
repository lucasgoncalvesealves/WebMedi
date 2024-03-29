package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TBL_BLOQUEIO database table.
 * 
 */
@Entity
@Table(name="TBL_BLOQUEIO")
@NamedQuery(name="clsBloqueio.findAll", query="SELECT c FROM clsBloqueio c")
public class clsBloqueio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_BLOQUEIO_CODBLOQUEIO_GENERATOR", sequenceName="SEQ_TBL_BLOQUEIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_BLOQUEIO_CODBLOQUEIO_GENERATOR")
	@Column(name="COD_BLOQUEIO")
	private long codBloqueio;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_BLOQUEIO")
	private Date dataBloqueio;

	private String descricao;

	//bi-directional many-to-one association to clsContrato
	@ManyToOne
	@JoinColumn(name="COD_CONTRATO")
	private clsContrato tblContrato;

	public clsBloqueio() {
	}

	public long getCodBloqueio() {
		return this.codBloqueio;
	}

	public void setCodBloqueio(long codBloqueio) {
		this.codBloqueio = codBloqueio;
	}

	public Date getDataBloqueio() {
		return this.dataBloqueio;
	}

	public void setDataBloqueio(Date dataBloqueio) {
		this.dataBloqueio = dataBloqueio;
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
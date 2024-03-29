package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TBL_CONTRATO database table.
 * 
 */
@Entity
@Table(name="TBL_CONTRATO")
@NamedQuery(name="clsContrato.findAll", query="SELECT c FROM clsContrato c")
public class clsContrato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_CONTRATO_CODCONTRATO_GENERATOR", sequenceName="SEQ_TBL_CONTRATO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_CONTRATO_CODCONTRATO_GENERATOR")
	@Column(name="COD_CONTRATO")
	private long codContrato;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_VENC")
	private Date dataVenc;

	//bi-directional many-to-one association to clsBloqueio
	@OneToMany(mappedBy="tblContrato")
	private List<clsBloqueio> tblBloqueios;

	//bi-directional many-to-one association to clsBoleto
	@OneToMany(mappedBy="tblContrato")
	private List<clsBoleto> tblBoletos;

	//bi-directional many-to-one association to clsCliente
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE")
	private clsCliente tblCliente;

	//bi-directional many-to-one association to clsRenovacao
	@OneToMany(mappedBy="tblContrato")
	private List<clsRenovacao> tblRenovacaos;

	public clsContrato() {
	}

	public long getCodContrato() {
		return this.codContrato;
	}

	public void setCodContrato(long codContrato) {
		this.codContrato = codContrato;
	}

	public Date getDataVenc() {
		return this.dataVenc;
	}

	public void setDataVenc(Date dataVenc) {
		this.dataVenc = dataVenc;
	}

	public List<clsBloqueio> getTblBloqueios() {
		return this.tblBloqueios;
	}

	public void setTblBloqueios(List<clsBloqueio> tblBloqueios) {
		this.tblBloqueios = tblBloqueios;
	}

	public clsBloqueio addTblBloqueio(clsBloqueio tblBloqueio) {
		getTblBloqueios().add(tblBloqueio);
		tblBloqueio.setTblContrato(this);

		return tblBloqueio;
	}

	public clsBloqueio removeTblBloqueio(clsBloqueio tblBloqueio) {
		getTblBloqueios().remove(tblBloqueio);
		tblBloqueio.setTblContrato(null);

		return tblBloqueio;
	}

	public List<clsBoleto> getTblBoletos() {
		return this.tblBoletos;
	}

	public void setTblBoletos(List<clsBoleto> tblBoletos) {
		this.tblBoletos = tblBoletos;
	}

	public clsBoleto addTblBoleto(clsBoleto tblBoleto) {
		getTblBoletos().add(tblBoleto);
		tblBoleto.setTblContrato(this);

		return tblBoleto;
	}

	public clsBoleto removeTblBoleto(clsBoleto tblBoleto) {
		getTblBoletos().remove(tblBoleto);
		tblBoleto.setTblContrato(null);

		return tblBoleto;
	}

	public clsCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(clsCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

	public List<clsRenovacao> getTblRenovacaos() {
		return this.tblRenovacaos;
	}

	public void setTblRenovacaos(List<clsRenovacao> tblRenovacaos) {
		this.tblRenovacaos = tblRenovacaos;
	}

	public clsRenovacao addTblRenovacao(clsRenovacao tblRenovacao) {
		getTblRenovacaos().add(tblRenovacao);
		tblRenovacao.setTblContrato(this);

		return tblRenovacao;
	}

	public clsRenovacao removeTblRenovacao(clsRenovacao tblRenovacao) {
		getTblRenovacaos().remove(tblRenovacao);
		tblRenovacao.setTblContrato(null);

		return tblRenovacao;
	}

}
package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TBL_AUTORIZACAO_NEGADA database table.
 * 
 */
@Entity
@Table(name="TBL_AUTORIZACAO_NEGADA")
@NamedQuery(name="clsAutorizacaoNegada.findAll", query="SELECT c FROM clsAutorizacaoNegada c")
public class clsAutorizacaoNegada implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_AUTORIZACAO_NEGADA_CODAUTORIZACAONEGADA_GENERATOR", sequenceName="SEQ_TBL_AUTORIZACAO_NEGADA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_AUTORIZACAO_NEGADA_CODAUTORIZACAONEGADA_GENERATOR")
	@Column(name="COD_AUTORIZACAO_NEGADA")
	private long codAutorizacaoNegada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA\"")
	private Date data;
	
	private String hora;

	@Column(name="COD_MOTIVO")
	private BigDecimal codMotivo;

	//bi-directional many-to-one association to clsSolicitacao
	@ManyToOne
	@JoinColumn(name="COD_SOLICITACAO")
	private clsSolicitacao tblSolicitacao;

	public clsAutorizacaoNegada() {
	}

	public long getCodAutorizacaoNegada() {
		return this.codAutorizacaoNegada;
	}

	public void setCodAutorizacaoNegada(long codAutorizacaoNegada) {
		this.codAutorizacaoNegada = codAutorizacaoNegada;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public BigDecimal getCodMotivo() {
		return this.codMotivo;
	}

	public void setCodMotivo(BigDecimal codMotivo) {
		this.codMotivo = codMotivo;
	}

	public clsSolicitacao getTblSolicitacao() {
		return this.tblSolicitacao;
	}

	public void setTblSolicitacao(clsSolicitacao tblSolicitacao) {
		this.tblSolicitacao = tblSolicitacao;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
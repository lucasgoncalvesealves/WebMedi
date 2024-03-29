package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TBL_MOVIMENTACAO database table.
 * 
 */
@Entity
@Table(name="TBL_MOVIMENTACAO")
@NamedQuery(name="clsMovimentacao.findAll", query="SELECT c FROM clsMovimentacao c")
public class clsMovimentacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_MOVIMENTACAO_CODMOVIMENTACAO_GENERATOR", sequenceName="SEQ_TBL_MOVIMENTACAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_MOVIMENTACAO_CODMOVIMENTACAO_GENERATOR")
	@Column(name="COD_MOVIMENTACAO")
	private long codMovimentacao;

	private BigDecimal credito;

	private BigDecimal debito;

	@Temporal(TemporalType.DATE)
	@Column(name="\"DATA_MOVIMENTACAO\"")
	private Date data;
	
	//private BigDecimal saldo;

	//bi-directional many-to-one association to clsAutorizacao
	@ManyToOne
	@JoinColumn(name="COD_AUTORIZACAO")
	private clsAutorizacao tblAutorizacao;
	
	//bi-directional many-to-one association to clsContrato
	@ManyToOne
	@JoinColumn(name="COD_CONTRATO")
	private clsContrato tblContrato;

	public clsMovimentacao() {
	}

	public long getCodMovimentacao() {
		return this.codMovimentacao;
	}

	public void setCodMovimentacao(long codMovimentacao) {
		this.codMovimentacao = codMovimentacao;
	}

	public BigDecimal getCredito() {
		return this.credito;
	}

	public void setCredito(BigDecimal credito) {
		this.credito = credito;
	}

	public BigDecimal getDebito() {
		return this.debito;
	}

	public void setDebito(BigDecimal debito) {
		this.debito = debito;
	}
	
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	//public BigDecimal getSaldo() {
	//	return this.saldo;
	//}

	//public void setSaldo(BigDecimal saldo) {
	//	this.saldo = saldo;
	//}

	public clsAutorizacao getTblAutorizacao() {
		return this.tblAutorizacao;
	}

	public void setTblAutorizacao(clsAutorizacao tblAutorizacao) {
		this.tblAutorizacao = tblAutorizacao;
	}
	
	public clsContrato getTblContrato() {
		return this.tblContrato;
	}

	public void setTblContrato(clsContrato tblContrato) {
		this.tblContrato = tblContrato;
	}

}

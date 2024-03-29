package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TBL_BOLETO database table.
 * 
 */
@Entity
@Table(name="TBL_BOLETO")
@NamedQuery(name="clsBoleto.findAll", query="SELECT c FROM clsBoleto c")
public class clsBoleto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_BOLETO_CODBOLETO_GENERATOR", sequenceName="SEQ_TBL_BOLETO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_BOLETO_CODBOLETO_GENERATOR")
	@Column(name="COD_BOLETO")
	private long codBoleto;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_CADASTRO")
	private Date dataCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PAGAMENTO")
	private Date dataPagamento;

	private String tipo;

	private double valor;

	//bi-directional many-to-one association to clsCliente
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE")
	private clsCliente tblCliente;

	//bi-directional many-to-one association to clsContrato
	@ManyToOne
	@JoinColumn(name="COD_CONTRATO")
	private clsContrato tblContrato;

	public clsBoleto() {
	}

	public long getCodBoleto() {
		return this.codBoleto;
	}

	public void setCodBoleto(long codBoleto) {
		this.codBoleto = codBoleto;
	}

	public Date getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public clsCliente getTblCliente() {
		return this.tblCliente;
	}

	public void setTblCliente(clsCliente tblCliente) {
		this.tblCliente = tblCliente;
	}

	public clsContrato getTblContrato() {
		return this.tblContrato;
	}

	public void setTblContrato(clsContrato tblContrato) {
		this.tblContrato = tblContrato;
	}

}
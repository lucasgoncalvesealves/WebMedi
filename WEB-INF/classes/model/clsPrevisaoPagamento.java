package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the TBL_PREVISAO_PAGAMENTO database table.
 * 
 */
@Entity
@Table(name="TBL_PREVISAO_PAGAMENTO")
@NamedQuery(name="clsPrevisaoPagamento.findAll", query="SELECT c FROM clsPrevisaoPagamento c")
public class clsPrevisaoPagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_PREVISAO_PAGAMENTO_CODPREVISAOPAGAMENTO_GENERATOR", sequenceName="SEQ_TBL_PREVISAO_PAGAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_PREVISAO_PAGAMENTO_CODPREVISAOPAGAMENTO_GENERATOR")
	@Column(name="COD_PREVISAO_PAGAMENTO")
	private long codPrevisaoPagamento;

	@Column(name="COD_FUNCIONARIO")
	private BigDecimal codFuncionario;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PAGAMENTO")
	private Date dataPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_PREVISTA")
	private Date dataPrevista;

	@Column(name="VALOR_PREVISTO")
	private double valorPrevisto;

	//bi-directional many-to-one association to clsAutorizacao
	@ManyToOne
	@JoinColumn(name="COD_AUTORIZACAO")
	private clsAutorizacao tblAutorizacao;

	public clsPrevisaoPagamento() {
	}

	public long getCodPrevisaoPagamento() {
		return this.codPrevisaoPagamento;
	}

	public void setCodPrevisaoPagamento(long codPrevisaoPagamento) {
		this.codPrevisaoPagamento = codPrevisaoPagamento;
	}

	public BigDecimal getCodFuncionario() {
		return this.codFuncionario;
	}

	public void setCodFuncionario(BigDecimal codFuncionario) {
		this.codFuncionario = codFuncionario;
	}

	public Date getDataPagamento() {
		return this.dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataPrevista() {
		return this.dataPrevista;
	}

	public void setDataPrevista(Date dataPrevista) {
		this.dataPrevista = dataPrevista;
	}

	public double getValorPrevisto() {
		return this.valorPrevisto;
	}

	public void setValorPrevisto(double valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}

	public clsAutorizacao getTblAutorizacao() {
		return this.tblAutorizacao;
	}

	public void setTblAutorizacao(clsAutorizacao tblAutorizacao) {
		this.tblAutorizacao = tblAutorizacao;
	}

}
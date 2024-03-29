package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TBL_CLIENTE database table.
 * 
 */
@Entity
@Table(name="TBL_CLIENTE")
@NamedQuery(name="clsCliente.findAll", query="SELECT c FROM clsCliente c")
public class clsCliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TBL_CLIENTE_CODCLIENTE_GENERATOR", sequenceName="SEQ_TBL_CLIENTE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TBL_CLIENTE_CODCLIENTE_GENERATOR")
	@Column(name="COD_CLIENTE")
	private long codCliente;

	private String contingencia;

	private BigDecimal cpf;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_NASC")
	private Date dataNasc;

	private String endereco;

	private BigDecimal matricula;

	private String nome;

	@Column(name="NRO_CARTAO")
	private BigDecimal nroCartao;

	private String sexo;

	private BigDecimal telefone;

	//bi-directional many-to-one association to clsBoleto
	@OneToMany(mappedBy="tblCliente")
	private List<clsBoleto> tblBoletos;

	//bi-directional many-to-one association to clsContrato
	@OneToMany(mappedBy="tblCliente")
	private List<clsContrato> tblContratos;

	//bi-directional many-to-one association to clsSolicitacao
	@OneToMany(mappedBy="tblCliente")
	private List<clsSolicitacao> tblSolicitacaos;

	public clsCliente() {
	}

	public long getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(long codCliente) {
		this.codCliente = codCliente;
	}

	public String getContingencia() {
		return this.contingencia;
	}

	public void setContingencia(String contingencia) {
		this.contingencia = contingencia;
	}

	public BigDecimal getCpf() {
		return this.cpf;
	}

	public void setCpf(BigDecimal cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getMatricula() {
		return this.matricula;
	}

	public void setMatricula(BigDecimal matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getNroCartao() {
		return this.nroCartao;
	}

	public void setNroCartao(BigDecimal nroCartao) {
		this.nroCartao = nroCartao;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public BigDecimal getTelefone() {
		return this.telefone;
	}

	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}

	public List<clsBoleto> getTblBoletos() {
		return this.tblBoletos;
	}

	public void setTblBoletos(List<clsBoleto> tblBoletos) {
		this.tblBoletos = tblBoletos;
	}

	public clsBoleto addTblBoleto(clsBoleto tblBoleto) {
		getTblBoletos().add(tblBoleto);
		tblBoleto.setTblCliente(this);

		return tblBoleto;
	}

	public clsBoleto removeTblBoleto(clsBoleto tblBoleto) {
		getTblBoletos().remove(tblBoleto);
		tblBoleto.setTblCliente(null);

		return tblBoleto;
	}

	public List<clsContrato> getTblContratos() {
		return this.tblContratos;
	}

	public void setTblContratos(List<clsContrato> tblContratos) {
		this.tblContratos = tblContratos;
	}

	public clsContrato addTblContrato(clsContrato tblContrato) {
		getTblContratos().add(tblContrato);
		tblContrato.setTblCliente(this);

		return tblContrato;
	}

	public clsContrato removeTblContrato(clsContrato tblContrato) {
		getTblContratos().remove(tblContrato);
		tblContrato.setTblCliente(null);

		return tblContrato;
	}

	public List<clsSolicitacao> getTblSolicitacaos() {
		return this.tblSolicitacaos;
	}

	public void setTblSolicitacaos(List<clsSolicitacao> tblSolicitacaos) {
		this.tblSolicitacaos = tblSolicitacaos;
	}

	public clsSolicitacao addTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().add(tblSolicitacao);
		tblSolicitacao.setTblCliente(this);

		return tblSolicitacao;
	}

	public clsSolicitacao removeTblSolicitacao(clsSolicitacao tblSolicitacao) {
		getTblSolicitacaos().remove(tblSolicitacao);
		tblSolicitacao.setTblCliente(null);

		return tblSolicitacao;
	}

}

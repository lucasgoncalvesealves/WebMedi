package bean;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import model.clsCliente;
import model.clsContrato;
import model.clsMovimentacao;
import dao.ClienteDAO;
import dao.ContratoDAO;
import dao.MovimentacaoDAO;

@ManagedBean
public class ClienteBean {
	
	private ClienteDAO cliDAO = new ClienteDAO();
	private clsCliente itemSelecionado;
	private List<clsCliente> listaItens;
	
	public ClienteBean() {
		listaItens = cliDAO.listaTodos();
	}

	public List<clsCliente> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsCliente> listaItens) {
		this.listaItens = listaItens;
	}

	public clsCliente getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsCliente itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public String validarDadosConsultaSaldo(BigDecimal numCartao, BigDecimal numCPF) {
		String msgRet = "";
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (lstCli.isEmpty()) {
			msgRet = "Cartão Não Encontrado!";
		}
		else {
			clsCliente cli = lstCli.get(0);
			if (!cli.getCpf().equals(numCPF)) {
				msgRet = "O CPF informado não é o mesmo que está cadastrado para esse Cartão!";
			}
		}
		return msgRet;
	}

	public String consultarSaldo(BigDecimal numCartao, BigDecimal numCPF) {
		Double nSaldo = new Double(0);
		ClienteDAO cliDAO = new ClienteDAO();
		List<clsCliente> lstCli = cliDAO.buscaPorCartao(numCartao);
		if (!lstCli.isEmpty()) {
			clsCliente cli = lstCli.get(0);
			ContratoDAO contraDAO = new ContratoDAO();
			String strSql = "SELECT * FROM TBL_CONTRATO WHERE COD_CLIENTE = " + cli.getCodCliente() + " ORDER BY DATA_VENC DESC";
			List<clsContrato> lstContra = contraDAO.buscaSQL(strSql);
			if (!lstContra.isEmpty()) {
				clsContrato contra = lstContra.get(0);
				Long codContra = contra.getCodContrato();
				MovimentacaoDAO movDAO = new MovimentacaoDAO();
				strSql = "SELECT * FROM TBL_MOVIMENTACAO WHERE COD_CONTRATO = " + codContra;
				List<clsMovimentacao> lstMov = movDAO.buscaSQL(strSql);
				if (!lstMov.isEmpty()) {
					for (Iterator<clsMovimentacao> iterator = lstMov.iterator(); iterator.hasNext();) {
						clsMovimentacao mov = (clsMovimentacao) iterator.next();
						nSaldo = nSaldo + mov.getCredito().doubleValue();
						nSaldo = nSaldo - mov.getDebito().doubleValue();
					}
				}
			}
		}
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String saldoStr = df.format(nSaldo);
		return "Saldo do Cliente: R$ " + saldoStr + ".";
	}
}

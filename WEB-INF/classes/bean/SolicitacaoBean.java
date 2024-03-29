package bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.clsSolicitacao;
import dao.SolicitacaoDAO;

@ManagedBean
public class SolicitacaoBean {
	private SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
	private clsSolicitacao itemSelecionado;
	private List<clsSolicitacao> listaItens;
	
	public SolicitacaoBean() {
		listaItens = solicitaDAO.listaTodos();
	}

	public List<clsSolicitacao> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsSolicitacao> listaItens) {
		this.listaItens = listaItens;
	}

	public clsSolicitacao getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsSolicitacao itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

}

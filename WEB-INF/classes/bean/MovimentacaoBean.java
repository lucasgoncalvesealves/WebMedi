package bean;

import java.util.List;
import model.clsMovimentacao;
import dao.MovimentacaoDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MovimentacaoBean {
	private MovimentacaoDAO movDAO = new MovimentacaoDAO();
	private clsMovimentacao itemSelecionado;
	private List<clsMovimentacao> listaItens;
	
	public MovimentacaoBean() {
		listaItens = movDAO.listaTodos();
	}

	public List<clsMovimentacao> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsMovimentacao> listaItens) {
		this.listaItens = listaItens;
	}

	public clsMovimentacao getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsMovimentacao itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
}

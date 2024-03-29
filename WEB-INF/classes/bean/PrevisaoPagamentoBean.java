package bean;

import java.util.List;
import model.clsPrevisaoPagamento;
import dao.PrevisaoPagamentoDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PrevisaoPagamentoBean {
	private PrevisaoPagamentoDAO prevDAO = new PrevisaoPagamentoDAO();
	private clsPrevisaoPagamento itemSelecionado;
	private List<clsPrevisaoPagamento> listaItens;
	
	public PrevisaoPagamentoBean() {
		listaItens = prevDAO.listaTodos();
	}

	public List<clsPrevisaoPagamento> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsPrevisaoPagamento> listaItens) {
		this.listaItens = listaItens;
	}

	public clsPrevisaoPagamento getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsPrevisaoPagamento itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
}

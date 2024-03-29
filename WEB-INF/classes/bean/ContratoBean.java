package bean;

import java.util.List;
import model.clsContrato;
import dao.ContratoDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ContratoBean {
	private ContratoDAO contraDAO = new ContratoDAO();
	private clsContrato itemSelecionado;
	private List<clsContrato> listaItens;
	
	public ContratoBean() {
		listaItens = contraDAO.listaTodos();
	}

	public List<clsContrato> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsContrato> listaItens) {
		this.listaItens = listaItens;
	}

	public clsContrato getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsContrato itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
}

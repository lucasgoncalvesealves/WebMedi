package bean;

import java.util.List;
import model.clsProcedimento;
import dao.ProcedimentoDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProcedimentoBean {
	private ProcedimentoDAO procedDAO = new ProcedimentoDAO();
	private clsProcedimento itemSelecionado;
	private List<clsProcedimento> listaItens;
	
	public ProcedimentoBean() {
		listaItens = procedDAO.listaTodos();
	}

	public List<clsProcedimento> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsProcedimento> listaItens) {
		this.listaItens = listaItens;
	}

	public clsProcedimento getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsProcedimento itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
}

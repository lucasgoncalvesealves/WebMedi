package bean;

import java.util.List;
import model.clsAtendente;
import dao.AtendenteDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AtendenteBean {
	private AtendenteDAO atendeDAO = new AtendenteDAO();
	private clsAtendente itemSelecionado;
	private List<clsAtendente> listaItens;
	
	public AtendenteBean() {
		listaItens = atendeDAO.listaTodos();
	}

	public List<clsAtendente> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsAtendente> listaItens) {
		this.listaItens = listaItens;
	}

	public clsAtendente getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsAtendente itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
}

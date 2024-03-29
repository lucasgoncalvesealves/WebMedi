package bean;

import java.util.List;
import model.clsMedico;
import dao.MedicoDAO;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MedicoBean {
	private MedicoDAO medDAO = new MedicoDAO();
	private clsMedico itemSelecionado;
	private List<clsMedico> listaItens;
	
	public MedicoBean() {
		listaItens = medDAO.listaTodos();
	}

	public List<clsMedico> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsMedico> listaItens) {
		this.listaItens = listaItens;
	}

	public clsMedico getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsMedico itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
}

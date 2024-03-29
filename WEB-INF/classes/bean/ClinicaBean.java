package bean;

import java.util.List;

import model.clsClinica;
import dao.ClinicaDAO;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ClinicaBean {
	private ClinicaDAO clinDAO = new ClinicaDAO();
	private clsClinica itemSelecionado;
	private List<clsClinica> listaItens;
	
	public ClinicaBean() {
		listaItens = clinDAO.listaTodos();
	}

	public List<clsClinica> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsClinica> listaItens) {
		this.listaItens = listaItens;
	}

	public clsClinica getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsClinica itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

}

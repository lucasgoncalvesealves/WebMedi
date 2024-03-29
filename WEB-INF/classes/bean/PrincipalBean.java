package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import dao.HibernateDAO;
import model.Hibernate;

@ManagedBean
public class PrincipalBean {
	
	private HibernateDAO hDAO = new HibernateDAO();
	private Hibernate itemSelecionado;
	private List<Hibernate> listaItens;

	public PrincipalBean() {
		listaItens = hDAO.listaTodos();
	}

	public List<Hibernate> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<Hibernate> listaItens) {
		this.listaItens = listaItens;
	}

	public Hibernate getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(Hibernate itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

}

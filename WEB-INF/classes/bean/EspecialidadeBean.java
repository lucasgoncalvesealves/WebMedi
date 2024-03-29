package bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import org.hibernate.exception.ConstraintViolationException;
import model.clsEspecialidade;
import dao.EspecialidadeDAO;

@ManagedBean
public class EspecialidadeBean {
	
	private EspecialidadeDAO EspDAO = new EspecialidadeDAO();
	private clsEspecialidade itemSelecionado;
	private List<clsEspecialidade> listaItens;
	
	public EspecialidadeBean() {
		listaItens = EspDAO.listaTodos();
	}

	public List<clsEspecialidade> getListaItens() {
		return listaItens;
	}

	public void setListaItens(List<clsEspecialidade> listaItens) {
		this.listaItens = listaItens;
	}

	public clsEspecialidade getItemSelecionado() {
		return itemSelecionado;
	}

	public void setItemSelecionado(clsEspecialidade itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}

	public String incluirEspecialidade(String nomEsp) {
		EspecialidadeDAO daoEsp = new EspecialidadeDAO();
		clsEspecialidade tabEsp = new clsEspecialidade();
		tabEsp.setDescricao(nomEsp);
		try {
			daoEsp.salvar(tabEsp);
			return "Inclusão Realizada com Sucesso!";
		}
		catch (ConstraintViolationException e) {
			return "Inclusão Não Realizada: Violação de Restrição do Banco de Dados!";
		}
		catch (Exception e) {
			return "Inclusão Não Realizada: " + e.getMessage();
		}
	}
}

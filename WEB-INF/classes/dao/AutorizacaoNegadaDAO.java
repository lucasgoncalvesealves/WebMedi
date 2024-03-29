package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import model.clsAutorizacaoNegada;

public class AutorizacaoNegadaDAO extends GenericDAO<Long, clsAutorizacaoNegada> {

	public AutorizacaoNegadaDAO() {
		this.persistentClass = clsAutorizacaoNegada.class;
	}

	@SuppressWarnings("unchecked")
	public List<clsAutorizacaoNegada> buscaPorCod(Long cod) {
		Criteria c = this.session.createCriteria(clsAutorizacaoNegada.class);
		c.add(Restrictions.eq("codAutorizacaoNegada", cod));
		return c.list();
	}

}

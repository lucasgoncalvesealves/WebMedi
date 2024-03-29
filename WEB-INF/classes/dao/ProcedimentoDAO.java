package dao;

import java.util.List;

import model.clsProcedimento;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ProcedimentoDAO extends GenericDAO<Long, clsProcedimento> {
	
	public ProcedimentoDAO() {
		this.persistentClass = clsProcedimento.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsProcedimento> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(clsProcedimento.class);
		c.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		return c.list();
	}

    @SuppressWarnings("unchecked")
	public List<clsProcedimento> listaTodos() {
    	Criteria c = session.createCriteria(persistentClass);
    	c.addOrder(Order.asc("nome"));
    	
    	return c.list();
    }
	
}

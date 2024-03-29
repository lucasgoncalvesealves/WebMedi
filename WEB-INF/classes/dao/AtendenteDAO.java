package dao;

import java.util.List;

import model.clsAtendente;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AtendenteDAO extends GenericDAO<Long, clsAtendente> {
	
	public AtendenteDAO() {
		this.persistentClass = clsAtendente.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsAtendente> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(clsAtendente.class);
		c.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		return c.list();
	}

    @SuppressWarnings("unchecked")
	public List<clsAtendente> listaTodos() {
    	Criteria c = session.createCriteria(persistentClass);
    	c.addOrder(Order.asc("nome"));
    	
    	return c.list();
    }
	
}
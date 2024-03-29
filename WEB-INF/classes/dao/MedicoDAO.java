package dao;

import java.util.List;

import model.clsMedico;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class MedicoDAO extends GenericDAO<Long, clsMedico> {
	
	public MedicoDAO() {
		this.persistentClass = clsMedico.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsMedico> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(clsMedico.class);
		c.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		return c.list();
	}

    @SuppressWarnings("unchecked")
	public List<clsMedico> listaTodos() {
    	Criteria c = session.createCriteria(persistentClass);
    	c.addOrder(Order.asc("nome"));
    	
    	return c.list();
    }
	
}

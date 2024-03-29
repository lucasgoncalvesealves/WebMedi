package dao;

import java.util.List;

import model.clsClinica;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ClinicaDAO extends GenericDAO<Long, clsClinica> {
	
	public ClinicaDAO() {
		this.persistentClass = clsClinica.class;
	}
	
	@SuppressWarnings("unchecked")
	public List<clsClinica> buscaPorNome(String nome) {
		Criteria c = this.session.createCriteria(clsClinica.class);
		c.add(Restrictions.like("nome", nome, MatchMode.ANYWHERE));
		return c.list();
	}

    @SuppressWarnings("unchecked")
	public List<clsClinica> listaTodos() {
    	Criteria c = session.createCriteria(persistentClass);
    	c.addOrder(Order.asc("nome"));
    	
    	return c.list();
    }
	
}
